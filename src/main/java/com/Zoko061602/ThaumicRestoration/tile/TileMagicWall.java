package com.Zoko061602.ThaumicRestoration.tile;

import com.Zoko061602.ThaumicRestoration.blocks.BlockPavingAer;
import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.items.ItemWand;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import thaumcraft.common.tiles.TileThaumcraft;

public class TileMagicWall extends TileThaumcraft implements ITickable {
    
    private int timer = 0;
    
    @Override
    public void update() {
        if (isPassable()) 
            timer--;
        else toggleState(true);
            if (world.isBlockIndirectlyGettingPowered(pos)!=0) 
                activate();
    }
    
    public boolean isPassable() {
        return timer > 0;
    }
    
    @Override
    public void readSyncNBT(NBTTagCompound nbt) {
        super.readSyncNBT(nbt);
        timer = nbt.getInteger("timer");
    }
    
    @Override
    public NBTTagCompound writeSyncNBT(NBTTagCompound nbt) {
        super.writeSyncNBT(nbt);
        nbt.setInteger("timer", timer);
        return nbt;
    }
    
    public boolean onActivate(EntityPlayer player) {
        if ((player.getHeldItemMainhand() != null)
        && (player.getHeldItemMainhand().getItem() instanceof ItemWand)) {
            activate();
            return true;
        }
        
        if ((player.getHeldItemOffhand() != null)
        && (player.getHeldItemOffhand().getItem() instanceof ItemWand)) {
            activate();
            return true;
        }
        
        return false;
    }
    
    private void activate() {
        if (isPassable())
            return;
        timer = 40;
        toggleState(false);
        
        activate(getPos().up());
        activate(getPos().down());
        activate(getPos().east());
        activate(getPos().west());
        activate(getPos().north());
        activate(getPos().south());
    }
    
    private void activate(BlockPos pos){
        TileEntity te = world.getTileEntity(pos);
        if (te != null && te instanceof TileMagicWall) {
            ((TileMagicWall) te).activate();
        }
    }
    
    private void toggleState(boolean state) {
        IBlockState bs = TR_Blocks.blockPavingAer.getDefaultState().withProperty(BlockPavingAer.collision, state);
        world.setBlockState(pos, bs, 3);
    }
    
}
