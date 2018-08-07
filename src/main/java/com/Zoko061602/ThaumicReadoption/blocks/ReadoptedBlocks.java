package com.Zoko061602.ThaumicReadoption.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class ReadoptedBlocks {

	public static Block blockReinforced;
	public static Block blockInfuser;

	public static void initBlocks() {
		blockReinforced = new BlockReinforced();
		blockInfuser = new BlockInfuser();
	}

	public static void registerBlocks(RegistryEvent.Register<Block> e){
     e.getRegistry().registerAll(blockReinforced);
     e.getRegistry().registerAll(blockInfuser);
	}

	public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
	 e.getRegistry().registerAll(new ItemBlock(blockReinforced).setRegistryName(blockReinforced.getRegistryName()));
	 e.getRegistry().registerAll(new ItemBlock(blockInfuser).setRegistryName(blockInfuser.getRegistryName()));
	}

	public static void registerRenders(ModelRegistryEvent e) {
	 registerRender(Item.getItemFromBlock(blockReinforced));
	 registerRender(Item.getItemFromBlock(blockInfuser));

	}

	private static void registerRender(Item item) {
	 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}

}
