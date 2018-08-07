package com.Zoko061602.ThaumicReadoption.blocks;

import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockReinforced extends Block {

	public BlockReinforced(){
		super(Material.ROCK);
		this.setUnlocalizedName("block_reinforced");
		this.setRegistryName("block_reinforced");
		this.setCreativeTab(ReadoptedTab.tabReadopted);
		this.setResistance(50F);
		this.setHardness(10F);

	}

}
