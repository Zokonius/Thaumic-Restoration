package com.Zoko061602.ThaumicReadoption.blocks;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class ReadoptedBlocks {

	public static Block blockReinforced;
	public static Block blockGreatwoodPlank;
	public static Block blockGreatwoodFramed;
	public static Block blockInfuser;
	public static Block blockAdvRechargePed;

	private static ArrayList<Block> blocks = new ArrayList<Block>();

	public static void initBlocks() {
		blocks.add(blockReinforced = new BlockBase(Material.ROCK, "pickaxe", 2, 50F, 10F, "block_reinforced"));
		blocks.add(blockGreatwoodPlank = new BlockBase(Material.WOOD, "axe", 0, 2F, 2F, "block_greatwood"));
		blocks.add(blockGreatwoodFramed = new BlockBase(Material.WOOD, "axe", 0, 3F, 3F, "block_greatwood_framed"));
		blocks.add(blockInfuser = new BlockInfuser());
		blocks.add(blockAdvRechargePed = new BlockAdvRechargePedestal());

	}

	public static void registerBlocks(RegistryEvent.Register<Block> e){
	 for(Block b:blocks)
     e.getRegistry().registerAll(b);
	}

	public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
	  for(Block b:blocks)
	   e.getRegistry().registerAll(new ItemBlock(b).setRegistryName(b.getRegistryName()));
	 }

	public static void registerRenders(ModelRegistryEvent e) {
	 for(Block b:blocks)
	 registerRender(Item.getItemFromBlock(b));
	}

	private static void registerRender(Item item) {
	 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}

}
