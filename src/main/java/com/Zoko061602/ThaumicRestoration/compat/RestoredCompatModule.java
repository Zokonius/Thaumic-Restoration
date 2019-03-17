package com.Zoko061602.ThaumicRestoration.compat;

import java.util.ArrayList;
import java.util.HashMap;

import com.Zoko061602.ThaumicRestoration.compat.crafttweaker.CraftTweakerCompat;
import com.Zoko061602.ThaumicRestoration.compat.tconstruct.TConstructCompat;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class RestoredCompatModule {

	public static HashMap<String,Class<? extends RestoredCompatModule>> compat = new HashMap<>();
	public static ArrayList<RestoredCompatModule> modules = new ArrayList<RestoredCompatModule>();


	static {
		compat.put("crafttweaker", CraftTweakerCompat.class);
		compat.put("tconstruct", TConstructCompat.class);
	}

	public static void loadPreInit(FMLPreInitializationEvent e){
		for(String s:compat.keySet())
		 if(Loader.isModLoaded(s))
		  try{
			  modules.add((RestoredCompatModule) compat.get(s).newInstance());
		  }
		  catch(Exception ex){}

		for(RestoredCompatModule m:modules)
			m.preInit(e);

	}

	public static void loadInit(FMLInitializationEvent e){
	 for(RestoredCompatModule m:modules)
		m.init(e);
	}

	public static void loadPostInit(FMLPostInitializationEvent e){
	 for(RestoredCompatModule m:modules)
		m.postInit(e);
	}


	public static void loadLoadComplete(FMLLoadCompleteEvent e) {
	 for(RestoredCompatModule m:modules)
		m.loadComplete(e);
	}


	public void preInit(FMLPreInitializationEvent e) {}

	public void init(FMLInitializationEvent e) {}

	public void postInit(FMLPostInitializationEvent e) {}

	public void loadComplete(FMLLoadCompleteEvent e) {}

	@SideOnly(Side.CLIENT)
	public void clientPreInit(FMLPreInitializationEvent e) {}

	@SideOnly(Side.CLIENT)
	public void clientInit(FMLInitializationEvent e) {}

	@SideOnly(Side.CLIENT)
	public void clientPostInit(FMLPostInitializationEvent e) {}

}
