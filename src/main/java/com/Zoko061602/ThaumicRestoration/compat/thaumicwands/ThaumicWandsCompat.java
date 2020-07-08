package com.Zoko061602.ThaumicRestoration.compat.thaumicwands;

import static thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType.THEORY;

import com.Zoko061602.ThaumicRestoration.compat.RestoredCompat.IRestoredCompatModule;
import com.Zoko061602.ThaumicRestoration.crafting.TR_Recipes;
import com.Zoko061602.ThaumicRestoration.crafting.TR_Research;
import com.Zoko061602.ThaumicRestoration.items.ItemBaseMeta;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.lib.research.ResearchHelper;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import de.zpenguin.thaumicwands.api.ThaumicWandsAPI;
import de.zpenguin.thaumicwands.item.TW_Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.api.research.ResearchStage.Knowledge;

public class ThaumicWandsCompat implements IRestoredCompatModule {

	public static ItemBaseMeta itemWandCap = new ItemBaseMeta("item_wand_cap_tr", "aer", "ignis", "aqua", "terra", "ordo", "perditio");

	@Override
	public void init(FMLInitializationEvent e) {
		for(int i=0;i!=itemWandCap.getVariants().length;i++)
		ThaumicWandsAPI.registerWandCap(itemWandCap.getVariants()[i], new TR_WandCap(itemWandCap.getVariants()[i], new ItemStack(itemWandCap,1,i)));

		AspectList aspects = new AspectList().add(Aspect.AIR,50).add(Aspect.MOTION, 25).add(Aspect.ENERGY, 50).add(Aspect.AURA, 25).add(Aspect.MAGIC, 25);
		TR_Recipes.addInfusionRecipe("CAP_INFUSEDTHAUMIUM.1","CAP_INFUSEDTHAUMIUM", new ItemStack(itemWandCap, 1, 0), 5, new ItemStack(TW_Items.itemWandCap, 1, 5), aspects, new ItemStack(TR_Items.itemIngot,1, 0), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 0), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 0), new ItemStack(ItemsTC.salisMundus));

		aspects = new AspectList().add(Aspect.FIRE,50).add(Aspect.BEAST, 25).add(Aspect.ENERGY, 50).add(Aspect.AURA, 25).add(Aspect.MAGIC, 25);
		TR_Recipes.addInfusionRecipe("CAP_INFUSEDTHAUMIUM.2","CAP_INFUSEDTHAUMIUM", new ItemStack(itemWandCap, 1, 1), 5, new ItemStack(TW_Items.itemWandCap, 1, 5), aspects, new ItemStack(TR_Items.itemIngot,1, 1), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 1), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 1), new ItemStack(ItemsTC.salisMundus));

		aspects = new AspectList().add(Aspect.WATER,50).add(Aspect.COLD, 25).add(Aspect.ENERGY, 50).add(Aspect.AURA, 25).add(Aspect.MAGIC, 25);
		TR_Recipes.addInfusionRecipe("CAP_INFUSEDTHAUMIUM.3","CAP_INFUSEDTHAUMIUM", new ItemStack(itemWandCap, 1, 2), 5, new ItemStack(TW_Items.itemWandCap, 1, 5), aspects, new ItemStack(TR_Items.itemIngot,1, 2), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 2), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 2), new ItemStack(ItemsTC.salisMundus));

		aspects = new AspectList().add(Aspect.EARTH,50).add(Aspect.DARKNESS, 25).add(Aspect.ENERGY, 50).add(Aspect.AURA, 25).add(Aspect.MAGIC, 25);
		TR_Recipes.addInfusionRecipe("CAP_INFUSEDTHAUMIUM.4","CAP_INFUSEDTHAUMIUM", new ItemStack(itemWandCap, 1, 3), 5, new ItemStack(TW_Items.itemWandCap, 1, 5), aspects, new ItemStack(TR_Items.itemIngot,1, 3), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 3), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 3), new ItemStack(ItemsTC.salisMundus));

		aspects = new AspectList().add(Aspect.ORDER,50).add(Aspect.CRYSTAL, 25).add(Aspect.ENERGY, 50).add(Aspect.AURA, 25).add(Aspect.MAGIC, 25);
		TR_Recipes.addInfusionRecipe("CAP_INFUSEDTHAUMIUM.5","CAP_INFUSEDTHAUMIUM", new ItemStack(itemWandCap, 1, 4), 5, new ItemStack(TW_Items.itemWandCap, 1, 5), aspects, new ItemStack(TR_Items.itemIngot,1, 4), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 4), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 4), new ItemStack(ItemsTC.salisMundus));

		aspects = new AspectList().add(Aspect.ENTROPY,50).add(Aspect.UNDEAD, 25).add(Aspect.ENERGY, 50).add(Aspect.AURA, 25).add(Aspect.MAGIC, 25);
		TR_Recipes.addInfusionRecipe("CAP_INFUSEDTHAUMIUM.6","CAP_INFUSEDTHAUMIUM", new ItemStack(itemWandCap, 1, 5), 5, new ItemStack(TW_Items.itemWandCap, 1, 5), aspects, new ItemStack(TR_Items.itemIngot,1, 5), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 5), new ItemStack(ItemsTC.salisMundus), new ItemStack(TR_Items.itemIngot,1, 5), new ItemStack(ItemsTC.salisMundus));

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {

        ResearchStage[] stages;
        String[] parents;

        // Infused Thaumium Caps
        stages = new ResearchStage[] {
            new ResearchHelper.RSB()
                .setText("research_stage." + ThaumicRestoration.modID + ":cap_infusedthaumium.0")
                .setKnow(new Knowledge(THEORY, TR_Research.getCategory("THAUMATURGY"), 3),new Knowledge(THEORY, TR_Research.catRestoration, 2))
                .build(),
            new ResearchHelper.RSB()
                .setText("research_stage." + ThaumicRestoration.modID + ":cap_infusedthaumium.1")
                .setRecipes(TR_Recipes.recipes.get("CAP_INFUSEDTHAUMIUM.1"),TR_Recipes.recipes.get("CAP_INFUSEDTHAUMIUM.2"),TR_Recipes.recipes.get("CAP_INFUSEDTHAUMIUM.3"),TR_Recipes.recipes.get("CAP_INFUSEDTHAUMIUM.4"),TR_Recipes.recipes.get("CAP_INFUSEDTHAUMIUM.5"),TR_Recipes.recipes.get("CAP_INFUSEDTHAUMIUM.6"))
                .build()
        };
        parents = new String[] {"INFUSEDTHAUMIUM","CAP_THAUMIUM"};
        ResearchHelper.makeRestorationResearch("CAP_INFUSEDTHAUMIUM", "Infused Thaumium Caps", 2, 1, new ItemStack(itemWandCap,1,1), stages, parents);

	}

}
