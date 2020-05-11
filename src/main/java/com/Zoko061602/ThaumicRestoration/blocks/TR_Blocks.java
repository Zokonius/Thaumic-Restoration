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

import javax.swing.plaf.synth.SynthScrollBarUI;

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

    private static final Block[] blocks = { blockReinforced, blockGreatwoodPlank, blockGreatwoodFramed, blockInfuser, blockAdvRechargePed, blockCrystal, blockObsidian, blockPavingAer };
    // omitted blockStorageUnit

    public static void registerBlocks(RegistryEvent.Register<Block> e) {
        for (Block b : blocks) e.getRegistry().register(b);
    }
    
    public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
        for (Block b : blocks) if (b != blockCrystal) registerItemBlock(e, b);
        e.getRegistry().register(new ItemBlockCrystal(blockCrystal).setRegistryName(blockCrystal.getRegistryName()));
    }
    
    public static void registerRenders(ModelRegistryEvent e) {
        for (Block b : blocks) registerRender(b);
    }
    
    private static void registerItemBlock(RegistryEvent.Register<Item> e, Block b) {
        e.getRegistry().registerAll(new ItemBlock(b).setRegistryName(b.getRegistryName()));
    }
    
    private static void registerRender(Block b) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation( Item.getItemFromBlock(b).getRegistryName(), "inventory"));
    }
    
}
