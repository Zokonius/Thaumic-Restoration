package com.Zoko061602.ThaumicRestoration.lib.crystal;

import java.util.List;

import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalEffectPotion extends CrystalEffect {

    private Potion potion;
    private int amp;

    public CrystalEffectPotion(Potion potion, int amp) {
        this.potion = potion;
        this.amp = amp;
    }

	@Override
	public void performEffect(World world, BlockPos pos, TileCrystal tile) {
        PotionEffect effect = null;
        List<EntityLivingBase> l = world.getEntitiesWithinAABB(EntityLivingBase.class, getAABBRange(pos));
        for (EntityLivingBase p : l){
            if (p.isPotionActive(potion))
                effect = p.getActivePotionEffect(potion);
            if (effect == null || effect.getDuration() < 222)
                p.addPotionEffect(new PotionEffect(potion, 239, amp));
        }
	}

}
