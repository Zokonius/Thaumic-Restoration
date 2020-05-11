package com.Zoko061602.ThaumicRestoration.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import thaumcraft.common.tiles.TileThaumcraftInventory;

public class TileStorageUnit extends TileThaumcraftInventory {

	public TileStorageUnit() {
		super(1);
		syncedSlots = new int[]{0};
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack stack2, EnumFacing par3) {
		if ((par1 != 0)
		|| (stack2.getCount()+getSyncedStackInSlot(0).getCount()>Integer.MAX_VALUE))
			return false;
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack stack2){
		if (getSyncedStackInSlot(0).isEmpty())
			return true;
		if (getSyncedStackInSlot(0).getItem() != stack2.getItem())
			return false;
		if (getSyncedStackInSlot(0).getCount() + stack2.getCount() <= Integer.MAX_VALUE)
			return true;
	    return false;
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

}
