package com.Zoko061602.ThaumicRestoration.crafting;

import java.util.HashMap;

import com.Zoko061602.ThaumicRestoration.api.IWandTrigger;
import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;
import com.Zoko061602.ThaumicRestoration.lib.wands.WandTriggerDust;
import com.Zoko061602.ThaumicRestoration.lib.wands.WandTriggerFire;
import com.Zoko061602.ThaumicRestoration.lib.wands.WandTriggerSimple;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.GameData;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IDustTrigger;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;

public class TR_Recipes {

	public static HashMap<String,ResourceLocation> recipes = new HashMap<>();

	public static void addRecipes(Register<IRecipe> e) {
		addRegularRecipes();
		addArcaneRecipes();
		addCucibleRecipes();
		addCrystalInfuserRecipes();
		addInfusionRecipes();
		addWandTriggers();
		TR_Golems.addGolems();
		CrystalTypes.registerCrystals();

	}


	private static void addRegularRecipes() {
     recipes.put("TR_DECO.1",addShapelessOreRecipe(new ItemStack(TR_Blocks.blockGreatwoodPlank), new ItemStack(BlocksTC.plankGreatwood)));
     recipes.put("TR_DECO.2",addShapedOreRecipe(new ItemStack(TR_Blocks.blockGreatwoodFramed)," N ","NGN"," N ",'N',"nuggetThaumium",'G',new ItemStack(TR_Blocks.blockGreatwoodPlank)));
     recipes.put("TR_DECO.3",addShapedOreRecipe(new ItemStack(TR_Blocks.blockReinforced,5), "TST","SSS","TST",'T',"ingotThaumium",'S',new ItemStack(Blocks.COBBLESTONE)));
     addShapelessOreRecipe(new ItemStack(BlocksTC.plankGreatwood), new ItemStack(TR_Blocks.blockGreatwoodPlank));
     for(int i=0;!(i==6);i++)
     recipes.put("INFUSEDTHAUMIUM."+i, addShapedOreRecipe(new ItemStack(TR_Items.itemPlate, 3, i), "III",'I',new ItemStack(TR_Items.itemIngot,1,i)));
	}

	private static void addArcaneRecipes(){

	 AspectList crystals = new AspectList().add(Aspect.ENTROPY, 1);
     recipes.put("NOVICEWAND.1", addShapedArcaneRecipe("NOVICEWAND@1", new ItemStack(TR_Items.itemWandRod,1,0), 10, crystals, "  G"," G ","G  ",'G',new ItemStack(BlocksTC.logGreatwood)));

     crystals = new AspectList().add(Aspect.AIR,1).add(Aspect.FIRE,1).add(Aspect.ORDER,1);
     recipes.put("NOVICEWAND.2", addShapedArcaneRecipe("NOVICEWAND@1", new ItemStack(TR_Items.itemWandCap,1,0), 10, crystals, "NNN","N N",'N',"nuggetBrass"));

     crystals = new AspectList().add(Aspect.AIR,1).add(Aspect.FIRE,1).add(Aspect.WATER,1).add(Aspect.EARTH,1).add(Aspect.ORDER,1).add(Aspect.ENTROPY,1);
     recipes.put("NOVICEWAND.3", addShapedArcaneRecipe("NOVICEWAND@1", new ItemStack(TR_Items.itemWand,1,0), 25, crystals, "  C"," R ","C  ",'R',new ItemStack(TR_Items.itemWandRod),'C',new ItemStack(TR_Items.itemWandCap)));

     crystals = new AspectList().add(Aspect.AIR,3).add(Aspect.FIRE,3).add(Aspect.WATER,3).add(Aspect.EARTH,3).add(Aspect.ORDER,3).add(Aspect.ENTROPY,3);
     recipes.put("ADEPTWAND.1", addShapedArcaneRecipe("ADEPTWAND@1", new ItemStack(TR_Items.itemWand,1,1), 50, crystals, " CR"," WC","C  ",'C',new ItemStack(TR_Items.itemWandCap),'R',new ItemStack(ItemsTC.visResonator),'W',new ItemStack(TR_Items.itemWand)));

	 crystals = new AspectList().add(Aspect.WATER, 5).add(Aspect.ORDER, 2);
     recipes.put("AQUABUCKET.1", addShapedArcaneRecipe("AQUABUCKET@1", new ItemStack(TR_Items.itemTRBucket,1,0), 25, crystals, "I I"," I ",'I',new ItemStack(TR_Items.itemIngot,1,2)));

     crystals = new AspectList().add(Aspect.AIR,5).add(Aspect.ORDER,2).add(Aspect.ENTROPY,2);
     recipes.put("PAVING_AER.1", addShapedArcaneRecipe("PAVING_AER@1", new ItemStack(TR_Blocks.blockPavingAer,8,0), 50, crystals, "SSS","SIS","SSS",'S', new ItemStack(BlocksTC.stoneArcane),'I', new ItemStack(TR_Items.itemIngot,1,0)));

	 crystals = new AspectList().add(Aspect.EARTH, 5).add(Aspect.ENTROPY, 2);
     recipes.put("TERRAOBSIDIAN.1", addShapedArcaneRecipe("TERRAOBSIDIAN@1",new ItemStack(TR_Blocks.blockObsidian,5), 25, crystals, "OIO","IOI","OIO",'I',new ItemStack(TR_Items.itemIngot,1,3),'O',new ItemStack(Blocks.OBSIDIAN)));

     crystals = new AspectList().add(Aspect.AIR,10).add(Aspect.FIRE,10).add(Aspect.WATER,10).add(Aspect.EARTH,10).add(Aspect.ORDER,10).add(Aspect.ENTROPY,10);
     recipes.put("POTIONCRYSTALS.1", addShapedArcaneCrystalRecipe("POTIONCRYSTALS@1", new ItemStack(TR_Blocks.blockCrystal), 50, crystals, " C ","CRC","OOO",'C',new ItemStack(ItemsTC.crystalEssence),'R',new ItemStack(ItemsTC.visResonator),'O',new ItemStack(TR_Blocks.blockObsidian)));

	}

	private static void addInfusionRecipes() {
		AspectList aspects = new AspectList().add(Aspect.MAGIC,32).add(Aspect.ENERGY,24).add(Aspect.ORDER,16).add(Aspect.AURA, 8);
		recipes.put("CRYSTALINFUSION.1", addInfusionRecipe("CRYSTALINFUSION@1", new ItemStack(TR_Blocks.blockInfuser), 6, new ItemStack(BlocksTC.pedestalArcane), aspects, new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus)));

		aspects = new AspectList().add(Aspect.MAGIC,32).add(Aspect.ENERGY,24).add(Aspect.AIR,16).add(Aspect.AURA, 8);
		recipes.put("RECHARGER.1", addInfusionRecipe("RECHARGER@1", new ItemStack(TR_Blocks.blockAdvRechargePed), 6, new ItemStack(BlocksTC.rechargePedestal), aspects, new ItemStack(Blocks.GOLD_BLOCK),new ItemStack(Items.EMERALD),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(Items.EMERALD)));

		aspects = new AspectList().add(Aspect.MAGIC,64).add(Aspect.AIR,64).add(Aspect.FIRE,64).add(Aspect.WATER, 64).add(Aspect.EARTH, 64).add(Aspect.ORDER, 64).add(Aspect.ENTROPY, 64);
		recipes.put("MASTERWAND.1", addInfusionRecipe("MASTERWAND@1", new ItemStack(TR_Items.itemWand,1,2), 8, new ItemStack(TR_Items.itemWand,1,1), aspects, new ItemStack(Items.NETHER_STAR),new ItemStack(TR_Items.itemIngot,1,0),new ItemStack(TR_Items.itemIngot,1,1),new ItemStack(TR_Items.itemIngot,1,2),new ItemStack(Items.NETHER_STAR),new ItemStack(TR_Items.itemIngot,1,3),new ItemStack(TR_Items.itemIngot,1,4),new ItemStack(TR_Items.itemIngot,1,5)));

		aspects = new AspectList().add(Aspect.MAGIC,30).add(Aspect.LIFE,20).add(Aspect.PROTECT,15).add(Aspect.ORDER, 10);
		recipes.put("WITHERRING.1", addInfusionRecipe("WITHERRING@1", new ItemStack(TR_Items.itemWitherRing), 5, new ItemStack(ItemsTC.baubles,1,1), aspects, new ItemStack(Items.NETHER_STAR),new ItemStack(Items.SKULL,1,1),new ItemStack(Items.MILK_BUCKET),new ItemStack(Items.SKULL,1,1),new ItemStack(Items.MILK_BUCKET)));

	}

	private static void addCucibleRecipes() {
		AspectList aspects = new AspectList().add(Aspect.ENTROPY, 30).add(Aspect.DEATH, 20).add(Aspect.UNDEAD, 40).add(Aspect.DARKNESS,20);
		recipes.put("TR_WITHER.1",addCrucibleRecipe("TR_WITHER", new ItemStack(Items.SKULL,1,1), aspects, new ItemStack(Items.SKULL,1,0)));

		aspects = new AspectList().add(Aspect.ORDER, 15).add(Aspect.MAGIC, 10).add(Aspect.VOID, 20).add(Aspect.DARKNESS,10);
		recipes.put("TR_ENDER.1",addCrucibleRecipe("TR_ENDER", new ItemStack(Items.ENDER_PEARL,2,0), aspects, new ItemStack(Items.ENDER_PEARL,1,0)));

		aspects = new AspectList().add(Aspect.LIFE, 5).add(Aspect.MAGIC, 5).add(Aspect.MAN, 5).add(Aspect.ALCHEMY,5);
		recipes.put("THAUMICTOAST.1",addCrucibleRecipe("THAUMICTOAST@1", new ItemStack(TR_Items.itemToast,1,0), aspects, new ItemStack(Items.BREAD,1,0)));
	}

	private static void addCrystalInfuserRecipes() {
		new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.AIR, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,0));
		new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.FIRE, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,1));
		new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.WATER, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,2));
		new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.EARTH, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,3));
		new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.ORDER, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,4));
		new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.ENTROPY, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,5));

	}


	private static void addWandTriggers() {
		for(IDustTrigger t : IDustTrigger.triggers)
			IWandTrigger.registerWandTrigger(new WandTriggerDust(t));
	    IWandTrigger.registerWandTrigger(new WandTriggerSimple("WANDTRANS@1", Blocks.SEA_LANTERN, new ItemStack(BlocksTC.amberBlock),5));
	    IWandTrigger.registerWandTrigger(new WandTriggerSimple("WANDTRANS@1", Blocks.PUMPKIN, new ItemStack(Blocks.MELON_BLOCK),5));
	    IWandTrigger.registerWandTrigger(new WandTriggerFire("WANDFIRE@1"));
	}

		public static ResourceLocation getNameForRecipe(ItemStack output) {
			ModContainer activeContainer = Loader.instance().activeModContainer();
			ResourceLocation baseLoc = new ResourceLocation(activeContainer.getModId(), output.getItem().getRegistryName().getResourcePath());
			ResourceLocation recipeLoc = baseLoc;
			int index = 0;
			while (CraftingManager.REGISTRY.containsKey(recipeLoc)) {
				index++;
				recipeLoc = new ResourceLocation(activeContainer.getModId(), baseLoc.getResourcePath() + "_" + index);
			}
			return recipeLoc;
		}

		public static ResourceLocation addShapedOreRecipe(ItemStack output, Object... params) {
			ResourceLocation location = getNameForRecipe(output);
			ShapedOreRecipe recipe = new ShapedOreRecipe(location, output, params);
			recipe.setRegistryName(location);
			GameData.register_impl(recipe);
			return location;
		}

		public static ResourceLocation addShapelessOreRecipe(ItemStack output, Object... input) {
			ResourceLocation location = getNameForRecipe(output);
			ShapelessOreRecipe recipe = new ShapelessOreRecipe(location, output, input);
			recipe.setRegistryName(location);
			GameData.register_impl(recipe);
			return location;

		}

		public static ResourceLocation addShapedArcaneRecipe(String research,ItemStack output,int vis,AspectList crystals,Object... input) {
			ResourceLocation location = getNameForRecipe(output);
			ShapedArcaneRecipe recipe = new ShapedArcaneRecipe(location, research, vis, crystals, output, input);
			ThaumcraftApi.addArcaneCraftingRecipe(location,recipe);
			return location;

		}

		public static ResourceLocation addShapedArcaneCrystalRecipe(String research,ItemStack output,int vis,AspectList crystals,Object... input) {
			ResourceLocation location = getNameForRecipe(output);
			ShapedArcaneRecipe recipe = new RecipeCrystal(location, research, vis, crystals, output, input);
			ThaumcraftApi.addArcaneCraftingRecipe(location,recipe);
			return location;

		}

		public static ResourceLocation addInfusionRecipe(String research, ItemStack output, int instability, ItemStack catalyst, AspectList aspects, Object... input) {
			ResourceLocation location = getNameForRecipe(output);
			InfusionRecipe recipe = new InfusionRecipe(research, output, instability, aspects, catalyst, input);
			ThaumcraftApi.addInfusionCraftingRecipe(location, recipe);
			return location;

		}

		public static ResourceLocation addCrucibleRecipe(String research, ItemStack output, AspectList aspects, Object input) {
			ResourceLocation location = getNameForRecipe(output);
			CrucibleRecipe recipe = new CrucibleRecipe(research, output, input, aspects);
			ThaumcraftApi.addCrucibleRecipe(location, recipe);
			return location;

		}

}
