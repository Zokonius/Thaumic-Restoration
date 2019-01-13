package com.Zoko061602.ThaumicReadoption.crafting;

import com.Zoko061602.ThaumicReadoption.lib.tiles.CrystalPotionEffect;
import com.Zoko061602.ThaumicReadoption.lib.tiles.ICrystalEffect;

import net.minecraft.init.MobEffects;
import thaumcraft.api.aspects.Aspect;

public class CrystalTypes {

	public static void registerCrystals() {
     ICrystalEffect.register(new CrystalPotionEffect(Aspect.AIR, MobEffects.SPEED, 0));
     ICrystalEffect.register(new CrystalPotionEffect(Aspect.MOTION, MobEffects.SPEED, 1));

     ICrystalEffect.register(new CrystalPotionEffect(Aspect.EARTH, MobEffects.RESISTANCE, 0));
     ICrystalEffect.register(new CrystalPotionEffect(Aspect.PROTECT, MobEffects.RESISTANCE, 1));

     ICrystalEffect.register(new CrystalPotionEffect(Aspect.DARKNESS, MobEffects.BLINDNESS, 1));
     ICrystalEffect.register(new CrystalPotionEffect(Aspect.LIGHT, MobEffects.NIGHT_VISION, 0));

     ICrystalEffect.register(new CrystalPotionEffect(Aspect.LIFE, MobEffects.REGENERATION, 0));
     ICrystalEffect.register(new CrystalPotionEffect(Aspect.WATER, MobEffects.WATER_BREATHING, 0));


	}

}
