package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.items.TR_Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class TR_OreDict {

   public static void addOreDict() {
	   addPrimal("ingotThaumium", TR_Items.itemIngot);
	   addPrimal("plateThaumium", TR_Items.itemPlate);
   }

   private static void addPrimal(String ore, Item item){
	   String[] p = new String[]{"Aer","Ignis","Aqua","Terra","Ordo","Perditio"};
	   for(int i=0;!(p.length==i);i++)
	   OreDictionary.registerOre(ore+p[i], new ItemStack(item,1,i));
   }

}
