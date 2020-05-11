package com.Zoko061602.ThaumicRestoration.crafting;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectList;

public class TR_Aspects {
    
    public static AspectEventProxy ap = new AspectEventProxy();
    
    public static void addAspects() {
        AspectList l;
        l = new AspectList().add(Aspect.AIR,8).add(Aspect.MAGIC,5).add(Aspect.METAL,5).add(Aspect.LIGHT, 3);
        ap.registerComplexObjectTag("ingotThaumiumAer", l);
        
        l = new AspectList().add(Aspect.FIRE,8).add(Aspect.MAGIC,5).add(Aspect.METAL,5).add(Aspect.ENERGY, 3);
        ap.registerComplexObjectTag("ingotThaumiumIgnis", l);
        
        l = new AspectList().add(Aspect.WATER,8).add(Aspect.MAGIC,5).add(Aspect.METAL,5).add(Aspect.COLD, 3);
        ap.registerComplexObjectTag("ingotThaumiumAqua", l);
        
        l = new AspectList().add(Aspect.EARTH,8).add(Aspect.MAGIC,5).add(Aspect.METAL,5).add(Aspect.PROTECT, 3);
        ap.registerComplexObjectTag("ingotThaumiumTerra", l);
        
        l = new AspectList().add(Aspect.ORDER,8).add(Aspect.MAGIC,5).add(Aspect.METAL,5).add(Aspect.CRYSTAL, 3);
        ap.registerComplexObjectTag("ingotThaumiumOrdo", l);
        
        l = new AspectList().add(Aspect.ENTROPY,8).add(Aspect.MAGIC,5).add(Aspect.METAL,5).add(Aspect.VOID, 3);
        ap.registerComplexObjectTag("ingotThaumiumPerditio", l);
    }
    
}
