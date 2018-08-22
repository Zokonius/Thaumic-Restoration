package com.Zoko061602.ThaumicReadoption.main;

import com.Zoko061602.ThaumicReadoption.blocks.ReadoptedBlocks;
import com.Zoko061602.ThaumicReadoption.crafting.ReadoptedRecipes;
import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=ThaumicReadoption.ModID)
public class Registrar {

	  @SubscribeEvent
	  public static void registerBlocks(RegistryEvent.Register<Block> e){
       ReadoptedBlocks.registerBlocks(e);
	  }

	  @SubscribeEvent
	  public static void registerItems(RegistryEvent.Register<Item> e){
		  ReadoptedBlocks.registerItemBlocks(e);
		  ReadoptedItems.registerItems(e);
	  }

	  @SubscribeEvent
	  public static void registerRecipes(RegistryEvent.Register<IRecipe> e){
	    ReadoptedRecipes.addRecipes(e);
	  }

	  @SubscribeEvent
	  public static void registerModels(ModelRegistryEvent e){
		  ReadoptedItems.registerRenders(e);
		  ReadoptedBlocks.registerRenders(e);
	  }
}
