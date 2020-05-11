package com.Zoko061602.ThaumicRestoration.items;

import com.Zoko061602.ThaumicRestoration.main.TR_Tab;

import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(TR_Tab.tabRestoration);
        TR_Items.ITEMS.add(this);
    }

}
