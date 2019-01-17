package com.Zoko061602.ThaumicRestoration.compat;

import java.util.ArrayList;
import java.util.HashMap;

import com.Zoko061602.ThaumicRestoration.compat.tconstruct.TConstructCompat;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class RestoredCompatModule {

	public static HashMap<String,Class> compat = new HashMap<>();
	public static ArrayList<RestoredCompatModule> modules = new ArrayList<RestoredCompatModule>();


	static {
		compat.put("tconstruct", TConstructCompat.class);

	}

	public static void loadPreInit(){
		for(String s:compat.keySet()) {
			if(Loader.isModLoaded(s)) {
				try {
				modules.add((RestoredCompatModule) compat.get(s).newInstance());
				}
				catch(Exception ex){}
			}
		}

		for(RestoredCompatModule m:modules)
			m.preInit();

	}

	public static void loadInit(){
	 for(RestoredCompatModule m:modules)
		m.init();
	}

	public static void loadPostInit(){
	 for(RestoredCompatModule m:modules)
		m.postInit();
	}


	public abstract void preInit();

	public abstract void init();

	public abstract void postInit();

	public void loadComplete()
	{
	}

	@SideOnly(Side.CLIENT)
	public void clientPreInit()
	{
	}

	@SideOnly(Side.CLIENT)
	public void clientInit()
	{
	}

	@SideOnly(Side.CLIENT)
	public void clientPostInit()
	{
	}
}
