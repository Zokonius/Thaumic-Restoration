package com.Zoko061602.ThaumicRestoration.api;

import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ICrystalEffect {

    public abstract void performEffect(World world, BlockPos pos, TileCrystal tile);

}
