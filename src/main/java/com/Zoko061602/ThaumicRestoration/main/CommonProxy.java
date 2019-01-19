package com.Zoko061602.ThaumicRestoration.main;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.compat.RestoredCompatModule;
import com.Zoko061602.ThaumicRestoration.compat.crafttweaker.CraftTweakerCompat;
import com.Zoko061602.ThaumicRestoration.crafting.TR_OreDict;
import com.Zoko061602.ThaumicRestoration.crafting.TR_Research;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.tile.TR_Tiles;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {


	public void preInit(FMLPreInitializationEvent e) {
		TR_Items.initItems();
		TR_Blocks.initBlocks();
		TR_Tiles.initTiles();
		RestoredCompatModule.loadPreInit();
	}


	public void init(FMLInitializationEvent e){
		TR_OreDict.addOreDict();
		RestoredCompatModule.loadInit();

	}


	public void postInit(FMLPostInitializationEvent e) {
		RestoredCompatModule.loadPostInit();
		TR_Research.createResearch();

	}

	public void loadComplete(FMLLoadCompleteEvent e) {
	 if(Loader.isModLoaded("crafttweaker"))
	  CraftTweakerCompat.loadComplete(e);
	}

}
