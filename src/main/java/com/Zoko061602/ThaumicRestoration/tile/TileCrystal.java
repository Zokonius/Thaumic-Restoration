package com.Zoko061602.ThaumicRestoration.tile;

import com.Zoko061602.ThaumicRestoration.api.ICrystalEffect;
import com.Zoko061602.ThaumicRestoration.api.RestorationAPI;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.tiles.TileThaumcraft;

public class TileCrystal extends TileThaumcraft implements ITickable {

    Aspect aspect;
    ICrystalEffect effect;

    public TileCrystal() {}

    public TileCrystal(Aspect aspect) {
        this.aspect = aspect;
        this.effect = RestorationAPI.getCrystalEffect(aspect);
    }

    @Override
    public void update() {
        if ((!world.isBlockPowered(pos))
        && (effect != null)) {
            effect.performEffect(world, pos, this);
        }
    }

    public Aspect getAspect() {
        return aspect != null ? aspect : Aspect.AIR;
    }

    public void setAspect(Aspect a) {
        this.aspect = a;
    }

    @Override
    public NBTTagCompound writeSyncNBT(NBTTagCompound compound) {
        compound.setString("Aspect", aspect.getTag());
        return compound;
    }


    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return super.getUpdatePacket();
    }

    @Override
    public void readSyncNBT(NBTTagCompound compound) {
    	aspect = Aspect.getAspect(compound.getString("Aspect"));
    	effect = RestorationAPI.getCrystalEffect(aspect);
    }

}
