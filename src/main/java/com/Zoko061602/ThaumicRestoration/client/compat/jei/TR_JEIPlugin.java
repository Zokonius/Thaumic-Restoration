package com.Zoko061602.ThaumicRestoration.client.compat.jei;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.client.compat.jei.crystalinfusion.CrystalCategory;
import com.Zoko061602.ThaumicRestoration.client.compat.jei.crystalinfusion.CrystalWrapper;
import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class TR_JEIPlugin implements IModPlugin {

	CrystalCategory crystalCat;

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		crystalCat = new CrystalCategory(registry.getJeiHelpers().getGuiHelper());
		registry.addRecipeCategories(crystalCat);

	}

	@Override
	public void register(IModRegistry registry) {
        ArrayList<CrystalWrapper> crystalWrappers = new ArrayList<>();
        for(RecipeCrystalInfusion r:RecipeCrystalInfusion.getRecipes())
        	crystalWrappers.add(new CrystalWrapper(r));

		registry.addRecipeCatalyst(new ItemStack(TR_Blocks.blockInfuser), crystalCat.getUid());
		registry.addRecipes(crystalWrappers, crystalCat.getUid());


	}


}
