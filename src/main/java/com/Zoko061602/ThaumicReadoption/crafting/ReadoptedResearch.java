package com.Zoko061602.ThaumicReadoption.crafting;

import com.Zoko061602.ThaumicReadoption.blocks.ReadoptedBlocks;
import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;
import com.Zoko061602.ThaumicReadoption.lib.research.AidBase;
import com.Zoko061602.ThaumicReadoption.lib.research.ResearchHelper;
import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchAddendum;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchEntry.EnumResearchMeta;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.api.research.ResearchStage.Knowledge;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

public class ReadoptedResearch {

	public static final ResourceLocation backoverlay = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");

	public static final ResourceLocation iconReadoption = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/icon_readoption.png");
	public static final ResourceLocation iconWither = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/icon_wither.png");
	public static final ResourceLocation iconAlchemy = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/icon_alchemy.png");
	public static final ResourceLocation iconTrans = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/icon_trans.png");
	public static final ResourceLocation iconFire = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/icon_fire.png");
	public static final ResourceLocation backReadoption = new ResourceLocation(ThaumicReadoption.ModID, "textures/research/tab_readoption.jpg");

    private static ResearchCategory catReadoption;


    private static final EnumKnowledgeType OBSERVATION = EnumKnowledgeType.OBSERVATION;
    private static final EnumKnowledgeType THEORY = EnumKnowledgeType.THEORY;


	public static void createResearch(){

		catReadoption = ResearchCategories.registerCategory("READOPTION", "FIRSTSTEPS", null, iconReadoption, backReadoption, backoverlay);

		ResearchStage[] stages;
		String[] parents;
		ResearchAddendum[] addenda;

		// Thaumic Readoption
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicReadoption.ModID+":readoption.0")
				   .setKnow(new Knowledge(OBSERVATION, catReadoption, 1))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicReadoption.ModID+":readoption.1")
				   .build()
			 };

		 parents = new String[] {"FIRSTSTEPS"};

		ResearchHelper.makeReadoptionResearch("READOPTION", "Thaumic Readoption", 0, 0, iconReadoption, stages, parents, EnumResearchMeta.ROUND);

		// Deco
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicReadoption.ModID+":trdeco.0")
				   .setRecipes(ReadoptedRecipes.recipes.get("TR_DECO.1"))
				   .build()
		 };

		 addenda = new ResearchAddendum[] {
				   new ResearchHelper.RAB()
				   .setText("research_addendum."+ThaumicReadoption.ModID+":trdeco.0")
				   .setRecipes(ReadoptedRecipes.recipes.get("TR_DECO.2"),ReadoptedRecipes.recipes.get("TR_DECO.3"))
				   .setResearch("METALLURGY@3")
				   .build()
		 };

		 parents = new String[] {"READOPTION","!PLANTWOOD"};


		ResearchHelper.makeReadoptionResearch("TR_DECO", "Decorative Blocks", 2, -1, new ItemStack(ReadoptedBlocks.blockGreatwoodFramed), stages, parents, addenda,EnumResearchMeta.HEX);


		// Novice Wand
		 stages = new ResearchStage[]{
			      new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicReadoption.ModID+":novicewand.0")
				   .setKnow(new Knowledge(THEORY, ResearchCategories.getResearchCategory("AUROMANCY"), 1),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 1))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicReadoption.ModID+":novicewand.1")
				   .setRecipes(ReadoptedRecipes.recipes.get("NOVICEWAND.1"),ReadoptedRecipes.recipes.get("NOVICEWAND.2"),ReadoptedRecipes.recipes.get("NOVICEWAND.3"))
		           .build()
		 };

		 parents = new String[] {"READOPTION","!PLANTWOOD","METALLURGY@2"};

		ResearchHelper.makeReadoptionResearch("NOVICEWAND", "Novice Wand", -1, -2, new ItemStack(ReadoptedItems.itemWand,1,0), stages, parents);

		// Wand Transmutation
		 stages = new ResearchStage[]{
			      new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicReadoption.ModID+":transmutation.0")
				   .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1),new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 1),new Knowledge(OBSERVATION,catReadoption,2))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicReadoption.ModID+":transmutation.1")
		           .build()
		 };

		 parents = new String[] {"NOVICEWAND"};

		ResearchHelper.makeReadoptionResearch("WANDTRANS", "Magic Transmutations", -3, -4, iconTrans, stages, parents,EnumResearchMeta.HIDDEN);


		// Adept Wand
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":adeptwand.0")
				  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3))
				  .setRequiredCraft(new ItemStack(ItemsTC.visResonator))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":adeptwand.1")
				  .setRecipes(ReadoptedRecipes.recipes.get("ADEPTWAND.1"))
	          	  .build(),
		};

		 parents = new String[] {"NOVICEWAND"};

		ResearchHelper.makeReadoptionResearch("ADEPTWAND", "Adept Wand", -4, -2, new ItemStack(ReadoptedItems.itemWand,1,1), stages, parents);

		// Master Wand
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":masterwand.0")
				  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3),new Knowledge(THEORY, catReadoption, 3))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":masterwand.1")
				  .setRecipes(ReadoptedRecipes.recipes.get("MASTERWAND.1"))
	              .build()

		};

		 parents = new String[] {"ADEPTWAND","~INFUSEDTHAUMIUM"};

		ResearchHelper.makeReadoptionResearch("MASTERWAND", "Grandmasters Wand", -7, -2, new ItemStack(ReadoptedItems.itemWand,1,2), stages, parents);

		// Recharge Pedestal
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":recharger.0")
				  .setKnow(new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 2))
				  .setRequiredCraft(new ItemStack(BlocksTC.rechargePedestal))
				  .setWarp(2)
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":recharger.1")
				  .setRecipes(ReadoptedRecipes.recipes.get("RECHARGER.1"))
	              .build()

		};

		 parents = new String[] {"ADEPTWAND","RECHARGEPEDESTAL","METALLURGY@3","BASEINFUSION"};

		ResearchHelper.makeReadoptionResearch("RECHARGER", "Advanced Recharge Pedestal", -5, 0, new ItemStack(ReadoptedBlocks.blockAdvRechargePed), stages, parents);

		//Crystal Infusion
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":crystalinfusion.0")
				  .setKnow(new Knowledge(OBSERVATION,getCategory("AUROMANCY"),3),new Knowledge(THEORY, catReadoption, 2))
				  .setConsumedItems(new ItemStack(BlocksTC.metalBlockThaumium))
				  .setWarp(3)
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":crystalinfusion.1")
				  .setRecipes(ReadoptedRecipes.recipes.get("CRYSTALINFUSION.1"))
	              .build()

		};

		 parents = new String[] {"METALLURGY@3","BASEINFUSION","BASICWAND","READOPTION"};

		ResearchHelper.makeReadoptionResearch("CRYSTALINFUSION", "Crystal Infuser", -2, 2, new ItemStack(ReadoptedBlocks.blockInfuser), stages, parents);

		//Infused Thaumium
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":infusedthaumium.0")
				  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 2))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicReadoption.ModID+":infusedthaumium.1")
	              .build()

		};

		 parents = new String[] {"METALLURGY@3","CRYSTALINFUSION"};

		ResearchHelper.makeReadoptionResearch("INFUSEDTHAUMIUM", "Infused Thaumium", 1, 2, new ItemStack(ReadoptedItems.itemIngot,1,2), stages, parents);



	//Terra Obsidian
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":terraobsidian.0")
			  .setWarp(1)
			  .setKnow(new Knowledge(THEORY, getCategory("ARTIFICE"), 1))
			  .setConsumedItems(new ItemStack(Blocks.OBSIDIAN,4))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":terraobsidian.1")
			  .setRecipes(ReadoptedRecipes.recipes.get("TERRAOBSIDIAN.1"))
             .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM"};

	ResearchHelper.makeReadoptionResearch("TERRAOBSIDIAN", "Terra Infused Obsidian", 2, 4, new ItemStack(ReadoptedBlocks.blockObsidian), stages, parents);

	//Edged Crystals
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":potioncrystals.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3),new Knowledge(OBSERVATION, catReadoption, 3))
			  .setWarp(4)
			  .setConsumedItems(new ItemStack(ReadoptedBlocks.blockObsidian,8))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":potioncrystals.1")
           .build()

	};

	 parents = new String[] {"TERRAOBSIDIAN"};


	ResearchHelper.makeReadoptionResearch("POTIONCRYSTALS", "Edged Crystals [WIP]", 2, 6, new ItemStack(ReadoptedBlocks.blockCrystal), stages, parents);

	//Aqua Bucket
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":aquabucket.0")
			  .setKnow(new Knowledge(THEORY, getCategory("ALCHEMY"), 1))
			  .setConsumedItems(new ItemStack(Items.WATER_BUCKET))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":aquabucket.1")
			  .setRecipes(ReadoptedRecipes.recipes.get("AQUABUCKET.1"))
              .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM"};

	ResearchHelper.makeReadoptionResearch("AQUABUCKET", "Aqua Infused Water Bucket", 0, 4, new ItemStack(ReadoptedItems.itemTRBucket), stages, parents);


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

	ResearchHelper.makeReadoptionResearch("STORAGEUNIT", "StorageUnit", 6, 2, new ItemStack(ReadoptedItems.itemTRBucket), stages, parents);
	*/


	//Alchemy
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":tr_alchemy.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1))
			  .build(),
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":tr_alchemy.1")
			  .build()

	};

	 parents = new String[] {"READOPTION"};

	ResearchHelper.makeReadoptionResearch("TR_ALCHEMY", "Readopted Alchemy", 1, -4, iconAlchemy, stages, parents);



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
			  .setText("research_stage."+ThaumicReadoption.ModID+":tr_ender.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 2),new Knowledge(THEORY, getCategory("AUROMANCY"), 1))
			  .build(),
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":tr_ender.1")
			  .setRecipes(ReadoptedRecipes.recipes.get("TR_ENDER.1"))
              .build()

	};

	 parents = new String[] {"TR_ALCHEMY"};

	ResearchHelper.makeReadoptionResearch("TR_ENDER", "Ender Pearl Duplication", 4, -5, new ItemStack(Items.ENDER_PEARL), stages, parents);

	//Alchemy
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":tr_wither.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 3),new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setWarp(3)
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":tr_wither.1")
			  .setRecipes(ReadoptedRecipes.recipes.get("TR_WITHER.1"))
              .build(),

	};

	 parents = new String[] {"TR_ALCHEMY"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("TR_WITHER", "Skull Corruption", 0, -5, iconWither, stages, parents);

	//Wither Ring
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":wither_ring.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Blocks.SKULL,1,1))
			  .setWarp(2)
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":wither_ring.1")
			  .setRecipes(ReadoptedRecipes.recipes.get("WITHERRING.1"))
             .build(),

	};

	 parents = new String[] {"READOPTION","INFUSION","METALLURGY@2"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("WITHERRING", "Ring of Wither Protection", -4, 3, new ItemStack(ReadoptedItems.itemWitherRing), stages, parents);

	//Wand Fire
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":wandfire.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Items.FLINT_AND_STEEL,1,0))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":wandfire.1")
              .build(),

	};

	 parents = new String[] {"NOVICEWAND"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("WANDFIRE", "Hellfire Overlord", -2, -1, iconFire, stages, parents,EnumResearchMeta.HEX);


	//Toast
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":toast.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Items.BREAD,1,64))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":toast.1")
			  .setRecipes(ReadoptedRecipes.recipes.get("THAUMICTOAST.1"))
             .build(),

	};

	 parents = new String[] {"TR_ALCHEMY"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("THAUMICTOAST", "Thaumic Toast", 3, -3, new ItemStack(ReadoptedItems.itemToast), stages, parents);

   }

	/*private static void createAid() {
	 TheorycraftCard[] cards = new TheorycraftCard[]{
      Card
	 };
		new AidBase(ReadoptedBlocks.blockInfuser, cards);
	}*/

	public static ResearchCategory getCategory(String cat) {
		return ResearchCategories.getResearchCategory(cat);
	}



}
