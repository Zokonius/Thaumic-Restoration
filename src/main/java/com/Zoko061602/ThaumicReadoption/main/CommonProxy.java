package com.Zoko061602.ThaumicReadoption.main;

import com.Zoko061602.ThaumicReadoption.blocks.ReadoptedBlocks;
import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;
import com.Zoko061602.ThaumicReadoption.tile.ReadoptedTiles;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {


	public void preInit(FMLPreInitializationEvent e) {
		ReadoptedItems.initItems();
		ReadoptedBlocks.initBlocks();
		ReadoptedTiles.initTiles();
	}


	public void init(FMLInitializationEvent e){

	}


	public void postInit(FMLPostInitializationEvent e) {

	}

}
