package com.Zoko061602.ThaumicRestoration.items;

import com.Zoko061602.ThaumicRestoration.items.baubles.ItemRingWither;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class TR_Items {

	public static Item itemWand;
	public static Item itemIngot;
	public static Item itemTRBucket;
	public static Item itemToast;
	public static Item itemWandCap;
	public static Item itemWandRod;
	public static Item itemWitherRing;

	public static void initItems() {
		itemWand = new ItemWand();
		itemIngot = new ItemIngot();
		itemTRBucket = new ItemTRBucket();
		itemToast = new ItemToast();
		itemWandCap = new ItemBase("item_wandcap");
		itemWandRod = new ItemBase("item_wandrod");
		itemWitherRing = new ItemRingWither();
	}

	public static void registerItems(RegistryEvent.Register<Item> e){
		e.getRegistry().registerAll(itemWand);
		e.getRegistry().register(itemWandCap);
		e.getRegistry().register(itemWandRod);
		e.getRegistry().registerAll(itemIngot);
		e.getRegistry().register(itemTRBucket);
		e.getRegistry().register(itemToast);
        e.getRegistry().register(itemWitherRing);

	}

	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(itemWand, 2);
		registerRender(itemIngot, 5);
		registerRender(itemWandCap);
		registerRender(itemWandRod);
		registerRender(itemTRBucket);
		registerRender(itemToast);
		registerRender(itemWitherRing);


	}

	private static void registerRender(Item item, int Maxmeta) {
		for(int i=0;!(i==Maxmeta+1);i++)
		ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName()+"_"+i,"inventory"));
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

}
