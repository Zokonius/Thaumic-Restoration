package com.Zoko061602.ThaumicRestoration.items.baubles;

import com.Zoko061602.ThaumicRestoration.main.TR_Tab;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class ItemRingWither extends Item implements IBauble{

	public ItemRingWither() {
		this.setRegistryName("item_witherring");
		this.setUnlocalizedName("item_witherring");
		this.setCreativeTab(TR_Tab.tabRestoration);
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
		for(PotionEffect ef:player.getActivePotionEffects())
			if(ef.getPotion().getName()=="effect.wither")
			player.removePotionEffect(ef.getPotion());
	}

}
