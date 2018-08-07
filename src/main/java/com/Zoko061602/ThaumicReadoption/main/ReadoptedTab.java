package com.Zoko061602.ThaumicReadoption.main;

import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ReadoptedTab extends CreativeTabs {

	public static final ReadoptedTab tabReadopted = new ReadoptedTab();

	private ReadoptedTab() {
		super("tabreadopted");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ReadoptedItems.itemWand, 1, 0);
	}

}
