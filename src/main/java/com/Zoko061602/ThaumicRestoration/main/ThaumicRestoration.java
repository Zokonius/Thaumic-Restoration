package com.Zoko061602.ThaumicRestoration.main;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ThaumicRestoration.ModID, name=ThaumicRestoration.ModName, version=ThaumicRestoration.Version, dependencies=ThaumicRestoration.Dependencies)
public class ThaumicRestoration {

	public static final String ModID = "thaumicrestoration";
	public static final String ModName = "Thaumic Restoration";
	public static final String Version = "1.2.1b";
	public static final String Dependencies = "required-after:thaumcraft;"+
	                                          "after:tconstruct;"+
	                                          "after:crafttweaker";


	@SidedProxy(clientSide="com.Zoko061602.ThaumicRestoration.client.ClientProxy", serverSide="com.Zoko061602.ThaumicRestoration.main.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e){
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
