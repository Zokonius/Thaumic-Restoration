package com.Zoko061602.ThaumicReadoption.main;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ThaumicReadoption.ModID, name=ThaumicReadoption.ModName, version=ThaumicReadoption.Version, dependencies=ThaumicReadoption.Dependencies)
public class ThaumicReadoption {

	public static final String ModID = "thaumicreadoption";
	public static final String ModName = "Thaumic Readoption";
	public static final String Version = "0.1.0";
	public static final String Dependencies = "required-after:thaumcraft;"+
	                                          "after:crafttweaker";


	@SidedProxy(clientSide="com.Zoko061602.ThaumicReadoption.client.ClientProxy", serverSide="com.Zoko061602.ThaumicReadoption.main.CommonProxy")
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
