package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.api.RestorationAPI;
import com.Zoko061602.ThaumicRestoration.lib.tiles.crystal.CrystalEffectPotion;

import net.minecraft.init.MobEffects;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.lib.potions.PotionInfectiousVisExhaust;
import thaumcraft.common.lib.potions.PotionWarpWard;

public class CrystalTypes {

    public static void registerCrystals() {
        RestorationAPI.registerCrystalEffect(Aspect.AIR, new CrystalEffectPotion(MobEffects.SPEED, 0));
        RestorationAPI.registerCrystalEffect(Aspect.MOTION, new CrystalEffectPotion(MobEffects.SPEED, 1));

        RestorationAPI.registerCrystalEffect(Aspect.EARTH, new CrystalEffectPotion(MobEffects.RESISTANCE, 0));
        RestorationAPI.registerCrystalEffect(Aspect.PROTECT, new CrystalEffectPotion(MobEffects.RESISTANCE, 1));

        RestorationAPI.registerCrystalEffect(Aspect.DARKNESS, new CrystalEffectPotion(MobEffects.BLINDNESS, 1));
        RestorationAPI.registerCrystalEffect(Aspect.LIGHT, new CrystalEffectPotion(MobEffects.NIGHT_VISION, 0));

        RestorationAPI.registerCrystalEffect(Aspect.LIFE, new CrystalEffectPotion(MobEffects.REGENERATION, 0));
        RestorationAPI.registerCrystalEffect(Aspect.WATER, new CrystalEffectPotion(MobEffects.WATER_BREATHING, 0));

        RestorationAPI.registerCrystalEffect(Aspect.FIRE, new CrystalEffectPotion(MobEffects.FIRE_RESISTANCE, 0));
        RestorationAPI.registerCrystalEffect(Aspect.ENTROPY, new CrystalEffectPotion(MobEffects.HASTE, 0));
        RestorationAPI.registerCrystalEffect(Aspect.METAL, new CrystalEffectPotion(MobEffects.RESISTANCE, 0));
        RestorationAPI.registerCrystalEffect(Aspect.DEATH, new CrystalEffectPotion(MobEffects.WITHER, 0));
        RestorationAPI.registerCrystalEffect(Aspect.UNDEAD, new CrystalEffectPotion(MobEffects.POISON, 1));
        RestorationAPI.registerCrystalEffect(Aspect.AVERSION, new CrystalEffectPotion(MobEffects.STRENGTH, 0));
        RestorationAPI.registerCrystalEffect(Aspect.AURA, new CrystalEffectPotion(PotionWarpWard.instance, 0));
        RestorationAPI.registerCrystalEffect(Aspect.FLUX, new CrystalEffectPotion(PotionInfectiousVisExhaust.instance, 0));
        RestorationAPI.registerCrystalEffect(Aspect.ENERGY, new CrystalEffectPotion(MobEffects.JUMP_BOOST, 0));
        RestorationAPI.registerCrystalEffect(Aspect.ELDRITCH, new CrystalEffectPotion(MobEffects.LEVITATION, 0));
        RestorationAPI.registerCrystalEffect(Aspect.FLIGHT, new CrystalEffectPotion(MobEffects.LEVITATION, 1));
      //  RestorationAPI.registerCrystalEffect(Aspect.PLANT, new CrystalEffectPotion(MobEffects.LEVITATION, 0));
        RestorationAPI.registerCrystalEffect(Aspect.TOOL, new CrystalEffectPotion(MobEffects.HASTE, 2));
        RestorationAPI.registerCrystalEffect(Aspect.SENSES, new CrystalEffectPotion(MobEffects.NAUSEA, 0));
        RestorationAPI.registerCrystalEffect(Aspect.TRAP, new CrystalEffectPotion(MobEffects.SLOWNESS, 0));
        RestorationAPI.registerCrystalEffect(Aspect.DESIRE, new CrystalEffectPotion(MobEffects.GLOWING, 0));
        RestorationAPI.registerCrystalEffect(Aspect.MAGIC, new CrystalEffectPotion(MobEffects.LUCK, 0));
        RestorationAPI.registerCrystalEffect(Aspect.BEAST, new CrystalEffectPotion(MobEffects.HUNGER, 0));
        RestorationAPI.registerCrystalEffect(Aspect.COLD, new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        RestorationAPI.registerCrystalEffect(Aspect.SOUL, new CrystalEffectPotion(MobEffects.INVISIBILITY, 0));

        //Bewitchment Aspects
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("sol"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("stellae"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("diabolus"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));

        //Thaumic Additions Aspects
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("sonus"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        // RestorationAPI.registerCrystalEffect(Aspect.getAspect("exitium"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        RestorationAPI.registerCrystalEffect(Aspect.getAspect("caeles"), new CrystalEffectPotion(MobEffects.RESISTANCE, 4));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("draco"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("infernum"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        RestorationAPI.registerCrystalEffect(Aspect.getAspect("ventus"), new CrystalEffectPotion(MobEffects.SPEED, 2));
        RestorationAPI.registerCrystalEffect(Aspect.getAspect("visum"), new CrystalEffectPotion(MobEffects.NIGHT_VISION, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("imperium"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));

        //Thaumic Bases Aspects
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("pannus"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("iter"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("sano"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("fames"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));
        //RestorationAPI.registerCrystalEffect(Aspect.getAspect("messis"), new CrystalEffectPotion(MobEffects.MINING_FATIGUE, 0));

    }

}
