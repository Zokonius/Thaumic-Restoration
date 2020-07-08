package com.Zoko061602.ThaumicRestoration.compat.thaumicwands;

import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import de.zpenguin.thaumicwands.api.item.wand.IWandCap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class TR_WandCap implements IWandCap {

	public Aspect aspect;
	public ItemStack stack;
	public String tag;

	public TR_WandCap(String tag, ItemStack stack) {
		this.aspect = Aspect.getAspect(tag);
		this.tag = tag;
		this.stack = stack;
	}

	@Override
	public AspectList getAspectDiscount() {
		return new AspectList().add(aspect, 2);
	}

	@Override
	public int getCraftCost() {
		return 25;
	}

	@Override
	public float getDiscount() {
		return 0.85F;
	}

	@Override
	public ItemStack getItemStack() {
		return stack;
	}

	@Override
	public String getRequiredResearch() {
		return "CAP_INFUSEDTHAUMIUM";
	}

	@Override
	public String getTag() {
		return tag;
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(ThaumicRestoration.modID, "textures/models/wand_cap_" + tag + ".png");
	}

}
