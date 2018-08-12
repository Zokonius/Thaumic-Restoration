package com.Zoko061602.ThaumicReadoption.client.compat.jei.crystalinfusion;

import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CrystalInfusionRecipeCategory implements IRecipeCategory<CrystalInfusionRecipeWrapper> {

	private final IDrawable background;
	private final IDrawable overlay_base;
	private final IDrawable overlay_out;
	private final IDrawable overlay_ped;


	public CrystalInfusionRecipeCategory(IGuiHelper guiHelper){
		background = guiHelper.createBlankDrawable(256, 192);
		overlay_base = guiHelper.createDrawable(new ResourceLocation(ThaumicReadoption.ModID, "textures/gui/crystalInfusionOverlay.png"),0, 0, 127, 127);
		overlay_ped = guiHelper.createDrawable(new ResourceLocation(ThaumicReadoption.ModID, "textures/gui/crystalInfusionOverlay.png"),128, 0, 143, 15);
        overlay_out = guiHelper.createDrawable(new ResourceLocation(ThaumicReadoption.ModID, "textures/gui/crystalInfusionOverlay.png"),144, 0, 175, 31);

	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawExtras(Minecraft minecraft) {
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		overlay_base.draw(minecraft, 64, 48);
		overlay_ped.draw(minecraft, 160, 96);
		overlay_out.draw(minecraft, 8, 112);
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
	}

	@Override
	public String getModName() {
		return ThaumicReadoption.ModName;
	}

	@Override
	public String getTitle() {
		return "thaumicreadoption.jei.crystalinfusion";
	}

	@Override
	public String getUid() {
		return "thaumicreadoption.crystalinfusion";
	}

	@Override
	public void setRecipe(IRecipeLayout layout, CrystalInfusionRecipeWrapper wrapper, IIngredients items) {
		int index = 0;

		//Main item
        layout.getItemStacks().init(index, true, 160, 80);
        layout.getItemStacks().set(index, items.getInputs(ItemStack.class).get(0));

        /*Crystals
        layout.getItemStacks().init(index, true, 160, 80);
        layout.getItemStacks().set(index, items.getInputs(ItemStack.class).get(1));

        layout.getItemStacks().init(index, true, 160, 80);
        layout.getItemStacks().set(index, items.getInputs(ItemStack.class).get(1));

        layout.getItemStacks().init(index, true, 160, 80);
        layout.getItemStacks().set(index, items.getInputs(ItemStack.class).get(1));

        layout.getItemStacks().init(index, true, 160, 80);
        layout.getItemStacks().set(index, items.getInputs(ItemStack.class).get(1));

        layout.getItemStacks().init(index, true, 160, 80);
        layout.getItemStacks().set(index, items.getInputs(ItemStack.class).get(1));

        layout.getItemStacks().init(index, true, 160, 80);
        layout.getItemStacks().set(index, items.getInputs(ItemStack.class).get(1));

        *///Output
        layout.getItemStacks().init(index++, true, 120, 16);
        layout.getItemStacks().set(index, items.getOutputs(ItemStack.class).get(0));

	}



}
