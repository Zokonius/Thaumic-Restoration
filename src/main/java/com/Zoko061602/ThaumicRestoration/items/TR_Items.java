package com.Zoko061602.ThaumicRestoration.items;

import com.Zoko061602.ThaumicRestoration.items.baubles.ItemRingWither;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class TR_Items {
    
    public static Item itemWand;
    public static Item itemIngot;
    public static Item itemPlate;
    public static Item itemTRBucket;
    public static Item itemToast;
    public static Item itemWandCap;
    public static Item itemWandRod;
    public static Item itemWitherRing;
    public static Item itemLighter;
    public static Item itemShard;

    private static Item[] items;

//    private static Item[] sumList(Item[]... list) {
//        int n = 0;
//        for (Item[] items : list) n += items.length;
//        Item[] result = new Item[n];
//        n = 0;
//        for (Item[] items : list) {
//            System.arraycopy(items, 0, result, n, items.length);
//            n += items.length;
//        }
//        return result;
//    }
    
    public static void initItems() {
        itemWand = new ItemWand();
        itemIngot = new ItemBaseMeta("item_ingot", "aer", "ignis", "aqua", "terra", "ordo", "perditio");
        itemPlate = new ItemBaseMeta("item_plate", "aer", "ignis", "aqua", "terra", "ordo", "perditio");
        
        itemWandCap = new ItemBase("item_wandcap");
        itemWandRod = new ItemBase("item_wandrod");
        
        itemTRBucket = new ItemTRBucket();
        itemToast = new ItemToast();
        itemWitherRing = new ItemRingWither();
        itemLighter = new ItemLighter();
        itemShard = new ItemShard();

        items = new Item[] { itemWand, itemIngot, itemPlate, itemWandCap, itemWandRod, itemTRBucket, itemToast, itemWitherRing, itemLighter, itemShard };
        // is there reason to initialize them here instead of directly in the field?
        // if initiation is moved to the decleration, items can be moved and set """final""".
    }
    
    public static void registerItems(RegistryEvent.Register<Item> e) {
        for (Item item : items)
            if (item instanceof ItemBaseMeta)
                e.getRegistry().registerAll(item);
            else
                e.getRegistry().register(item);
    }
    
    public static void registerRenders(ModelRegistryEvent event) {
        for (Item item : items)
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
