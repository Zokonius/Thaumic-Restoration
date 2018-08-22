package com.Zoko061602.ThaumicReadoption.client.compat.jei;

import com.Zoko061602.ThaumicReadoption.blocks.ReadoptedBlocks;
import com.Zoko061602.ThaumicReadoption.client.compat.jei.crystalinfusion.CrystalInfusionRecipeCategory;
import com.Zoko061602.ThaumicReadoption.client.compat.jei.crystalinfusion.CrystalInfusionRecipeWrapper;
import com.Zoko061602.ThaumicReadoption.lib.crafting.RecipeCrystalInfusion;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

//@JEIPlugin
public class JEITRPlugin implements IModPlugin {

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(
				new CrystalInfusionRecipeCategory(registry.getJeiHelpers().getGuiHelper())
				);
	}

	@Override
	public void register(IModRegistry registry) {
		registry.handleRecipes(RecipeCrystalInfusion.class, CrystalInfusionRecipeWrapper::new, "thaumicreadoption.crystalinfusion");
		registry.addRecipes(RecipeCrystalInfusion.getRecipes(), "thaumicreadoption.crystalinfusion");
		registry.addRecipeCatalyst(ReadoptedBlocks.blockInfuser, "thaumicreadoption.crystalinfusion");


	}


}
