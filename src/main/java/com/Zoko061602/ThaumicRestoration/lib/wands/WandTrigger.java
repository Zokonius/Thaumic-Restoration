package com.Zoko061602.ThaumicRestoration.lib.wands;

import com.Zoko061602.ThaumicRestoration.api.IWandTrigger;


public abstract class WandTrigger implements IWandTrigger {
    
    String research;
    
    public WandTrigger(String research) {
        this.research = research;
    }
    
}
