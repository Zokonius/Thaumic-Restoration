package com.Zoko061602.ThaumicRestoration.api;

import java.util.HashMap;

import thaumcraft.api.aspects.Aspect;

public class RestorationAPI {

	public static final HashMap<Aspect,ICrystalEffect> crystalEffects = new HashMap<>();

	public static void registerCrystalEffect(Aspect aspect, ICrystalEffect effect) {
		if(aspect !=null && crystalEffects.get(aspect) == null)
			crystalEffects.put(aspect, effect);
	}

	public static ICrystalEffect getCrystalEffect(Aspect a) {
		return crystalEffects.get(a);
	}

}
