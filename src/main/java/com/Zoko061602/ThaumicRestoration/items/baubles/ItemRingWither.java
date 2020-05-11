package com.Zoko061602.ThaumicRestoration.items.baubles;

import com.Zoko061602.ThaumicRestoration.items.ItemBase;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;

public class ItemRingWither extends ItemBase implements IBauble {

    public ItemRingWither() {
    	super("item_witherring");
    }


    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.RING;
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer) {
            if (player.isPotionActive(MobEffects.WITHER))
                player.removeActivePotionEffect(MobEffects.WITHER);
        }
    }

}
