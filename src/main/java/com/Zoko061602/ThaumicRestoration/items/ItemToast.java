package com.Zoko061602.ThaumicRestoration.items;

import com.Zoko061602.ThaumicRestoration.main.TR_Tab;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemToast extends ItemFood {

    public ItemToast() {
        super(3, 3, false);
        this.setRegistryName("item_toast");
        this.setUnlocalizedName("item_toast");
        this.setCreativeTab(TR_Tab.tabRestoration);
        TR_Items.ITEMS.add(this);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 6000, 0));
    }

}
