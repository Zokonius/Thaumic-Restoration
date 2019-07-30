package com.Zoko061602.ThaumicRestoration.blocks;

import com.Zoko061602.ThaumicRestoration.items.block.ItemBlockCrystal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class TR_Blocks {

	public static Block blockReinforced = new BlockBase(Material.ROCK, "pickaxe", 2, 50F, 10F, "block_reinforced");
	public static Block blockGreatwoodPlank = new BlockBase(Material.WOOD, "axe", 0, 2F, 2F, "block_greatwood");
	public static Block blockGreatwoodFramed = new BlockBase(Material.WOOD, "axe", 0, 3F, 3F, "block_greatwood_framed");
	public static Block blockInfuser = new BlockInfuser();
	public static Block blockAdvRechargePed = new BlockAdvRechargePedestal();
	public static Block blockCrystal = new BlockCrystal();
	public static Block blockObsidian = new BlockObsidian();
	public static Block blockStorageUnit  = new BlockStorageUnit();
	public static Block blockPavingAer = new BlockPavingAer();

	public static void registerBlocks(RegistryEvent.Register<Block> e){
      registerBlock(e, blockReinforced);
      registerBlock(e, blockGreatwoodPlank);
      registerBlock(e, blockGreatwoodFramed);
      registerBlock(e, blockInfuser);
      registerBlock(e, blockAdvRechargePed);
      registerBlock(e, blockObsidian);
      registerBlock(e, blockPavingAer);
      registerBlock(e, blockCrystal);
    //  registerBlock(e, blockStorageUnit);
	}

	public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
		registerItemBlock(e, blockReinforced);
		registerItemBlock(e, blockGreatwoodPlank);
		registerItemBlock(e, blockGreatwoodFramed);
		registerItemBlock(e, blockInfuser);
		registerItemBlock(e, blockAdvRechargePed);
		registerItemBlock(e, blockObsidian);
		registerItemBlock(e, blockPavingAer);
	//	registerItemBlock(e, blockStorageUnit);
	    e.getRegistry().register(new ItemBlockCrystal(blockCrystal).setRegistryName(blockCrystal.getRegistryName()));
	 }

	public static void registerRenders(ModelRegistryEvent e) {
	 registerRender(blockReinforced);
	 registerRender(blockGreatwoodPlank);
	 registerRender(blockGreatwoodFramed);
	 registerRender(blockInfuser);
	 registerRender(blockAdvRechargePed);
	 registerRender(blockObsidian);
	 registerRender(blockPavingAer);
	 registerRender(blockCrystal);
	// registerRender(blockStorageUnit);
	}

	private static void registerBlock(RegistryEvent.Register<Block> e, Block b){
	 e.getRegistry().register(b);
	}

	private static void registerItemBlock(RegistryEvent.Register<Item> e, Block b){
	 e.getRegistry().registerAll(new ItemBlock(b).setRegistryName(b.getRegistryName()));
	}

	private static void registerRender(Block b) {
	 ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation( Item.getItemFromBlock(b).getRegistryName(), "inventory"));
	}


}
