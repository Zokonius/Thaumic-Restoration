package com.Zoko061602.ThaumicReadoption.client.compat.jei.crystalinfusion;

import java.util.ArrayList;

import com.Zoko061602.ThaumicReadoption.lib.crafting.RecipeCrystalInfusion;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApiHelper;

public class CrystalInfusionRecipeWrapper implements IRecipeWrapper {
	RecipeCrystalInfusion recipe;

	public CrystalInfusionRecipeWrapper(RecipeCrystalInfusion recipe){
		this.recipe = recipe;
	}

	@Override
	public void getIngredients(IIngredients ingr) {
		ArrayList<ItemStack> l = new ArrayList<ItemStack>();
		l.add(recipe.getInput());
		l.add(ThaumcraftApiHelper.makeCrystal(recipe.getAspect()));
	 ingr.setInput(ItemStack.class, l);
	 l= new ArrayList<ItemStack>();
	 l.add(recipe.getOutput());
     ingr.setOutput(ItemStack.class, l);
	}



}
