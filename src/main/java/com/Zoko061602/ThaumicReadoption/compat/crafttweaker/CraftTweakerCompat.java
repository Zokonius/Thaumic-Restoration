package com.Zoko061602.ThaumicReadoption.compat.crafttweaker;

import java.util.LinkedList;
import java.util.List;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;

public class CraftTweakerCompat {

    public static final List<IAction> lateRemovals = new LinkedList<>();
    public static final List<IAction> lateAdditions = new LinkedList<>();

    public static void loadComplete(FMLLoadCompleteEvent e){
        try {
            lateRemovals.forEach(CraftTweakerAPI::apply);
            lateAdditions.forEach(CraftTweakerAPI::apply);
        } catch(Exception ex) {
            ex.printStackTrace();
            CraftTweakerAPI.logError("Error while applying actions", ex);
        }
    }


}
