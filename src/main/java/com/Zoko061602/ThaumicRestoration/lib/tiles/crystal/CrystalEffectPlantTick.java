package com.Zoko061602.ThaumicRestoration.lib.tiles.crystal;

import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;
import com.Zoko061602.ThaumicRestoration.util.BlockPosUtil;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalEffectPlantTick extends CrystalEffect {

	private int amp;

	public CrystalEffectPlantTick(int amp) {
		this.amp = amp;
	}

	@Override
	public void performEffect(World world, BlockPos pos, TileCrystal tile) {
		for(int x=-RANGE; x!= RANGE;x++) {
			for(int z=-RANGE; z!= RANGE;z++) {
				BlockPos p = BlockPosUtil.translateToBlockPos(pos, x, 0, z);
				Block b = world.getBlockState(p).getBlock();
				if(b != null && world.rand.nextInt(6)<amp) {
					b.updateTick(world, p, world.getBlockState(p), world.rand);
				}
			}
		}

	}

}
