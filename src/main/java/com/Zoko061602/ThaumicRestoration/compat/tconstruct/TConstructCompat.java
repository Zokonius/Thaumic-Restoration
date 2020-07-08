package com.Zoko061602.ThaumicRestoration.compat.tconstruct;

import com.Zoko061602.ThaumicRestoration.blocks.BlockBaseFluid;
import com.Zoko061602.ThaumicRestoration.compat.RestoredCompat.IRestoredCompatModule;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.lib.FluidHelper;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class TConstructCompat implements IRestoredCompatModule {

    public static final TConMats aer      = new TConMats("aer"     , 0xEDEF59, "ThaumiumAer");
    public static final TConMats ignis    = new TConMats("ignis"   , 0xEE4B00, "ThaumiumIgnis");
    public static final TConMats aqua     = new TConMats("aqua"    , 0x2DC5D9, "ThaumiumAqua");
    public static final TConMats terra    = new TConMats("terra"   , 0x4CB602, "ThaumiumTerra");
    public static final TConMats ordo     = new TConMats("ordo"    , 0xE4E6FD, "ThaumiumOrdo");
    public static final TConMats perditio = new TConMats("perditio", 0x585858, "ThaumiumPerditio");

    public static AbstractTrait tr_entropic = new TraitEntropic(0x585858);

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        FMLInterModComms.sendMessage("tconstruct", "blacklistMelting", new ItemStack(TR_Items.itemTRBucket, 1, 0));

        registerMats(aer,
                1000, 16F, 6F, HarvestLevels.OBSIDIAN,
                1.5F, 100, 100);

        registerMats(ignis,
                1000, 8F, 9F, HarvestLevels.OBSIDIAN,
                1.5F, 100, 100);

        registerMats(aqua,
                1000, 8F, 6F, HarvestLevels.OBSIDIAN,
                1.5F, 100, 100);

        registerMats(terra,
                2500, 8F, 6F, HarvestLevels.OBSIDIAN,
                1.5F, 250, 250);

        registerMats(ordo,
                1000, 8F, 6F, HarvestLevels.OBSIDIAN,
                3F, 100, 100);

        registerMats(perditio,
                1000, 12F, 6F, HarvestLevels.COBALT,
                1.5F, 100, 100);

    }

    private void registerMats(TConMats metal, int headDurability, float headMiningspeed, float headAttack, int headHarvest, float handleModifier, int handleDurability, int extraDurability) {
        TinkerRegistry.addMaterialStats(metal.mat,
                new HeadMaterialStats(headDurability, headMiningspeed, headAttack, headHarvest),
                new HandleMaterialStats(handleModifier, handleDurability),
                new ExtraMaterialStats(extraDurability));
        TinkerRegistry.integrate(metal.mat, metal.fluid, metal.oreDict).preInit();
        sendFluidForMelting(metal.oreDict, metal.fluid);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        addTraitToMats(aer     , TinkerTraits.lightweight);
        addTraitToMats(ignis   , TinkerTraits.autosmelt  , TinkerTraits.superheat);
        addTraitToMats(aqua    , TinkerTraits.aquadynamic);
        addTraitToMats(terra   , TinkerTraits.petramor   , TinkerTraits.duritos);
        addTraitToMats(ordo    , TinkerTraits.writable);
        addTraitToMats(perditio, tr_entropic);
    }

    private void addTraitToMats(TConMats metal, AbstractTrait... traits) {
        metal.mat.setCastable(true).addItem("ingot" + metal.oreDict, 1, Material.VALUE_Ingot);
        for (AbstractTrait trait : traits) metal.mat.addTrait(trait);
    }

    public static class FluidColouredMetal extends Fluid {

        public static ResourceLocation ICON_MetalStill = new ResourceLocation("tconstruct:blocks/fluids/molten_metal");
        public static ResourceLocation ICON_MetalFlowing = new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow");

        int color;

        public FluidColouredMetal(String name, int color, int temp) {
            super(name, ICON_MetalStill, ICON_MetalFlowing);
            this.color = color;
            this.setTemperature(temp);
            this.setDensity(2000);
            this.setViscosity(10000);
        }

        @Override
        public int getColor(){
            return color | 0xff000000;
        }
    }

    public static Fluid sendFluidForMelting(String ore, Fluid fluid){
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", fluid.getName());
        tag.setString("ore", ore);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
        return fluid;
    }

    private static class TConMats {
        public final Material mat;
        public final Fluid fluid;
        public final Block blockFluid;
        public final String oreDict;

        public TConMats(String aspect, int color, String oreDict) {
            this.mat = new Material(aspect + "_thaumium", color);
            this.fluid = FluidHelper.setupFluid(new FluidColouredMetal("fluid_molten_" + aspect, color, 1000));
            this.blockFluid = new BlockBaseFluid("block_molten_" + aspect, fluid, net.minecraft.block.material.Material.LAVA);
            this.oreDict = oreDict;
        }
    }

}
