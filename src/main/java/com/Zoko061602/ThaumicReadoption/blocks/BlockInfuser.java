package com.Zoko061602.ThaumicReadoption.blocks;

import com.Zoko061602.ThaumicReadoption.items.ItemWand;
import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;
import com.Zoko061602.ThaumicReadoption.tile.TileInfuser;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.common.lib.utils.InventoryUtils;

public class BlockInfuser extends Block implements ITileEntityProvider {

	public BlockInfuser() {
		super(Material.IRON);
		this.setHarvestLevel("pickaxe", 1);
		this.setUnlocalizedName("block_infuser");
		this.setRegistryName("block_infuser");
		this.setCreativeTab(ReadoptedTab.tabReadopted);
		this.setHardness(3F);
		this.setResistance(3F);
	}

	  public boolean isOpaqueCube(IBlockState state){
	    return false;
	  }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileInfuser();
	}

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
        if (!hasTileEntity){
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof TileInfuser){
                InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tile);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
	    if(world.isRemote) return true;
	    TileEntity tile = world.getTileEntity(pos);
	    if((tile != null) && ((tile instanceof TileInfuser))){
	    	TileInfuser ped = (TileInfuser)tile;
	        if((ped.getStackInSlot(0).isEmpty()) && (!player.inventory.getCurrentItem().isEmpty()) && (player.inventory.getCurrentItem().getCount() > 0)){
	          ItemStack i = player.getHeldItem(hand).copy();
	          i.setCount(1);
	          ped.setInventorySlotContents(0, i);
	          player.getHeldItem(hand).shrink(1);
	          if(player.getHeldItem(hand).getCount() == 0)
	             player.setHeldItem(hand, ItemStack.EMPTY);
	          player.inventory.markDirty();
	          world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.2F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 1.6F);
	          return true;
	        }
	        if(!ped.getStackInSlot(0).isEmpty()){
	        	if(!player.inventory.getCurrentItem().isEmpty()&&player.inventory.getCurrentItem().getItem() instanceof ItemWand) {
	        		if(ItemWand.getVis(player.inventory.getCurrentItem())>=50) {
	        			if(ped.activate(player))
	        			ItemWand.consumeVis(player.inventory.getCurrentItem(), 50);
	        			return true;
	        		}
	        	}
	        else {
	        InventoryUtils.dropItemsAtEntity(world, pos, player);
	        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.2F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 1.5F);
	        }
	        return true;
	        }
	    }

	    return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
	  }


}
