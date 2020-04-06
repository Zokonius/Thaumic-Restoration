package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.lib.research.ResearchHelper;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import static thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType.*;
import static thaumcraft.api.research.ResearchEntry.EnumResearchMeta.*;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchAddendum;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.api.research.ResearchStage.Knowledge;
import thaumcraft.api.research.theorycraft.CardExperimentation;
import thaumcraft.common.lib.research.theorycraft.CardAwareness;
import thaumcraft.common.lib.research.theorycraft.CardBeacon;
import thaumcraft.common.lib.research.theorycraft.CardChannel;
import thaumcraft.common.lib.research.theorycraft.CardFocus;
import thaumcraft.common.lib.research.theorycraft.CardMeasure;

public class TR_Research {

	public static final ResourceLocation backoverlay = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");

	public static final ResourceLocation iconRestoration = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_restoration.png");
	public static final ResourceLocation iconAlchemy = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_alchemy.png");
	public static final ResourceLocation iconTrans = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_trans.png");
	public static final ResourceLocation iconFire = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_fire.png");
	public static final ResourceLocation backRestoration = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/tab_restoration.jpg");
    public static final AspectList tabAspects = new AspectList().add(Aspect.MAGIC,20).add(Aspect.MECHANISM,20).add(Aspect.CRAFT,15).add(Aspect.AURA, 15).add(Aspect.ALCHEMY, 10).add(Aspect.CRYSTAL,10).add(Aspect.ENERGY,10);

    public static ResearchCategory catRestoration;

    @SuppressWarnings("unchecked")
	public static void createHelps(){
    	ResearchHelper.makeAid(TR_Blocks.blockAdvRechargePed, CardFocus.class, CardAwareness.class);
    	ResearchHelper.makeAid(TR_Blocks.blockInfuser, CardMeasure.class, CardChannel.class, CardExperimentation.class);
    	ResearchHelper.makeAid(TR_Blocks.blockCrystal, CardBeacon.class);

    }


	public static void createResearch(){

		catRestoration = ResearchCategories.registerCategory("RESTORATION", "FIRSTSTEPS", tabAspects, iconRestoration, backRestoration, backoverlay);

		ResearchStage[] stages;
		String[] parents;
		ResearchAddendum[] addenda;

		// Thaumic Readoption
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":restoration.0")
				   .setKnow(new Knowledge(OBSERVATION, catRestoration, 1))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":restoration.1")
				   .build()
			 };

		 parents = new String[] {"FIRSTSTEPS"};

		ResearchHelper.makeRestorationResearch("RESTORATION", "Thaumic Restoration", 0, 0, iconRestoration, stages, parents, ROUND);

		// Deco
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":trdeco.0")
				   .setRecipes(TR_Recipes.recipes.get("TR_DECO.1"))
				   .build()
		 };

		 addenda = new ResearchAddendum[] {
				   new ResearchHelper.RAB()
				   .setText("research_addendum."+ThaumicRestoration.ModID+":trdeco.0")
				   .setRecipes(TR_Recipes.recipes.get("TR_DECO.2"),TR_Recipes.recipes.get("TR_DECO.3"))
				   .setResearch("METALLURGY@3")
				   .build()
		 };

		 parents = new String[] {"!PLANTWOOD"};


		ResearchHelper.makeRestorationResearch("TR_DECO", "Decorative Blocks", 2, -1, new ItemStack(TR_Blocks.blockGreatwoodFramed), stages, parents, addenda, ROUND, HIDDEN);


		// Novice Wand
		 stages = new ResearchStage[]{
			      new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":novicewand.0")
				   .setKnow(new Knowledge(THEORY, ResearchCategories.getResearchCategory("AUROMANCY"), 1),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 1))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":novicewand.1")
				   .setRecipes(TR_Recipes.recipes.get("NOVICEWAND.1"),TR_Recipes.recipes.get("NOVICEWAND.2"),TR_Recipes.recipes.get("NOVICEWAND.3"))
		           .build()
		 };

		 parents = new String[] {"RESTORATION","!PLANTWOOD","METALLURGY@2"};

		ResearchHelper.makeRestorationResearch("NOVICEWAND", "Novice Wand", -1, -2, new ItemStack(TR_Items.itemWand,1,0), stages, parents);

		// Wand Transmutation
		 stages = new ResearchStage[]{
			      new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":transmutation.0")
				   .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1),new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 1),new Knowledge(OBSERVATION,catRestoration,2))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":transmutation.1")
		           .build()
		 };

		 parents = new String[] {"NOVICEWAND"};

		ResearchHelper.makeRestorationResearch("WANDTRANS", "Magic Transmutations", -3, -4, iconTrans, stages, parents, HIDDEN);


		// Adept Wand
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":adeptwand.0")
				  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3))
				  .setRequiredCraft(new ItemStack(ItemsTC.visResonator))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":adeptwand.1")
				  .setRecipes(TR_Recipes.recipes.get("ADEPTWAND.1"))
	          	  .build(),
		};

		 parents = new String[] {"NOVICEWAND"};

		ResearchHelper.makeRestorationResearch("ADEPTWAND", "Adept Wand", -4, -2, new ItemStack(TR_Items.itemWand,1,1), stages, parents);

		// Master Wand
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":masterwand.0")
				  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3),new Knowledge(THEORY, catRestoration, 3))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":masterwand.1")
				  .setRecipes(TR_Recipes.recipes.get("MASTERWAND.1"))
	              .build()

		};

		 parents = new String[] {"ADEPTWAND","~INFUSEDTHAUMIUM"};

		ResearchHelper.makeRestorationResearch("MASTERWAND", "Grandmasters Wand", -7, -2, new ItemStack(TR_Items.itemWand,1,2), stages, parents);

		// Recharge Pedestal
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":recharger.0")
				  .setKnow(new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 2))
				  .setRequiredCraft(new ItemStack(BlocksTC.rechargePedestal))
				  .setWarp(2)
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":recharger.1")
				  .setRecipes(TR_Recipes.recipes.get("RECHARGER.1"))
	              .build()

		};

		 parents = new String[] {"ADEPTWAND","RECHARGEPEDESTAL","METALLURGY@3","BASEINFUSION"};

		ResearchHelper.makeRestorationResearch("RECHARGER", "Advanced Recharge Pedestal", -5, 0, new ItemStack(TR_Blocks.blockAdvRechargePed), stages, parents);

		//Crystal Infusion
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":crystalinfusion.0")
				  .setKnow(new Knowledge(OBSERVATION,getCategory("AUROMANCY"),3),new Knowledge(THEORY, catRestoration, 2))
				  .setConsumedItems(new ItemStack(BlocksTC.metalBlockThaumium))
				  .setWarp(3)
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":crystalinfusion.1")
				  .setRecipes(TR_Recipes.recipes.get("CRYSTALINFUSION.1"))
	              .build()

		};

		 parents = new String[] {"METALLURGY@3","BASEINFUSION","~NOVICEWAND","RESTORATION"};

		ResearchHelper.makeRestorationResearch("CRYSTALINFUSION", "Crystal Infuser", -2, 2, new ItemStack(TR_Blocks.blockInfuser), stages, parents);

		//Infused Thaumium
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":infusedthaumium.0")
				  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 2))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":infusedthaumium.1")
	              .build()

		};

		 parents = new String[] {"METALLURGY@3","CRYSTALINFUSION"};

		ResearchHelper.makeRestorationResearch("INFUSEDTHAUMIUM", "Infused Thaumium", 1, 3, new ItemStack(TR_Items.itemIngot,1,2), stages, parents);

		//Material Studies Infused Thaumium
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":mat_infusedthaumium.0")
				  .build()
		};

		 parents = new String[] {"INFUSEDTHAUMIUM","MATSTUDTHAUMIUM"};

		ResearchHelper.makeRestorationResearch("MATSTUD_INFUSEDTHAUMIUM", "Material Studies: Infused Thaumium", 2, 1, new ItemStack(TR_Items.itemIngot,1,3), stages, parents, HIDDEN, ROUND);

		//Material Studies Tallow
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":mat_tallow.0")
				  .build()

		};

		 parents = new String[] {"MATSTUDWOOD","HEDGEALCHEMY@2"};

		ResearchHelper.makeRestorationResearch("MATSTUD_TALLOW", "Material Studies: Tallow", 5, -2, new ItemStack(ItemsTC.tallow), stages, parents, HIDDEN, ROUND);

		//Material Studies Silverwood
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":mat_silverwood.0")
				  .build()

		};

		 parents = new String[] {"MATSTUDWOOD","!PLANTWOOD"};

		ResearchHelper.makeRestorationResearch("MATSTUD_SILVERWOOD", "Material Studies: Silverwood", 5, -1, new ItemStack(BlocksTC.logSilverwood), stages, parents, HIDDEN, ROUND);



	//Terra Obsidian
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":terraobsidian.0")
			  .setWarp(1)
			  .setKnow(new Knowledge(THEORY, getCategory("ARTIFICE"), 1))
			  .setConsumedItems(new ItemStack(Blocks.OBSIDIAN,4))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":terraobsidian.1")
			  .setRecipes(TR_Recipes.recipes.get("TERRAOBSIDIAN.1"))
             .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM"};

	ResearchHelper.makeRestorationResearch("TERRAOBSIDIAN", "Terra Infused Obsidian", 2, 5, new ItemStack(TR_Blocks.blockObsidian), stages, parents);

	//Edged Crystals
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":potioncrystals.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3),new Knowledge(OBSERVATION, catRestoration, 3))
			  .setWarp(4)
			  .setConsumedItems(new ItemStack(TR_Blocks.blockObsidian,8))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":potioncrystals.1")
			  .setRecipes(TR_Recipes.recipes.get("POTIONCRYSTALS.1"))
           .build()

	};

	 parents = new String[] {"TERRAOBSIDIAN"};


	ResearchHelper.makeRestorationResearch("POTIONCRYSTALS", "Edged Crystals", 2, 7, new ItemStack(TR_Blocks.blockCrystal), stages, parents);

	//Aqua Bucket
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":aquabucket.0")
			  .setKnow(new Knowledge(THEORY, getCategory("ALCHEMY"), 1))
			  .setConsumedItems(new ItemStack(Items.WATER_BUCKET))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":aquabucket.1")
			  .setRecipes(TR_Recipes.recipes.get("AQUABUCKET.1"))
              .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM"};

	ResearchHelper.makeRestorationResearch("AQUABUCKET", "Aqua Infused Water Bucket", 0, 5, new ItemStack(TR_Items.itemTRBucket), stages, parents);

	//Paving Aer
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":paving_aer.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 1))
			  .setConsumedItems(new ItemStack(BlocksTC.pavingStoneTravel,4,0),new ItemStack(BlocksTC.pavingStoneBarrier,4,0))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":paving_aer.1")
			  .setRecipes(TR_Recipes.recipes.get("PAVING_AER.1"))
              .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM","PAVINGSTONES"};

	ResearchHelper.makeRestorationResearch("PAVING_AER", "Paving Stone of Permeability", 3, 4, new ItemStack(TR_Blocks.blockPavingAer), stages, parents);


	/*/Storage Unit
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":storageunit.0")
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":storageunit.1")
           .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM","TR_DECO"};

	ResearchHelper.makeReadoptionResearch("STORAGEUNIT", "StorageUnit", 6, 3, new ItemStack(ReadoptedItems.itemTRBucket), stages, parents);
	*/


	//Alchemy
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_alchemy.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1))
			  .build(),
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_alchemy.1")
			  .build()

	};

	 parents = new String[] {"RESTORATION"};

	ResearchHelper.makeRestorationResearch("TR_ALCHEMY", "Restored Alchemy", 1, -4, iconAlchemy, stages, parents);



	/*/Steel
	if(OreDictionary.doesOreNameExist("nuggetSteel")){
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":steeltrans.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":steeltrans.1")
              .build()

	};

	 parents = new String[] {"TR_ALCHEMY"};


	ResearchHelper.makeReadoptionResearch("TR_STEEL", "Steel Transmutation", 4, -3, OreDictionary.getOres("nuggetSteel").get(1), stages, parents);
	}
	*/

	//Ender Pearl
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_ender.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 2),new Knowledge(THEORY, getCategory("AUROMANCY"), 1))
			  .build(),
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_ender.1")
			  .setRecipes(TR_Recipes.recipes.get("TR_ENDER.1"))
              .build()

	};

	 parents = new String[] {"TR_ALCHEMY"};

	ResearchHelper.makeRestorationResearch("TR_ENDER", "Ender Pearl Duplication", 4, -5, new ItemStack(Items.ENDER_PEARL), stages, parents);

	//Alchemy
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_wither.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 3),new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setWarp(3)
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_wither.1")
			  .setRecipes(TR_Recipes.recipes.get("TR_WITHER.1"))
              .build(),

	};

	 parents = new String[] {"TR_ALCHEMY"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeRestorationResearch("TR_WITHER", "Skull Corruption", 0, -5, new ItemStack(Items.SKULL,1,1), stages, parents);

	//Wither Ring
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wither_ring.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Items.SKULL,1,1))
			  .setWarp(2)
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wither_ring.1")
			  .setRecipes(TR_Recipes.recipes.get("WITHERRING.1"))
             .build(),

	};

	 parents = new String[] {"RESTORATION","INFUSION","METALLURGY@2"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeRestorationResearch("WITHERRING", "Ring of Wither Protection", -4, 3, new ItemStack(TR_Items.itemWitherRing), stages, parents);

	//Wand Fire
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wandfire.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Items.FLINT_AND_STEEL,1,0))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wandfire.1")
              .build(),

	};

	 parents = new String[] {"NOVICEWAND"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeRestorationResearch("WANDFIRE", "Hellfire Overlord", -2, -1, iconFire, stages, parents, HEX);


	//Toast
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":toast.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Items.BREAD,32,0))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":toast.1")
			  .setRecipes(TR_Recipes.recipes.get("THAUMICTOAST.1"))
             .build(),

	};

	 parents = new String[] {"TR_ALCHEMY"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeRestorationResearch("THAUMICTOAST", "Thaumic Toast", 3, -3, new ItemStack(TR_Items.itemToast), stages, parents);

   }

	public static ResearchCategory getCategory(String cat) {
		return ResearchCategories.getResearchCategory(cat);
	}



}
