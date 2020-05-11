package com.Zoko061602.ThaumicRestoration.api;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.crafting.IDustTrigger;

public interface IWandTrigger extends IDustTrigger {
    
    public abstract Placement getValidFace(World world, EntityPlayer player, BlockPos pos, EnumFacing face);
    
    public abstract void execute(World world, EntityPlayer player, BlockPos pos, Placement placement, EnumFacing face);
    
    public abstract int getCost();
    
    public static final ArrayList<IWandTrigger> triggers = new ArrayList<IWandTrigger>();
    
    public static void registerWandTrigger(IWandTrigger trigger){
        triggers.add(trigger);
    }
    
}
