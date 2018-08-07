package com.Zoko061602.ThaumicReadoption.crafting;

import com.Zoko061602.ThaumicReadoption.items.ReadoptedItems;
import com.Zoko061602.ThaumicReadoption.lib.crafting.IWandTrigger;
import com.Zoko061602.ThaumicReadoption.lib.crafting.RecipeCrystalInfusion;
import com.Zoko061602.ThaumicReadoption.lib.crafting.WandTriggerMultiblock;
import com.Zoko061602.ThaumicReadoption.lib.crafting.WandTriggerOre;
import com.Zoko061602.ThaumicReadoption.lib.crafting.WandTriggerSimple;

import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.ItemStackHandler;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.Part;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.blocks.basic.BlockPillar;
import thaumcraft.common.config.ConfigItems;

public class ReadoptedRecipes {

	public static void addRecipes(){

		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.AIR, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,0)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.FIRE, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,1)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.WATER, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,2)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.EARTH, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,3)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.ORDER, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,4)).register();
		new RecipeCrystalInfusion("FIRSTSTEPS@1", Aspect.ENTROPY, new ItemStack(ItemsTC.ingots), new ItemStack(ReadoptedItems.itemIngot,1,5)).register();

		//Thaumonomicon
	    IWandTrigger.registerWandTrigger(new WandTriggerSimple("!gotdream", Blocks.BOOKSHELF, new ItemStack(ItemsTC.thaumonomicon),0));
	    IWandTrigger.registerWandTrigger(new WandTriggerOre("!gotdream", "bookshelf", new ItemStack(ItemsTC.thaumonomicon),0));

	    //Workbench
	    IWandTrigger.registerWandTrigger(new WandTriggerSimple("FIRSTSTEPS@1", Blocks.CRAFTING_TABLE, new ItemStack(BlocksTC.arcaneWorkbench),0));
	    IWandTrigger.registerWandTrigger(new WandTriggerOre("FIRSTSTEPS@1", "workbench", new ItemStack(BlocksTC.arcaneWorkbench),0));

	    //Crucible
	    IWandTrigger.registerWandTrigger(new WandTriggerSimple("UNLOCKALCHEMY@1", Blocks.CAULDRON, new ItemStack(BlocksTC.crucible),0));

	    //Test
	    IWandTrigger.registerWandTrigger(new WandTriggerSimple("FIRSTSTEPS@1", Blocks.SEA_LANTERN, new ItemStack(BlocksTC.amberBlock),0));

	    //Infernal Furnace
	    Part NB = new Part(Blocks.NETHER_BRICK, new ItemStack(BlocksTC.placeholderNetherbrick));
	    Part OB = new Part(Blocks.OBSIDIAN, new ItemStack(BlocksTC.placeholderObsidian));
	    Part IB = new Part(Blocks.IRON_BARS, "AIR");
	    Part LA = new Part(Material.LAVA, BlocksTC.infernalFurnace, true);
	    Part[][][] infernalFurnaceBlueprint = { { { NB, OB, NB }, { OB, null, OB }, { NB, OB, NB } }, { { NB, OB, NB }, { OB, LA, OB }, { NB, IB, NB } }, { { NB, OB, NB }, { OB, OB, OB }, { NB, OB, NB } } };
	    IWandTrigger.registerWandTrigger(new WandTriggerMultiblock("INFERNALFURNACE", infernalFurnaceBlueprint, 50));

	    // Basic Matrix
	    Part IM = new Part(BlocksTC.infusionMatrix, null);
	    Part SNT = new Part(BlocksTC.stoneArcane, "AIR");
	    Part SNB1 = new Part(BlocksTC.stoneArcane, new ItemStack(BlocksTC.pillarArcane, 1, BlockPillar.calcMeta(EnumFacing.EAST)));
	    Part SNB2 = new Part(BlocksTC.stoneArcane, new ItemStack(BlocksTC.pillarArcane, 1, BlockPillar.calcMeta(EnumFacing.NORTH)));
	    Part SNB3 = new Part(BlocksTC.stoneArcane, new ItemStack(BlocksTC.pillarArcane, 1, BlockPillar.calcMeta(EnumFacing.SOUTH)));
	    Part SNB4 = new Part(BlocksTC.stoneArcane, new ItemStack(BlocksTC.pillarArcane, 1, BlockPillar.calcMeta(EnumFacing.WEST)));
	    Part PN = new Part(BlocksTC.pedestalArcane.getDefaultState(), null);
	    Part[][][] infusionAltarNormalBlueprint = { { { null, null, null }, { null, IM, null }, { null, null, null } }, { { SNT, null, SNT }, { null, null, null }, { SNT, null, SNT } }, { { SNB1, null, SNB2 }, { null, PN, null }, { SNB3, null, SNB4 } } };
	    IWandTrigger.registerWandTrigger(new WandTriggerMultiblock("INFUSION", infusionAltarNormalBlueprint, 50));

	    // Ancient Matrix
	    Part SAT = new Part(BlocksTC.stoneAncient, "AIR");
	    Part SAB1 = new Part(BlocksTC.stoneAncient, new ItemStack(BlocksTC.pillarAncient, 1, BlockPillar.calcMeta(EnumFacing.EAST)));
	    Part SAB2 = new Part(BlocksTC.stoneAncient, new ItemStack(BlocksTC.pillarAncient, 1, BlockPillar.calcMeta(EnumFacing.NORTH)));
	    Part SAB3 = new Part(BlocksTC.stoneAncient, new ItemStack(BlocksTC.pillarAncient, 1, BlockPillar.calcMeta(EnumFacing.SOUTH)));
	    Part SAB4 = new Part(BlocksTC.stoneAncient, new ItemStack(BlocksTC.pillarAncient, 1, BlockPillar.calcMeta(EnumFacing.WEST)));
	    Part PA = new Part(BlocksTC.pedestalAncient.getStateFromMeta(2), null);
	    Part[][][] infusionAltarAncientBlueprint = { { { null, null, null }, { null, IM, null }, { null, null, null } }, { { SAT, null, SAT }, { null, null, null }, { SAT, null, SAT } }, { { SAB1, null, SAB2 }, { null, PA, null }, { SAB3, null, SAB4 } } };
	    IWandTrigger.registerWandTrigger(new WandTriggerMultiblock("INFUSIONANCIENT", infusionAltarAncientBlueprint, 50));

	    // Eldritch Matrix
	    Part SET = new Part(BlocksTC.stoneEldritchTile, "AIR");
	    Part SEB1 = new Part(BlocksTC.stoneEldritchTile, new ItemStack(BlocksTC.pillarEldritch, 1, BlockPillar.calcMeta(EnumFacing.EAST)));
	    Part SEB2 = new Part(BlocksTC.stoneEldritchTile, new ItemStack(BlocksTC.pillarEldritch, 1, BlockPillar.calcMeta(EnumFacing.NORTH)));
	    Part SEB3 = new Part(BlocksTC.stoneEldritchTile, new ItemStack(BlocksTC.pillarEldritch, 1, BlockPillar.calcMeta(EnumFacing.SOUTH)));
	    Part SEB4 = new Part(BlocksTC.stoneEldritchTile, new ItemStack(BlocksTC.pillarEldritch, 1, BlockPillar.calcMeta(EnumFacing.WEST)));
	    Part PE = new Part(BlocksTC.pedestalEldritch.getStateFromMeta(1), null);
	    Part[][][] infusionAltarEldritchBlueprint = { { { null, null, null }, { null, IM, null }, { null, null, null } }, { { SET, null, SET }, { null, null, null }, { SET, null, SET } }, { { SEB1, null, SEB2 }, { null, PE, null }, { SEB3, null, SEB4 } } };
	    IWandTrigger.registerWandTrigger(new WandTriggerMultiblock("INFUSIONELDRITCH", infusionAltarEldritchBlueprint,50));

        // Thaumatorium
	    Part TH1 = new Part(BlocksTC.metalAlchemical.getDefaultState(), BlocksTC.thaumatoriumTop).setApplyPlayerFacing(true);
	    Part TH2 = new Part(BlocksTC.metalAlchemical.getDefaultState(), BlocksTC.thaumatorium).setApplyPlayerFacing(true);
	    Part TH3 = new Part(BlocksTC.crucible, null);
	    Part[][][] thaumotoriumBlueprint = { { { TH1 } }, { { TH2 } }, { { TH3 } } };
	    IWandTrigger.registerWandTrigger(new WandTriggerMultiblock("THAUMATORIUM", thaumotoriumBlueprint, 25));


	    Part GP1 = new Part(Blocks.IRON_BARS, new ItemStack(BlocksTC.placeholderBars));
	    Part GP2 = new Part(Blocks.CAULDRON, new ItemStack(BlocksTC.placeholderCauldron));
	    Part GP3 = new Part(Blocks.PISTON.getDefaultState().withProperty(BlockPistonBase.FACING, EnumFacing.UP), BlocksTC.golemBuilder);
	    Part GP4 = new Part(Blocks.ANVIL, new ItemStack(BlocksTC.placeholderAnvil));
	    Part GP5 = new Part(BlocksTC.tableStone, new ItemStack(BlocksTC.placeholderTable));
	    Part[][][] golempressBlueprint = { { { null, null }, { GP1, null } }, { { GP2, GP4 }, { GP3, GP5 } } };

	    IWandTrigger.registerWandTrigger(new WandTriggerMultiblock("MINDCLOCKWORK", golempressBlueprint, 30));

	}

}
