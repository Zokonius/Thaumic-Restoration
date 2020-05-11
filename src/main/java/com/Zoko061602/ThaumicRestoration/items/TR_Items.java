package com.Zoko061602.ThaumicRestoration.items;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.items.baubles.ItemRingWither;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class TR_Items {

	public static ArrayList<Item> ITEMS = new ArrayList<>();

    public static ItemBase itemWandCap = new ItemBase("item_wandcap");
    public static ItemBase itemWandRod = new ItemBase("item_wandrod");
    public static ItemBase itemIngot = new ItemBasePrimal("item_ingot");
    public static ItemBase itemPlate = new ItemBasePrimal("item_plate");
    public static ItemBase itemWand = new ItemWand();
    public static ItemBase itemWitherRing = new ItemRingWither();
    public static ItemBase itemLighter = new ItemLighter();
    public static ItemBase itemShard = new ItemShard();

    public static Item itemTRBucket = new ItemTRBucket();
    public static Item itemToast = new ItemToast();


    public static void registerItems(RegistryEvent.Register<Item> e) {
        for (Item item : ITEMS)
            if (item instanceof ItemBaseMeta)
                e.getRegistry().registerAll(item);
            else
                e.getRegistry().register(item);
    }

    public static void registerRenders(ModelRegistryEvent event) {
        for (Item item : ITEMS)
            registerRender(item);
    }

    private static void registerRender(Item item) {
        if (item instanceof ItemBaseMeta) {
            ItemBaseMeta it = (ItemBaseMeta)item;
            for (int i = 0; !(i == ((ItemBaseMeta)item).getVariants().length); i++)
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(ThaumicRestoration.ModID + ":items/" + it.getBaseName(), it.getVariants()[i]));
        }
        else
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }

}
