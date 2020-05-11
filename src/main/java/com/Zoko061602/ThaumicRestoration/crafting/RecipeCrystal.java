package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.items.block.ItemBlockCrystal;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.IEssentiaContainerItem;
import thaumcraft.api.crafting.ShapedArcaneRecipe;

public class RecipeCrystal extends ShapedArcaneRecipe {
    
    public RecipeCrystal(ResourceLocation group, String res, int vis, AspectList crystals, ItemStack result, Object[] recipe) {
        super(group, res, vis, crystals, result, recipe);
    }
    
    @Override
    public boolean matches(InventoryCrafting arg0, World arg1) {
        if(super.matches(arg0, arg1)) {
            Aspect a0, a1, a2;
            a0 = AspectHelper.getObjectAspects(arg0.getStackInSlot(1)).getAspects()[0];
            a1 = AspectHelper.getObjectAspects(arg0.getStackInSlot(3)).getAspects()[0];
            a2 = AspectHelper.getObjectAspects(arg0.getStackInSlot(5)).getAspects()[0];
            return a0 == a1 && a0 == a2;
        }
        else return false;
    }
    
    @Override
    public ItemStack getCraftingResult(InventoryCrafting arg0) {
        ItemStack s = arg0.getStackInRowAndColumn(0, 1);
        if(s.getItem() instanceof IEssentiaContainerItem) {
            Aspect a = ((IEssentiaContainerItem) s.getItem()).getAspects(s).getAspects()[0];
            return ItemBlockCrystal.ofType(super.getCraftingResult(arg0),a);
        }
        return null;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(TR_Blocks.blockCrystal);
    }
    
}
