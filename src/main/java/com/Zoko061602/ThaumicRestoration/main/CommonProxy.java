package com.Zoko061602.ThaumicRestoration.main;

import com.Zoko061602.ThaumicRestoration.compat.RestoredCompat;
import com.Zoko061602.ThaumicRestoration.crafting.TR_Aspects;
import com.Zoko061602.ThaumicRestoration.crafting.TR_OreDict;
import com.Zoko061602.ThaumicRestoration.crafting.TR_Research;
import com.Zoko061602.ThaumicRestoration.tile.TR_Tiles;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        TR_Tiles.initTiles();
        RestoredCompat.loadPreInit(e);
    }

    public void init(FMLInitializationEvent e){
        TR_OreDict.addOreDict();
        RestoredCompat.loadInit(e);
    }

    public void postInit(FMLPostInitializationEvent e) {
        TR_Aspects.addAspects();
        TR_Research.createHelps();
        TR_Research.createResearch();
        RestoredCompat.loadPostInit(e);
    }

    public void loadComplete(FMLLoadCompleteEvent e) {
        RestoredCompat.loadLoadComplete(e);
    }

}
