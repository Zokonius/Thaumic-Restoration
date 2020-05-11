package com.Zoko061602.ThaumicRestoration.items;

import javax.annotation.Nullable;

import com.Zoko061602.ThaumicRestoration.main.TR_Tab;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemTRBucket extends ItemBucket {
    
    public ItemTRBucket() {
        super(Blocks.FLOWING_WATER);
        this.setRegistryName("item_bucket");
        this.setHasSubtypes(true);
        this.setUnlocalizedName("item_bucket");
        this.setCreativeTab(TR_Tab.tabRestoration);
    }
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, false);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
        
        if (ret != null)
            return ret;
        
        if (raytraceresult == null)
            return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        
        else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
            return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        
        else {
            BlockPos blockpos = raytraceresult.getBlockPos();
            
            if (!worldIn.isBlockModifiable(playerIn, blockpos))
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
            
            else {
                boolean flag1 = worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
                BlockPos blockpos1 = flag1 && raytraceresult.sideHit == EnumFacing.UP ? blockpos : blockpos.offset(raytraceresult.sideHit);
                
                if (!playerIn.canPlayerEdit(blockpos1, raytraceresult.sideHit, itemstack))
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
                
                else if (tryPlaceContainedLiquid(playerIn, worldIn, blockpos1)) {
                    if (playerIn instanceof EntityPlayerMP)
                        CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, blockpos1, itemstack);
                    
                    playerIn.addStat(StatList.getObjectUseStats(this));
                    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
                }
                
                else
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
            }
        }
    }
    
    public boolean tryPlaceContainedLiquid(@Nullable EntityPlayer player, World worldIn, BlockPos posIn){
        IBlockState iblockstate = worldIn.getBlockState(posIn);
        Material material = iblockstate.getMaterial();
        boolean flag = !material.isSolid();
        boolean flag1 = iblockstate.getBlock().isReplaceable(worldIn, posIn);
        
        if (!worldIn.isAirBlock(posIn) && !flag && !flag1)
            return false;
        
        else if (worldIn.provider.doesWaterVaporize()) {
            int l = posIn.getX();
            int i = posIn.getY();
            int j = posIn.getZ();
            worldIn.playSound(player, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);
            
            for (int k = 0; k < 8; ++k)
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0D, 0.0D, 0.0D);
        }
        
        else {
            if (!worldIn.isRemote && (flag || flag1) && !material.isLiquid())
                worldIn.destroyBlock(posIn, true);
            SoundEvent soundevent = SoundEvents.ITEM_BUCKET_EMPTY;
            worldIn.playSound(player, posIn, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            worldIn.setBlockState(posIn, Blocks.FLOWING_WATER.getDefaultState(), 11);
        }
        
        return true;
    }
    
}
