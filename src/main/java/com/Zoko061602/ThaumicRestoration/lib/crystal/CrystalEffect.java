package com.Zoko061602.ThaumicRestoration.lib.crystal;

import com.Zoko061602.ThaumicRestoration.api.ICrystalEffect;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public abstract class CrystalEffect implements ICrystalEffect {

	public AxisAlignedBB getAABBRange(BlockPos pos) {
        return new AxisAlignedBB(pos.getX()-RANGE, pos.getY()-RANGE, pos.getZ()-RANGE, pos.getX()+RANGE, pos.getY()+RANGE, pos.getZ()+RANGE);
	}

}
