package com.Zoko061602.ThaumicRestoration.client.compat.jei.crystalinfusion;

import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class CrystalWrapper implements IRecipeWrapper {
    
    private final RecipeCrystalInfusion recipe;
    
    public CrystalWrapper(RecipeCrystalInfusion recipe){
        this.recipe = recipe;
    }
    
    @Override
    public void getIngredients(IIngredients ingr) {
        ingr.setInput (ItemStack.class, recipe.getInput());
        ingr.setInputs(ItemStack.class, recipe.getInputs());
        ingr.setOutput(ItemStack.class, recipe.getOutput());
    }
    
    public String getResearch(){
        return recipe.getResearch();
    }
    
}
