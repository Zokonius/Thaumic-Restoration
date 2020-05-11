package com.Zoko061602.ThaumicRestoration.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockBaseFluid extends BlockFluidClassic {
    
    public BlockBaseFluid(String name, Fluid fluid, Material material) {
        super(fluid, material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
    
}
