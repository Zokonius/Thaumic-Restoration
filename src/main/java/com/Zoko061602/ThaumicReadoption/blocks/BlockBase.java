package com.Zoko061602.ThaumicReadoption.blocks;

import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

	public BlockBase(Material material, String tool, int tier, float hardness, float resistance, String name){
		super(material);
		setHarvestLevel(tool, tier);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ReadoptedTab.tabReadopted);
		setHardness(hardness);
		setResistance(resistance);
	}

}
