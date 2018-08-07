package com.Zoko061602.ThaumicReadoption.lib.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import thaumcraft.common.lib.crafting.DustTriggerSimple;

public class WandTriggerSimple extends DustTriggerSimple implements IWandTrigger {

	private int cost;

	public WandTriggerSimple(String research, Block target, ItemStack result,int cost){
		super(research, target, result);
		this.cost = cost;
	}

	public int getCost(){
		return cost;
	}

}
