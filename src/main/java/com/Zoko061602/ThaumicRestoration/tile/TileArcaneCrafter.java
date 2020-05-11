package com.Zoko061602.ThaumicRestoration.tile;

import net.minecraft.item.ItemStack;
import thaumcraft.common.tiles.TileThaumcraftInventory;
import thaumcraft.common.tiles.crafting.TileArcaneWorkbench;

public class TileArcaneCrafter extends TileThaumcraftInventory {
    
    private ItemStack[] recipe = new ItemStack[9];
    
    public TileArcaneCrafter(int arg0) {
        super(arg0);
    }
       
}
