package com.Zoko061602.ThaumicRestoration.compat.crafttweaker;

import java.util.LinkedList;
import java.util.List;

import com.Zoko061602.ThaumicRestoration.compat.RestoredCompat.IRestoredCompatModule;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;

public class CraftTweakerCompat implements IRestoredCompatModule {

    public static final List<IAction> lateRemovals = new LinkedList<>();
    public static final List<IAction> lateAdditions = new LinkedList<>();

    public void loadComplete(FMLLoadCompleteEvent e) {
        try {
            lateRemovals.forEach(CraftTweakerAPI::apply);
            lateAdditions.forEach(CraftTweakerAPI::apply);
        } catch(Exception ex) {
            ex.printStackTrace();
            CraftTweakerAPI.logError("Error while applying actions", ex);
        }
    }

}
