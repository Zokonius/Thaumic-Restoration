package com.Zoko061602.ThaumicRestoration.main;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.crafting.TR_Recipes;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=ThaumicRestoration.ModID)
public class Registrar {

	  @SubscribeEvent
	  public static void registerBlocks(RegistryEvent.Register<Block> e){
       TR_Blocks.registerBlocks(e);
	  }

	  @SubscribeEvent
	  public static void registerItems(RegistryEvent.Register<Item> e){
		  TR_Blocks.registerItemBlocks(e);
		  TR_Items.registerItems(e);
	  }

	  @SubscribeEvent
	  public static void registerRecipes(RegistryEvent.Register<IRecipe> e){
	    TR_Recipes.addRecipes(e);
	  }

	  @SubscribeEvent
	  public static void registerModels(ModelRegistryEvent e){
		  TR_Items.registerRenders(e);
		  TR_Blocks.registerRenders(e);
	  }
}
