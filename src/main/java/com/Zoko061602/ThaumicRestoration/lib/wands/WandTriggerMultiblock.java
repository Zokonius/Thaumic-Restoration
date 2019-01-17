package com.Zoko061602.ThaumicRestoration.lib.wands;

import com.Zoko061602.ThaumicRestoration.api.IWandTrigger;

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
