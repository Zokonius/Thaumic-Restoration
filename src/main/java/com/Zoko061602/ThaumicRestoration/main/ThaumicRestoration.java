package com.Zoko061602.ThaumicRestoration.main;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ThaumicRestoration.modID, name=ThaumicRestoration.modName, version=ThaumicRestoration.version, dependencies=ThaumicRestoration.dependencies)
public class ThaumicRestoration {

    public static final String modID = "thaumicrestoration";
    public static final String modName = "Thaumic Restoration";
    public static final String version = "1.5.0";
    public static final String dependencies = "required-after:thaumcraft;"+
                                                "after:jei;"+
                                                "after:tconstruct;"+
                                                "after:thaumicwands;"+
                                                "after:crafttweaker";


    @SidedProxy(clientSide="com.Zoko061602.ThaumicRestoration.client.ClientProxy", serverSide="com.Zoko061602.ThaumicRestoration.main.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @EventHandler
    public void loadComplete(FMLLoadCompleteEvent e) {
        proxy.loadComplete(e);
    }

}
