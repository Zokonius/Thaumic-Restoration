package com.Zoko061602.ThaumicReadoption.lib.crafting;

import thaumcraft.api.crafting.Part;
import thaumcraft.common.lib.crafting.DustTriggerMultiblock;

public class WandTriggerMultiblock extends DustTriggerMultiblock implements IWandTrigger {

	private int cost;

	public WandTriggerMultiblock(String research, Part[][][] blueprint, int cost) {
		super(research, blueprint);
		this.cost= cost;
	}

	@Override
	public int getCost() {
		return cost;
	}

}
