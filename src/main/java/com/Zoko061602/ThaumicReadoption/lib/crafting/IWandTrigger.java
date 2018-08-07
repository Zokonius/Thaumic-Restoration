package com.Zoko061602.ThaumicReadoption.lib.crafting;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.crafting.IDustTrigger;

public interface IWandTrigger extends IDustTrigger {

	public abstract Placement getValidFace(World paramWorld, EntityPlayer paramEntityPlayer, BlockPos paramBlockPos, EnumFacing paramEnumFacing);

	  public abstract void execute(World paramWorld, EntityPlayer paramEntityPlayer, BlockPos paramBlockPos, Placement paramPlacement, EnumFacing paramEnumFacing);

	  public static final ArrayList<IWandTrigger> triggers = new ArrayList<IWandTrigger>();

	  public static void registerWandTrigger(IWandTrigger trigger){
	    triggers.add(trigger);
	  }

	  public abstract int getCost();

}
