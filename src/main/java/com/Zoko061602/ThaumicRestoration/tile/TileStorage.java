package com.Zoko061602.ThaumicRestoration.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import thaumcraft.common.tiles.TileThaumcraftInventory;

public class TileStorage extends TileThaumcraftInventory {

	private int rotation=0;

	public TileStorage() {
		super(1);
		syncedSlots = new int[]{0};
	}

	@Override
	public void update() {
		if(rotation>=360)rotation=0;
		rotation++;

	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack stack2){
	    return (stack2.isEmpty()) || (getStackInSlot(par1).isEmpty());
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		return super.writeToNBT(compound);
	}

	@Override
	public int getInventoryStackLimit() {
		return Integer.MAX_VALUE;
	}

	public int getRotation() {
		return rotation;
	}



}
