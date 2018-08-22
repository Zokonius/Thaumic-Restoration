package com.Zoko061602.ThaumicReadoption.tile;

import com.Zoko061602.ThaumicReadoption.lib.tiles.ICrystalEffect;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.tiles.TileThaumcraft;

public class TileCrystal extends TileThaumcraft implements ITickable {

	Aspect a ;

	public TileCrystal() {}

    public TileCrystal(Aspect aspect) {
    	a = aspect;
	}

	@Override
	public void update() {
		if(!world.isBlockPowered(pos))
		 if(ICrystalEffect.effects.get(a) != null) {
		 ICrystalEffect.effects.get(a).performEffect(this);
		 }
	}

	public Aspect getAspect() {
		return a;
	}

	public void setAspect(Aspect a) {
		this.a = a;
	}

    @Override
    public NBTTagCompound writeSyncNBT(NBTTagCompound compound) {
    	compound.setString("Aspect", a.getTag());
    	return compound;
    }


    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
    	return super.getUpdatePacket();
    }

    @Override
    public void readSyncNBT(NBTTagCompound compound) {
    	a = Aspect.getAspect(compound.getString("Aspect"));

    }

}
