package com.Zoko061602.ThaumicRestoration.compat.tconstruct;

import com.Zoko061602.ThaumicRestoration.blocks.BlockBaseFluid;
import com.Zoko061602.ThaumicRestoration.compat.RestoredCompatModule;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.lib.FluidHelper;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class TConstructCompat extends RestoredCompatModule {

	public static final Material aer_thaumium = new Material("aer_thaumium", 0xEDEF59);
	public static final Material ignis_thaumium = new Material("ignis_thaumium", 0xEE4B00);
	public static final Material aqua_thaumium = new Material("aqua_thaumium", 0x2DC5D9);
	public static final Material terra_thaumium = new Material("terra_thaumium", 0x4CB602);
	public static final Material ordo_thaumium = new Material("ordo_thaumium", 0xE4E6FD);
	public static final Material perditio_thaumium = new Material("perditio_thaumium", 0x585858);

	public static AbstractTrait tr_entropic = new TraitEntropic(0x585858);

	public static Fluid fluidAer = FluidHelper.setupFluid(new FluidColouredMetal("fluid_molten_aer", 0xEDEF59, 1000));
	public static Fluid fluidIgnis = FluidHelper.setupFluid(new FluidColouredMetal("fluid_molten_ignis", 0xEE4B00, 1000));
	public static Fluid fluidAqua = FluidHelper.setupFluid(new FluidColouredMetal("fluid_molten_aqua", 0x2DC5D9, 1000));
	public static Fluid fluidTerra = FluidHelper.setupFluid(new FluidColouredMetal("fluid_molten_terra", 0x4CB602, 1000));
	public static Fluid fluidOrdo = FluidHelper.setupFluid(new FluidColouredMetal("fluid_molten_ordo", 0xE4E6FD, 1000));
	public static Fluid fluidPerditio = FluidHelper.setupFluid(new FluidColouredMetal("fluid_molten_perditio", 0x585858, 1000));

	public static Block blockFluidAer = new BlockBaseFluid("block_molten_aer", fluidAer, net.minecraft.block.material.Material.LAVA);
	public static Block blockFluidIgnis = new BlockBaseFluid("block_molten_ignis", fluidIgnis, net.minecraft.block.material.Material.LAVA);;
	public static Block blockFluidAqua = new BlockBaseFluid("block_molten_aqua", fluidAqua, net.minecraft.block.material.Material.LAVA);;
	public static Block blockFluidTerra = new BlockBaseFluid("block_molten_terra", fluidTerra, net.minecraft.block.material.Material.LAVA);;
	public static Block blockFluidOrdo = new BlockBaseFluid("block_molten_ordo", fluidOrdo, net.minecraft.block.material.Material.LAVA);;
	public static Block blockFluidPerditio = new BlockBaseFluid("block_molten_perditio", fluidPerditio, net.minecraft.block.material.Material.LAVA);;

	@Override
	public void preInit() {

		FMLInterModComms.sendMessage("tconstruct", "blacklistMelting", new ItemStack(TR_Items.itemTRBucket, 1, 0));

		//Aer
		TinkerRegistry.addMaterialStats(aer_thaumium,
				new HeadMaterialStats(1000, 16F, 6F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(1.5f, 100),
				new ExtraMaterialStats(100));

		TinkerRegistry.integrate(aer_thaumium,fluidAer,"ThaumiumAer").preInit();

		//Ignis
		TinkerRegistry.addMaterialStats(ignis_thaumium,
				new HeadMaterialStats(1000, 8F, 6F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(1.5f, 100),
				new ExtraMaterialStats(100));

		TinkerRegistry.integrate(ignis_thaumium, fluidIgnis,"ThaumiumIgnis").preInit();


		TinkerRegistry.addMaterialStats(aqua_thaumium,
				new HeadMaterialStats(1000, 8F, 6F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(1.5f, 100),
				new ExtraMaterialStats(100));

		TinkerRegistry.integrate(aqua_thaumium, fluidAqua,"ThaumiumAqua").preInit();


		//Terra
		TinkerRegistry.addMaterialStats(terra_thaumium,
				new HeadMaterialStats(2500, 8F, 6F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(1.5f, 250),
				new ExtraMaterialStats(250));

		TinkerRegistry.integrate(terra_thaumium, fluidTerra, "ThaumiumTerra").preInit();

		//Ordo
		TinkerRegistry.addMaterialStats(ordo_thaumium,
				new HeadMaterialStats(1000, 8F, 6F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(3f, 100),
				new ExtraMaterialStats(100));

		TinkerRegistry.integrate(ordo_thaumium, fluidOrdo,"ThaumiumOrdo").preInit();

		//Perditio
		TinkerRegistry.addMaterialStats(perditio_thaumium,
				new HeadMaterialStats(1000, 8F, 6F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(1.5f, 100),
				new ExtraMaterialStats(100));

		TinkerRegistry.integrate(perditio_thaumium, fluidPerditio, "ThaumiumPerditio").preInit();

		sendFluidForMelting("ThaumiumAer", fluidAer);
		sendFluidForMelting("ThaumiumIgnis", fluidIgnis);
		sendFluidForMelting("ThaumiumAqua", fluidAqua);
		sendFluidForMelting("ThaumiumTerra", fluidTerra);
		sendFluidForMelting("ThaumiumOrdo", fluidOrdo);
		sendFluidForMelting("ThaumiumPerditio", fluidPerditio);

	}

	@Override
	public void init() {
		aer_thaumium.setCastable(true).addItem("ingotThaumiumAer", 1, Material.VALUE_Ingot);
		aer_thaumium.addTrait(TinkerTraits.lightweight);

		ignis_thaumium.setCastable(true).addItem("ingotThaumiumIgnis", 1, Material.VALUE_Ingot);
		ignis_thaumium.addTrait(TinkerTraits.autosmelt).addTrait(TinkerTraits.superheat);

		aqua_thaumium.setCastable(true).addItem("ingotThaumiumAqua", 1, Material.VALUE_Ingot);
		aqua_thaumium.addTrait(TinkerTraits.aquadynamic);

		terra_thaumium.setCastable(true).addItem("ingotThaumiumTerra", 1, Material.VALUE_Ingot);
		terra_thaumium.addTrait(TinkerTraits.petramor).addTrait(TinkerTraits.duritos);

		ordo_thaumium.setCastable(true).addItem("ingotThaumiumOrdo", 1, Material.VALUE_Ingot);
		ordo_thaumium.addTrait(TinkerTraits.writable);

		perditio_thaumium.setCastable(true).addItem("ingotThaumiumPerditio", 1, Material.VALUE_Ingot);
		perditio_thaumium.addTrait(tr_entropic);

	}

	@Override
	public void postInit() {

	}

	public static class FluidColouredMetal extends Fluid {

		public static ResourceLocation ICON_MetalStill = new ResourceLocation("tconstruct:blocks/fluids/molten_metal");
		public static ResourceLocation ICON_MetalFlowing = new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow");

		int colour;

		public FluidColouredMetal(String name, int colour, int temp){
			super(name, ICON_MetalStill, ICON_MetalFlowing);
			this.colour = colour;
			this.setTemperature(temp);
			this.setDensity(2000);
			this.setViscosity(10000);
		}

		@Override
		public int getColor(){
			return colour|0xff000000;
		}
	}

	public static Fluid sendFluidForMelting(String ore, Fluid fluid){
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("fluid", fluid.getName());
		tag.setString("ore", ore);
		FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
		return fluid;
	}

}
