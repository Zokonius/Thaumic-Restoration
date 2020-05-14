package com.Zoko061602.ThaumicRestoration.tile;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.util.BlockPosUtil;
import com.Zoko061602.ThaumicRestoration.util.IterUtil;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.RechargeHelper;
import thaumcraft.common.tiles.devices.TileRechargePedestal;

public class TileAdvRechargePedestal extends TileRechargePedestal {
    
    private int counter = 0;
    private int multi = 2;
    Block[] metals = new Block[] {
        BlocksTC.metalBlockBrass,
        BlocksTC.metalBlockThaumium,
        BlocksTC.metalBlockVoid
    };
    
    public Block getPedBlock() {
        return world.getBlockState(BlockPosUtil.translateToBlockPos(pos, 2, 2, 2)).getBlock();
    }
    
    @Override
    public void update() {
        if (checkStructure()) {
            Block b = getPedBlock();
                 if (b == metals[0]) multi = 3;
            else if (b == metals[1]) multi = 4;
            else if (b == metals[2]) multi = 5;
        }
        else multi = 2;

        if ((!getWorld().isRemote)
        && (counter++ % 10 == 0)
        && (getStackInSlot(0) != null)
        && (RechargeHelper.rechargeItem(getWorld(), getStackInSlot(0), this.pos, null, 5) > 0.0F)
        && (RechargeHelper.rechargeItemBlindly(getStackInSlot(0), null, 5 * (multi - 1)) > 0.0F)) {
            syncTile(false);
            markDirty();
            ArrayList<Aspect> al = Aspect.getPrimalAspects();
            world.addBlockEvent(this.pos, getBlockType(), 5 * multi, ((Aspect)al.get(getWorld().rand.nextInt(al.size()))).getColor());
        } 
    }
    
    public boolean doParticles() {
        return counter % 40 == 0;
    }
    
    public boolean isActive() {
        float r = RechargeHelper.getChargePercentage(getSyncedStackInSlot(0), null);
        return r >= 0 && r < 1;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 1;
    }
    
    @Override
    public boolean isItemValidForSlot(int par1, ItemStack stack2) {
        return (stack2.isEmpty()) || (getStackInSlot(par1).isEmpty());
    }
    
    public int getMulti() {
        return multi;
    }
    
    private boolean checkStructure() {

        for (int i = 0; i < 8; i++) {
            // checks -2, 1, -2 || 2, 1, -2 || -2, 1, 2 || 2, 1, 2 || -2, 2, -2 || 2, 2, -2 || -2, 2, 2 || 2, 2, 2
            if (world.getBlockState(BlockPosUtil.translateToBlockPos(pos, IterUtil.tick1(i) * 2, (i / 4), IterUtil.tick2(i) * 2)).getBlock() != Blocks.QUARTZ_BLOCK)
                return false;
        }
        
        ArrayList<Block> l = new ArrayList<Block>();
        for (int i = 0; i < 4; i++) {
            if (!l.contains(world.getBlockState(BlockPosUtil.translateToBlockPos(pos, IterUtil.tick1(i) * 2, 2, IterUtil.tick2(i))).getBlock()))
                l.add(world.getBlockState(BlockPosUtil.translateToBlockPos(pos, IterUtil.tick1(i) * 2, 2, IterUtil.tick2(i))).getBlock());
        }
        
        if (l.size() != 1)
            return false;
        
        for (Block b : metals) {
            if (l.get(0) == b)
                break;
            if (b == BlocksTC.metalBlockVoid)
                return false;
        }
        return true;
    }
    
}
