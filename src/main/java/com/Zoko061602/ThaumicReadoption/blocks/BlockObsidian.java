package com.Zoko061602.ThaumicReadoption.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockObsidian extends BlockBase {

	public BlockObsidian() {
		super(Material.ROCK, "pickaxe", 3, 50F, 1200F, "block_obsidian");
	}

	  @Override
	  public boolean canEntityDestroy(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull Entity entity) {
	    return !(entity instanceof EntityWither) && !(entity instanceof EntityWitherSkull);
	  }

	  @Override
	  public void onBlockExploded(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull Explosion explosion) {
	  }

	  @Override
	  public boolean canDropFromExplosion(@Nonnull Explosion p_149659_1_) {
	    return false;
	  }

}
