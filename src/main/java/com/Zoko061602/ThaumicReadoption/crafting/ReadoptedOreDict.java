package com.Zoko061602.ThaumicReadoption.crafting;

import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ReadoptedOreDict {

   public static void addOreDict() {
	 OreDictionary.registerOre("ingotThaumiumAer", new ItemStack(ReadoptedItems.itemIngot,1,0));
	 OreDictionary.registerOre("ingotThaumiumIgnis", new ItemStack(ReadoptedItems.itemIngot,1,1));
	 OreDictionary.registerOre("ingotThaumiumAqua", new ItemStack(ReadoptedItems.itemIngot,1,2));
	 OreDictionary.registerOre("ingotThaumiumTerra", new ItemStack(ReadoptedItems.itemIngot,1,3));
	 OreDictionary.registerOre("ingotThaumiumOrdo", new ItemStack(ReadoptedItems.itemIngot,1,4));
	 OreDictionary.registerOre("ingotThaumiumPerditio", new ItemStack(ReadoptedItems.itemIngot,1,5));

   }

}
