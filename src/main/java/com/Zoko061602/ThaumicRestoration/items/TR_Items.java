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
    }
    
    public static void registerItems(RegistryEvent.Register<Item> e){
        
        e.getRegistry().registerAll(itemWand);
        e.getRegistry().registerAll(itemIngot);
        e.getRegistry().registerAll(itemPlate);
        
        e.getRegistry().register(itemWandCap);
        e.getRegistry().register(itemWandRod);
        
        e.getRegistry().register(itemTRBucket);
        e.getRegistry().register(itemToast);
        e.getRegistry().register(itemWitherRing);
        e.getRegistry().register(itemLighter);
        e.getRegistry().register(itemShard);
        
    }
    
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(itemWand);
        registerRender(itemIngot);
        registerRender(itemPlate);
        registerRender(itemWandCap);
        registerRender(itemWandRod);
        registerRender(itemTRBucket);
        registerRender(itemToast);
        registerRender(itemWitherRing);
        registerRender(itemLighter);
        registerRender(itemShard);
        
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
