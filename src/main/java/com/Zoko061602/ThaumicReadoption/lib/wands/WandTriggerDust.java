package com.Zoko061602.ThaumicReadoption.lib.wands;

import com.Zoko061602.ThaumicReadoption.api.IWandTrigger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.crafting.IDustTrigger;

public class WandTriggerDust implements IWandTrigger {

	IDustTrigger trigger;

	public WandTriggerDust(IDustTrigger trigger) {
		this.trigger = trigger;
	}

	@Override
	public Placement getValidFace(World paramWorld, EntityPlayer paramEntityPlayer, BlockPos paramBlockPos,EnumFacing paramEnumFacing) {
		return trigger.getValidFace(paramWorld, paramEntityPlayer, paramBlockPos, paramEnumFacing);
	}

	@Override
	public void execute(World paramWorld, EntityPlayer paramEntityPlayer, BlockPos paramBlockPos,Placement paramPlacement, EnumFacing paramEnumFacing) {
		trigger.execute(paramWorld, paramEntityPlayer, paramBlockPos, paramPlacement, paramEnumFacing);
	}

	@Override
	public int getCost() {
		return 0;
	}

}
