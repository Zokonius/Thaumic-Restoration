package com.Zoko061602.ThaumicRestoration.blocks;

import java.util.ArrayList;

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

	public static final ArrayList<BlockBase> BLOCKS = new ArrayList<>();

    public static BlockBase blockReinforced = new BlockBase(Material.ROCK, "pickaxe", 2, 50F, 10F, "block_reinforced");
    public static BlockBase blockGreatwoodPlank = new BlockBase(Material.WOOD, "axe", 0, 2F, 2F, "block_greatwood");
    public static BlockBase blockGreatwoodFramed = new BlockBase(Material.WOOD, "axe", 0, 3F, 3F, "block_greatwood_framed");
    public static BlockBase blockInfuser = new BlockInfuser();
    public static BlockBase blockAdvRechargePed = new BlockAdvRechargePedestal();
    public static BlockBase blockCrystal = new BlockCrystal();
    public static BlockBase blockObsidian = new BlockObsidian();
//  public static BlockBase blockStorageUnit  = new BlockStorageUnit();
    public static BlockBase blockPavingAer = new BlockPavingAer();

    public static void registerBlocks(RegistryEvent.Register<Block> e) {
        for (BlockBase b : BLOCKS)
        	registerBlock(e, b);
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
        for (BlockBase b : BLOCKS)
        	registerItemBlock(e, b);
    }

    public static void registerRenders(ModelRegistryEvent e) {
        for (BlockBase b : BLOCKS)
    		registerRender(b);
    }

    private static void registerBlock(RegistryEvent.Register<Block> e, BlockBase b) {
		e.getRegistry().registerAll(b);
    }

	private static void registerItemBlock(RegistryEvent.Register<Item> e, BlockBase b) {
    	if(b instanceof BlockCrystal)
    		e.getRegistry().register(new ItemBlockCrystal());
    	else
    		e.getRegistry().registerAll(new ItemBlock(b).setRegistryName(b.getRegistryName()));
    }

    private static void registerRender(Block b) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation( Item.getItemFromBlock(b).getRegistryName(), "inventory"));
    }

}
