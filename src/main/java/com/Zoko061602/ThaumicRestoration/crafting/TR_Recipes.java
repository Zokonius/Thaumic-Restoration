package com.Zoko061602.ThaumicRestoration.crafting;

import java.util.HashMap;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.crafting.recipe.RecipeCrystal;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;

public class TR_Recipes {

    public static HashMap<String,ResourceLocation> recipes = new HashMap<>();

    public static void addRecipes(Register<IRecipe> e) {
        addWorkbenchRecipes();
        addArcaneWorkbenchRecipes();
        addCrucibleRecipes();
        addCrystalInfuserRecipes();
        addInfusionRecipes();
        TR_Golems.addGolems();
        TR_CrystalTypes.registerCrystals();
    }


    private static void addWorkbenchRecipes() {
        addShapelessOreRecipe("TR_DECO.1", new ItemStack(TR_Blocks.blockGreatwoodPlank), new ItemStack(BlocksTC.plankGreatwood));
        addShapedOreRecipe("TR_DECO.2", new ItemStack(TR_Blocks.blockGreatwoodFramed)," N ","NGN"," N ",'N',"nuggetThaumium",'G',new ItemStack(TR_Blocks.blockGreatwoodPlank));
        addShapedOreRecipe("TR_DECO.3", new ItemStack(TR_Blocks.blockReinforced,5), "TST","SSS","TST",'T',"ingotThaumium",'S',new ItemStack(Blocks.COBBLESTONE));
        addShapelessOreRecipe("TR_DECO.4", new ItemStack(BlocksTC.plankGreatwood), new ItemStack(TR_Blocks.blockGreatwoodPlank));
        for(int i=0; i!=6; i++)
        addShapedOreRecipe("INFUSEDTHAUMIUM."+(i+1), new ItemStack(TR_Items.itemPlate, 3, i), "III",'I',new ItemStack(TR_Items.itemIngot,1,i));
    }

    private static void addArcaneWorkbenchRecipes(){
        AspectList crystals;

        crystals = new AspectList().add(Aspect.WATER, 5).add(Aspect.ORDER, 2);
        addShapedArcaneRecipe("AQUABUCKET.1","AQUABUCKET", new ItemStack(TR_Items.itemTRBucket,1,0), 25, crystals, "I I"," I ",'I',new ItemStack(TR_Items.itemIngot,1,2));

        crystals = new AspectList().add(Aspect.AIR,5).add(Aspect.ORDER,2).add(Aspect.ENTROPY,2);
        addShapedArcaneRecipe("PAVING_AER.1", "PAVING_AER", new ItemStack(TR_Blocks.blockPavingAer,8,0), 50, crystals, "SSS","SIS","SSS",'S', new ItemStack(BlocksTC.stoneArcane),'I', new ItemStack(TR_Items.itemIngot,1,0));

        crystals = new AspectList().add(Aspect.EARTH, 5).add(Aspect.ENTROPY, 2);
        addShapedArcaneRecipe("TERRAOBSIDIAN.1", "TERRAOBSIDIAN",new ItemStack(TR_Blocks.blockObsidian,5), 25, crystals, "OIO","IOI","OIO",'I',new ItemStack(TR_Items.itemIngot,1,3),'O',new ItemStack(Blocks.OBSIDIAN));

        crystals = new AspectList().add(Aspect.AIR,10).add(Aspect.FIRE,10).add(Aspect.WATER,10).add(Aspect.EARTH,10).add(Aspect.ORDER,10).add(Aspect.ENTROPY,10);
        addShapedArcaneCrystalRecipe("POTIONCRYSTALS.1", "POTIONCRYSTALS", new ItemStack(TR_Blocks.blockCrystal), 50, crystals, " C ","CRC","OOO",'C',new ItemStack(ItemsTC.crystalEssence),'R',new ItemStack(ItemsTC.visResonator),'O',new ItemStack(TR_Blocks.blockObsidian));

    }

    private static void addInfusionRecipes() {
        AspectList aspects = new AspectList().add(Aspect.MAGIC,32).add(Aspect.ENERGY,24).add(Aspect.ORDER,16).add(Aspect.AURA, 8);
        addInfusionRecipe("CRYSTALINFUSION.1", "CRYSTALINFUSION", new ItemStack(TR_Blocks.blockInfuser), 6, new ItemStack(BlocksTC.pedestalArcane), aspects, new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus));

        aspects = new AspectList().add(Aspect.MAGIC,32).add(Aspect.ENERGY,24).add(Aspect.AIR,16).add(Aspect.AURA, 8);
        addInfusionRecipe("RECHARGER.1", "RECHARGER", new ItemStack(TR_Blocks.blockAdvRechargePed), 6, new ItemStack(BlocksTC.rechargePedestal), aspects, new ItemStack(Blocks.GOLD_BLOCK),new ItemStack(Items.EMERALD),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(ItemsTC.salisMundus),new ItemStack(BlocksTC.metalBlockThaumium),new ItemStack(Items.EMERALD));

        aspects = new AspectList().add(Aspect.MAGIC,30).add(Aspect.LIFE,20).add(Aspect.PROTECT,15).add(Aspect.ORDER, 10);
        addInfusionRecipe("WITHERRING.1", "WITHERRING", new ItemStack(TR_Items.itemWitherRing), 5, new ItemStack(ItemsTC.baubles,1,1), aspects, new ItemStack(Items.NETHER_STAR),new ItemStack(Items.SKULL,1,1),new ItemStack(Items.MILK_BUCKET),new ItemStack(Items.SKULL,1,1),new ItemStack(Items.MILK_BUCKET));

        aspects = new AspectList().add(Aspect.AIR, 10).add(Aspect.FIRE, 10).add(Aspect.WATER, 10).add(Aspect.EARTH, 10).add(Aspect.ORDER, 10).add(Aspect.ENTROPY, 10).add(Aspect.MECHANISM, 20);
        addInfusionRecipe("MATSTUD_INFUSEDTHAUMIUM.1", "MATSTUD_INFUSEDTHAUMIUM", new ItemStack(TR_Items.itemPrimalModulator), 4, new ItemStack(ItemsTC.morphicResonator), aspects, new ItemStack(TR_Items.itemShard),new ItemStack(ItemsTC.plate,1,2),new ItemStack(ItemsTC.mechanismComplex),new ItemStack(ItemsTC.plate,1,2));

    }

    private static void addCrucibleRecipes() {
        AspectList aspects = new AspectList().add(Aspect.ENTROPY, 30).add(Aspect.DEATH, 20).add(Aspect.UNDEAD, 40).add(Aspect.DARKNESS,20);
        addCrucibleRecipe("TR_WITHER.1","TR_WITHER", new ItemStack(Items.SKULL,1,1), aspects, new ItemStack(Items.SKULL,1,0));

        aspects = new AspectList().add(Aspect.ORDER, 15).add(Aspect.MAGIC, 10).add(Aspect.VOID, 20).add(Aspect.DARKNESS,10);
        addCrucibleRecipe("TR_ENDER.1","TR_ENDER", new ItemStack(Items.ENDER_PEARL,2,0), aspects, new ItemStack(Items.ENDER_PEARL,1,0));

        aspects = new AspectList().add(Aspect.LIFE, 5).add(Aspect.MAGIC, 5).add(Aspect.MAN, 5).add(Aspect.ALCHEMY,5);
        addCrucibleRecipe("THAUMICTOAST.1","THAUMICTOAST@1", new ItemStack(TR_Items.itemToast,1,0), aspects, new ItemStack(Items.BREAD));
    }

    private static void addCrystalInfuserRecipes() {
    	new RecipeCrystalInfusion("RESTORATION", Aspect.AURA, new ItemStack(Items.QUARTZ), new ItemStack(TR_Items.itemShard));
        new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.AIR, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,0));
        new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.FIRE, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,1));
        new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.WATER, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,2));
        new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.EARTH, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,3));
        new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.ORDER, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,4));
        new RecipeCrystalInfusion("INFUSEDTHAUMIUM@1", Aspect.ENTROPY, new ItemStack(ItemsTC.ingots), new ItemStack(TR_Items.itemIngot,1,5));

    }

    public static void addShapedOreRecipe(String name, ItemStack output, Object... params) {
        ResourceLocation location = new ResourceLocation(ThaumicRestoration.modID, name);
        ShapedOreRecipe recipe = new ShapedOreRecipe(location, output, params);
        recipe.setRegistryName(location);
        ForgeRegistries.RECIPES.register(recipe);
        recipes.put(name, location);
    }

    public static void addShapelessOreRecipe(String name,ItemStack output, Object... params) {
        ResourceLocation location = new ResourceLocation(ThaumicRestoration.modID, name);
        ShapelessOreRecipe recipe = new ShapelessOreRecipe(location, output, params);
        recipe.setRegistryName(location);
        ForgeRegistries.RECIPES.register(recipe);
        recipes.put(name, location);
    }

    public static void addShapedArcaneRecipe(String name, String research, ItemStack output, int vis, AspectList crystals, Object... input) {
        ResourceLocation location = new ResourceLocation(ThaumicRestoration.modID, name);
        ShapedArcaneRecipe recipe = new ShapedArcaneRecipe(location, research, vis, crystals, output, input);
        ThaumcraftApi.addArcaneCraftingRecipe(location, recipe);
        recipes.put(name, location);
    }

    public static void addShapedArcaneCrystalRecipe(String name, String research, ItemStack output,int vis,AspectList crystals,Object... input) {
        ResourceLocation location = new ResourceLocation(ThaumicRestoration.modID, name);
        ShapedArcaneRecipe recipe = new RecipeCrystal(location, research, vis, crystals, output, input);
        ThaumcraftApi.addArcaneCraftingRecipe(location, recipe);
        recipes.put(name, location);
    }

    public static void addInfusionRecipe(String name, String research, ItemStack output, int instability, ItemStack catalyst, AspectList aspects, Object... input) {
        ResourceLocation location = new ResourceLocation(ThaumicRestoration.modID, name);
        InfusionRecipe recipe = new InfusionRecipe(research, output, instability, aspects, catalyst, input);
        ThaumcraftApi.addInfusionCraftingRecipe(location, recipe);
        recipes.put(name, location);
    }

    public static void addCrucibleRecipe(String name, String research, ItemStack output, AspectList aspects, Object input) {
        ResourceLocation location = new ResourceLocation(ThaumicRestoration.modID, name);
        CrucibleRecipe recipe = new CrucibleRecipe(research, output, input, aspects);
        ThaumcraftApi.addCrucibleRecipe(location, recipe);
        recipes.put(name, location);
    }

}
