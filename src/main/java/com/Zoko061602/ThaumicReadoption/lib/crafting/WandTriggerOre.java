package com.Zoko061602.ThaumicReadoption.lib.crafting;

import net.minecraft.item.ItemStack;
import thaumcraft.common.lib.crafting.DustTriggerOre;

public class WandTriggerOre extends DustTriggerOre implements IWandTrigger {

	private int cost;

	public WandTriggerOre(String research, String target, ItemStack result, int cost) {
		super(research, target, result);
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return cost;
	}

}
