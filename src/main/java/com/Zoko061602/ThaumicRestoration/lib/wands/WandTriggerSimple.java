package com.Zoko061602.ThaumicRestoration.lib.wands;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.common.lib.crafting.DustTriggerSimple;

public class WandTriggerSimple extends WandTrigger {
    
    private int cost;
    DustTriggerSimple trigger;
    
    public WandTriggerSimple(String research, Block target, ItemStack result,int cost){
        super(research);
        this.cost = cost;
        trigger = new DustTriggerSimple(research, target, result);
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public void execute(World world, EntityPlayer player, BlockPos pos, Placement placement, EnumFacing side) {
        trigger.execute(world, player, pos, placement, side);   
    }
    
    @Override
    public Placement getValidFace(World world, EntityPlayer player, BlockPos pos, EnumFacing face) {
        return trigger.getValidFace(world, player, pos, face);
    }
    
}
