package com.Zoko061602.ThaumicRestoration.blocks;

import com.Zoko061602.ThaumicRestoration.main.TR_Tab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

	public BlockBase(Material material, String tool, int tier, float hardness, float resistance, String name){
		super(material);
		setHarvestLevel(tool, tier);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TR_Tab.tabRestoration);
		setHardness(hardness);
		setResistance(resistance);
	}

}
