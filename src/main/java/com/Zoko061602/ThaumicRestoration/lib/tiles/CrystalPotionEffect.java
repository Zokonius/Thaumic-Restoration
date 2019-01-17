package com.Zoko061602.ThaumicRestoration.lib.tiles;

import java.util.List;

import com.Zoko061602.ThaumicRestoration.api.ICrystalEffect;
import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import thaumcraft.api.aspects.Aspect;

public class CrystalPotionEffect implements ICrystalEffect {

	private Aspect a;
	private Potion potion;
	private int amp;

	public CrystalPotionEffect(Aspect a, Potion potion, int amp) {
		this.a = a;
		this.potion = potion;
		this.amp = amp;
	}

	@Override
	public Aspect getAspect() {
		return a;
	}

	@Override
	public void performEffect(TileCrystal tile) {
		PotionEffect effect = null;
		List<EntityPlayerMP> l = tile.getWorld().getEntitiesWithinAABB(EntityPlayerMP.class, new AxisAlignedBB(new BlockPos(tile.getPos().getX()-7, tile.getPos().getY()-7, tile.getPos().getZ()-7), new BlockPos(tile.getPos().getX()+7, tile.getPos().getY()+7, tile.getPos().getZ()+7)));
	    for(EntityPlayerMP p:l){
	    	if(p.isPotionActive(potion)) {
	    		effect = p.getActivePotionEffect(potion);
	    	}
	    	if(effect == null||effect.getDuration()<222)
	    	p.addPotionEffect(new PotionEffect(potion, 239, amp));
	    }
	}

}
