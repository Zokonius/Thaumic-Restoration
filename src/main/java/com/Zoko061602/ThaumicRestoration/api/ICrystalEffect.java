package com.Zoko061602.ThaumicRestoration.api;

import java.util.HashMap;

import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;

import thaumcraft.api.aspects.Aspect;

public interface ICrystalEffect {
    
    public static final HashMap<Aspect,ICrystalEffect> effects = new HashMap<>();
    
    public abstract Aspect getAspect();
    
    public abstract void performEffect(TileCrystal tile);
    
    public static void register(ICrystalEffect e) {
        if(effects.get(e.getAspect()) == null)
        effects.put(e.getAspect(), e);
    }
    
}
