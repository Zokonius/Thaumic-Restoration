package com.Zoko061602.ThaumicReadoption.crafting;

import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;
import com.Zoko061602.ThaumicReadoption.lib.crafting.IWandTrigger;
import com.Zoko061602.ThaumicReadoption.lib.crafting.RecipeCrystalInfusion;
import com.Zoko061602.ThaumicReadoption.lib.crafting.WandTriggerMultiblock;
import com.Zoko061602.ThaumicReadoption.lib.crafting.WandTriggerOre;
import com.Zoko061602.ThaumicReadoption.lib.crafting.WandTriggerSimple;
import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import crafttweaker.api.recipes.ShapedRecipe;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.Part;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.blocks.basic.BlockPillar;
import thaumcraft.common.config.ConfigItems;

public class ReadoptedRecipes {

	public static void addRecipes(Register<IRecipe> e){
		WandTriggers.addWandTriggers();
		addCrystalInfuserRecipes();
		CrystalTypes.registerCrystals();
       // addNormalRecipes(e);

	}

	private static void addNormalRecipes(Register<IRecipe> e) {
		IForgeRegistry<IRecipe> r = e.getRegistry();
		r.register(new ShapedOreRecipe(new ResourceLocation(""), new ItemStack(Blocks.DIAMOND_BLOCK),
				"XC",
				"CX",
				"CX",
				'X', "gemEmerald",
				'C',new ItemStack(Items.STICK)));
	}

	private static void addCrystalInfuserRecipes() {
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.AIR, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,0)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.FIRE, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,1)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.WATER, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,2)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.EARTH, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,3)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.ORDER, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,4)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.ENTROPY, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,5)).register();

	}

}
