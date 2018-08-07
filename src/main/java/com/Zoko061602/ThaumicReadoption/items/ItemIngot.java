package com.Zoko061602.ThaumicReadoption.items;

import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemIngot extends Item {

	public ItemIngot() {
		this.setRegistryName("item_ingot");
		this.setHasSubtypes(true);
		this.setUnlocalizedName("item_ingot");
		this.setCreativeTab(ReadoptedTab.tabReadopted);


	}


    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for(int i=0;!(i==6); i++)
        	if(tab == this.getCreativeTab())
        	items.add(new ItemStack(this, 1, i));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
    	return "item_ingot_"+stack.getItemDamage();
    }
}
