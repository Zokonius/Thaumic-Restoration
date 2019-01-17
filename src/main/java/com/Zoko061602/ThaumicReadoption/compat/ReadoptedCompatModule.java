package com.Zoko061602.ThaumicReadoption.compat;

import java.util.ArrayList;
import java.util.HashMap;

import com.Zoko061602.ThaumicReadoption.compat.tconstruct.TConstructCompat;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ReadoptedCompatModule {

	public static HashMap<String,ReadoptedCompatModule> compat = new HashMap<>();
	public static ArrayList<ReadoptedCompatModule> modules = new ArrayList<ReadoptedCompatModule>();


	static {
		compat.put("tconstruct", new TConstructCompat());

	}

	public static void loadPreInit(){
		for(String s:compat.keySet()) {
			if(Loader.isModLoaded(s)) {
				modules.add(compat.get(s));
				compat.get(s).preInit();
			}
		}

	}

	public static void loadInit(){
	 for(ReadoptedCompatModule m:modules)
		m.init();
	}

	public static void loadPostInit(){
	 for(ReadoptedCompatModule m:modules)
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
