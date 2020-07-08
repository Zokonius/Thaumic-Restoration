package com.Zoko061602.ThaumicRestoration.crafting;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectList;

public class TR_Aspects {

    private static AspectEventProxy ap = new AspectEventProxy();

    public static void addAspects() {
        addAspect("Aer"    , Aspect.AIR    , Aspect.MOTION);
        addAspect("Ignis"  , Aspect.FIRE   , Aspect.BEAST);
        addAspect("Aqua"   , Aspect.WATER  , Aspect.COLD);
        addAspect("Terra"  , Aspect.EARTH  , Aspect.DARKNESS);
        addAspect("Ordo"   , Aspect.ORDER  , Aspect.CRYSTAL);
        addAspect("Perditio", Aspect.ENTROPY, Aspect.UNDEAD);
    }

    private static void addAspect(String oreDict, Aspect primary, Aspect secondary) {
        ap.registerComplexObjectTag("ingotThaumium" + oreDict,
                new AspectList().add(primary, 8).add(Aspect.MAGIC, 5).add(Aspect.METAL, 5).add(secondary, 3));
    }

}
