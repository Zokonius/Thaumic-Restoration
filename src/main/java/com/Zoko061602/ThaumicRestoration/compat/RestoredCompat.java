package com.Zoko061602.ThaumicRestoration.compat;

import java.util.ArrayList;
import java.util.HashMap;

import com.Zoko061602.ThaumicRestoration.compat.crafttweaker.CraftTweakerCompat;
import com.Zoko061602.ThaumicRestoration.compat.tconstruct.TConstructCompat;
import com.Zoko061602.ThaumicRestoration.compat.thaumicwands.ThaumicWandsCompat;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RestoredCompat {

    public static HashMap<String, Class<? extends IRestoredCompatModule>> compat = new HashMap<>();
    public static ArrayList<IRestoredCompatModule> modules = new ArrayList<IRestoredCompatModule>();


    static {
        compat.put("crafttweaker", CraftTweakerCompat.class);
        compat.put("tconstruct", TConstructCompat.class);
        compat.put("thaumicwands", ThaumicWandsCompat.class);
    }

    public static void loadPreInit(FMLPreInitializationEvent e){
        for (String s : compat.keySet())
            if(Loader.isModLoaded(s))
                try {
                    modules.add((IRestoredCompatModule) compat.get(s).newInstance());
                } catch(Exception ex) {}

        for (IRestoredCompatModule m : modules)
            m.preInit(e);

    }

    public static void loadInit(FMLInitializationEvent e) {
        for (IRestoredCompatModule m : modules)
            m.init(e);
    }

    public static void loadPostInit(FMLPostInitializationEvent e) {
        for (IRestoredCompatModule m : modules)
            m.postInit(e);
    }


    public static void loadLoadComplete(FMLLoadCompleteEvent e) {
        for (IRestoredCompatModule m : modules)
            m.loadComplete(e);
    }




    public interface IRestoredCompatModule {

        public default void preInit(FMLPreInitializationEvent e) {}

        public default void init(FMLInitializationEvent e) {}

        public default void postInit(FMLPostInitializationEvent e) {}

        public default void loadComplete(FMLLoadCompleteEvent e) {}

        @SideOnly(Side.CLIENT)
        public default void clientPreInit(FMLPreInitializationEvent e) {}

        @SideOnly(Side.CLIENT)
        public default void clientInit(FMLInitializationEvent e) {}

        @SideOnly(Side.CLIENT)
        public default void clientPostInit(FMLPostInitializationEvent e) {}

    }

}
