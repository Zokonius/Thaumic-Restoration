package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import static thaumcraft.api.golems.EnumGolemTrait.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.golems.EnumGolemTrait;
import thaumcraft.api.golems.parts.GolemMaterial;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.golems.GolemProperties;

public class TR_Golems {

    public static GolemMaterial materialTallow;
    public static GolemMaterial materialSilverwood;
    public static GolemMaterial materialAer;
    public static GolemMaterial materialIgnis;
    public static GolemMaterial materialAqua;
    public static GolemMaterial materialTerra;
    public static GolemMaterial materialOrdo;
    public static GolemMaterial materialPerditio;

    public static void addGolems() {
        // makes sure all TC Golems are initilized before adding new ones
        GolemProperties.fromLong(0L);
        materialTallow     = makeGolemMaterial("tallow"           , "MATSTUD_TALLOW"         , 0xDEA340, 20,  6, 2, new ItemStack(ItemsTC.tallow, 3)       , new ItemStack(ItemsTC.mechanismSimple) , LIGHT, CLUMSY);
        materialSilverwood = makeGolemMaterial("silverwood"       , "MATSTUD_SILVERWOOD"     , 0xE7DBC4, 20,  9, 1, new ItemStack(BlocksTC.plankSilverwood), new ItemStack(ItemsTC.mechanismComplex), LIGHT, DEFT);
        materialAer        = makeGolemMaterial("thaumium_aer"     , "MATSTUD_INFUSEDTHAUMIUM", 0xF3F45F, 30, 10, 5, new ItemStack(TR_Items.itemPlate, 1, 0), new ItemStack(TR_Items.itemPrimalModulator), LIGHT, BLASTPROOF, FIREPROOF, FLYER);
        materialIgnis      = makeGolemMaterial("thaumium_ignis"   , "MATSTUD_INFUSEDTHAUMIUM", 0xF45000, 30, 10, 5, new ItemStack(TR_Items.itemPlate, 1, 1), new ItemStack(TR_Items.itemPrimalModulator), HEAVY, BLASTPROOF, FIREPROOF, BRUTAL);
        materialAqua       = makeGolemMaterial("thaumium_aqua"    , "MATSTUD_INFUSEDTHAUMIUM", 0x31CAE0, 30, 10, 5, new ItemStack(TR_Items.itemPlate, 1, 2), new ItemStack(TR_Items.itemPrimalModulator), HEAVY, BLASTPROOF, FIREPROOF, REPAIR);
        materialTerra      = makeGolemMaterial("thaumium_terra"   , "MATSTUD_INFUSEDTHAUMIUM", 0x4BB600, 30, 10, 5, new ItemStack(TR_Items.itemPlate, 1, 3), new ItemStack(TR_Items.itemPrimalModulator), HEAVY, BLASTPROOF, FIREPROOF, ARMORED);
        materialOrdo       = makeGolemMaterial("thaumium_ordo"    , "MATSTUD_INFUSEDTHAUMIUM", 0xEBECFF, 30, 10, 5, new ItemStack(TR_Items.itemPlate, 1, 4), new ItemStack(TR_Items.itemPrimalModulator), HEAVY, BLASTPROOF, FIREPROOF, SCOUT);
        materialPerditio   = makeGolemMaterial("thaumium_perditio", "MATSTUD_INFUSEDTHAUMIUM", 0x5A5A5A, 30, 10, 5, new ItemStack(TR_Items.itemPlate, 1, 5), new ItemStack(TR_Items.itemPrimalModulator), HEAVY, BLASTPROOF, FIREPROOF, BREAKER);

        GolemMaterial.register(materialTallow);
        GolemMaterial.register(materialSilverwood);
        GolemMaterial.register(materialAer);
        GolemMaterial.register(materialIgnis);
        GolemMaterial.register(materialAqua);
        GolemMaterial.register(materialTerra);
        GolemMaterial.register(materialOrdo);
        GolemMaterial.register(materialPerditio);
    }

    private static GolemMaterial makeGolemMaterial(String name, String research, int color, int hp, int armor, int damage, ItemStack item, ItemStack core, EnumGolemTrait... traits){
        ResourceLocation tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_" + name + ".png");
        return new GolemMaterial("tr_" + name, new String[]{research}, tex, color, hp, armor, damage, item, core, traits);
    }

}
