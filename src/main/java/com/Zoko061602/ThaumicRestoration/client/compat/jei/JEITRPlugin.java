package com.Zoko061602.ThaumicRestoration.client.compat.jei;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.client.compat.jei.crystalinfusion.CrystalInfusionRecipeCategory;
import com.Zoko061602.ThaumicRestoration.client.compat.jei.crystalinfusion.CrystalInfusionRecipeWrapper;
import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;

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
		registry.handleRecipes(RecipeCrystalInfusion.class, CrystalInfusionRecipeWrapper::new, "thaumicrestoration.crystalinfusion");
		registry.addRecipes(RecipeCrystalInfusion.getRecipes(), "thaumicrestoration.crystalinfusion");
		registry.addRecipeCatalyst(TR_Blocks.blockInfuser, "thaumicrestoration.crystalinfusion");


	}


}
