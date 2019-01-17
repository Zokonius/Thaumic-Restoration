package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.items.TR_Items;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class TR_OreDict {

   public static void addOreDict() {
	 OreDictionary.registerOre("ingotThaumiumAer", new ItemStack(TR_Items.itemIngot,1,0));
	 OreDictionary.registerOre("ingotThaumiumIgnis", new ItemStack(TR_Items.itemIngot,1,1));
	 OreDictionary.registerOre("ingotThaumiumAqua", new ItemStack(TR_Items.itemIngot,1,2));
	 OreDictionary.registerOre("ingotThaumiumTerra", new ItemStack(TR_Items.itemIngot,1,3));
	 OreDictionary.registerOre("ingotThaumiumOrdo", new ItemStack(TR_Items.itemIngot,1,4));
	 OreDictionary.registerOre("ingotThaumiumPerditio", new ItemStack(TR_Items.itemIngot,1,5));

   }

}
