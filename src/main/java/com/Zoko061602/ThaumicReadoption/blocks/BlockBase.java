package com.Zoko061602.ThaumicReadoption.blocks;

import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

	public BlockBase(Material material, String tool, int tier, float hardness, float resistance, String name){
		super(material);
		this.setHarvestLevel(tool, tier);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(ReadoptedTab.tabReadopted);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
}
