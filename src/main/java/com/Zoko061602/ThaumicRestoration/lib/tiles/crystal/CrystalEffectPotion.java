package com.Zoko061602.ThaumicRestoration.lib.tiles.crystal;

import java.util.List;

import com.Zoko061602.ThaumicRestoration.api.ICrystalEffect;
import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalEffectPotion implements ICrystalEffect {

    private Potion potion;
    private int amp;

    public CrystalEffectPotion(Potion potion, int amp) {
        this.potion = potion;
        this.amp = amp;
    }

	@Override
	public void performEffect(World world, BlockPos pos, TileCrystal tile) {
        PotionEffect effect = null;
        List<EntityLivingBase> l = world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(pos.getX()-7, pos.getY()-7, pos.getZ()-7, pos.getX()+7, pos.getY()+7, pos.getZ()+7));
        for (EntityLivingBase p : l){
            if (p.isPotionActive(potion))
                effect = p.getActivePotionEffect(potion);
            if (effect == null || effect.getDuration() < 222)
                p.addPotionEffect(new PotionEffect(potion, 239, amp));
        }
	}

}
