package com.Zoko061602.ThaumicReadoption.items;

import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;

import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ReadoptedTab.tabReadopted);
	}

}
