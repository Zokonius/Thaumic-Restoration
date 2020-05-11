package com.Zoko061602.ThaumicRestoration.blocks;

import com.Zoko061602.ThaumicRestoration.tile.TileStorageUnit;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
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

public class BlockStorageUnit extends BlockBase implements ITileEntityProvider {
    
    public BlockStorageUnit() {
        super(Material.WOOD, "axe", 0, 3.0F, 10F, "block_storage_unit");
    }
    
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileStorageUnit();
    }
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!hasTileEntity) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof TileStorageUnit) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tile);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }
        
        super.breakBlock(worldIn, pos, state);
    }
    
    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
        if (!world.isRemote)
            return;
        
        TileEntity tile = world.getTileEntity(pos);
        if (tile == null || !(tile instanceof TileStorageUnit)) 
            return;
        
        TileStorageUnit sto = (TileStorageUnit)tile;
        ItemStack is;
        if (sto.getSyncedStackInSlot(0).isEmpty())
            return;
        
        if (player.isSneaking()) {
            is = sto.getSyncedStackInSlot(0).copy();
            
            if (is.getCount() >= 64) {
                sto.decrStackSize(0, 64);
                is.setCount(64);
            }
            else
                sto.decrStackSize(0, is.getCount());
            
            EntityItem entityItem = new EntityItem(world, player.posX, player.posY + player.getEyeHeight() / 2.0F, player.posZ, is.copy());
            world.spawnEntity(entityItem);
            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.2F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 1.5F);
        }
        
        else {
            is = sto.getSyncedStackInSlot(0).copy();
            
            if (is.getCount() >= 1) {
                sto.decrStackSize(0, 1);
                is.setCount(1);
            }
            else 
                sto.decrStackSize(0, is.getCount());
            
            EntityItem entityItem = new EntityItem(world, player.posX, player.posY + player.getEyeHeight() / 2.0F, player.posZ, is.copy());
            world.spawnEntity(entityItem);
            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.2F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 1.5F);
        }
        
        player.inventory.markDirty();
        sto.markDirty();
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) 
            return true;
        TileEntity tile = world.getTileEntity(pos);
        if (tile == null || !(tile instanceof TileStorageUnit)) 
            return false;
        TileStorageUnit sto = (TileStorageUnit) tile;
        
        if (sto.getStackInSlot(0).isEmpty()) {
            if (!player.getHeldItem(hand).isEmpty()) {
                ItemStack is = player.getHeldItem(hand).copy();
                sto.setInventorySlotContents(0, is);
                player.setHeldItem(hand, ItemStack.EMPTY);
                player.inventory.markDirty();
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.2F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 1.6F);
                return true;
            }
        }
        
        if (player.inventory.getCurrentItem().isEmpty())
        for(int i = 0; !(i == player.inventory.mainInventory.size()); i++) {
            ItemStack is = player.inventory.mainInventory.get(i);
            if(!is.isEmpty())
                if(is.getItem() == sto.getStackInSlot(0).getItem()) {
                    ItemStack s = new ItemStack(is.getItem(),is.getCount()+sto.getStackInSlot(0).getCount());
                    player.inventory.mainInventory.set(i, ItemStack.EMPTY);
                    sto.setInventorySlotContents(0, s);
                }
        }
        return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    }
    
}
