package com.Zoko061602.ThaumicRestoration.main;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TR_Tab extends CreativeTabs {

    public static final TR_Tab tabRestoration = new TR_Tab();

    private TR_Tab() {
        super("tabrestoration");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(TR_Blocks.blockInfuser);
    }

}
