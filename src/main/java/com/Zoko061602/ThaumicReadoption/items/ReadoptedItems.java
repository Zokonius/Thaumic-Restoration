package com.Zoko061602.ThaumicReadoption.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class ReadoptedItems {

	public static Item itemWand;
	public static Item itemIngot;

	public static void initItems() {
		itemWand = new ItemWand();
		itemIngot = new ItemIngot();
	}

	public static void registerItems(RegistryEvent.Register<Item> e){
		e.getRegistry().registerAll(itemWand);
		e.getRegistry().registerAll(itemIngot);

	}

	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(itemWand);
		registerRender(itemIngot, 5);
	}

	private static void registerRender(Item item, int Maxmeta) {
		for(int i=0;!(i==Maxmeta+1);i++)
		ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName()+"_"+i,"inventory"));
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

}
