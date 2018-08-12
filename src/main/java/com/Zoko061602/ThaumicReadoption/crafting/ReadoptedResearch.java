package com.Zoko061602.ThaumicReadoption.crafting;

import com.Zoko061602.ThaumicReadoption.blocks.ReadoptedBlocks;
import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;
import com.Zoko061602.ThaumicReadoption.lib.research.ResearchHelper;
import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchEntry.EnumResearchMeta;
import thaumcraft.api.research.ResearchStage;

public class ReadoptedResearch {

	public static final ResourceLocation backoverlay = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");

	public static final ResourceLocation iconReadoption = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/icon_readoption.png");
	public static final ResourceLocation backReadoption = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/tab_readoption.jpg");

    private static ResearchCategory catReadoption;


	public static void createResearch(){
		catReadoption = ResearchCategories.registerCategory("READOPTION", "FIRSTSTEPS", null, iconReadoption, backReadoption, backoverlay);
		ResearchStage[] stages;
		String[] parents;

		// Thaumic Readoption
		 stages = new ResearchStage[]{
				new ResearchHelper.RSB()
				.setText("research_stage."+ThaumicReadoption.ModID+":readoption.0")
				.build()
		 };

		 parents =new String[] {"FIRSTSTEPS"};

		ResearchHelper.makeReadoptionResearch("READOPTION", "Thaumic Readoption", 0, 0, iconReadoption, stages, parents, EnumResearchMeta.ROUND, EnumResearchMeta.AUTOUNLOCK);

		// Basic Wand
		 stages = new ResearchStage[]{
					new ResearchHelper.RSB()
					.setText("research_stage."+ThaumicReadoption.ModID+":basicwand.0")
					.build(),
					new ResearchHelper.RSB()
					.setText("research_stage."+ThaumicReadoption.ModID+":basicwand.1")
		            .build()
		 };

		 parents =new String[] {"READOPTION","!PLANTWOOD"};

		ResearchHelper.makeReadoptionResearch("BASICWAND", "Basic Wand", 0, -2, new ItemStack(ReadoptedItems.itemWand,1,0), stages, parents, EnumResearchMeta.HIDDEN);

		//Crystal Infusion
		 stages = new ResearchStage[]{
				new ResearchHelper.RSB()
				.setText("research_stage."+ThaumicReadoption.ModID+":crystalinfusion.0")
				.build(),
				new ResearchHelper.RSB()
				.setText("research_stage."+ThaumicReadoption.ModID+":crystalinfusion.1")
	            .build()
		};

		 parents = new String[] {"METALLURGY@3","BASEINFUSION"};

		ResearchHelper.makeReadoptionResearch("CRYSTALINFUSION", "Crystal Infuser", 2, -2, new ItemStack(ReadoptedBlocks.blockInfuser), stages, parents);

	}

}
