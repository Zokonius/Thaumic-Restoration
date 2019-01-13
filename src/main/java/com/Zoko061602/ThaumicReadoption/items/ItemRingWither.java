package com.Zoko061602.ThaumicReadoption.items;

import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemRingWither extends Item implements IBauble{

	public ItemRingWither() {
		this.setRegistryName("item_witherring");
		this.setUnlocalizedName("item_witherring");
		this.setCreativeTab(ReadoptedTab.tabReadopted);
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
