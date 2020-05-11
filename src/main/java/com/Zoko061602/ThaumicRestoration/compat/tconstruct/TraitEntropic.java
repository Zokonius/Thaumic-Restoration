package com.Zoko061602.ThaumicRestoration.compat.tconstruct;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitEntropic extends AbstractTrait {
    
    public TraitEntropic(int color) {
        super("tr_entropic", color);
    }
    
    @Override
    public void blockHarvestDrops(ItemStack tool, HarvestDropsEvent event) {
        if(event.getState().getBlock() == Blocks.STONE)
            event.setDropChance(0f);
    }
    
}
