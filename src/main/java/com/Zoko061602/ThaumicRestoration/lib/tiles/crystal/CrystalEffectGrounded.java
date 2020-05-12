package com.Zoko061602.ThaumicRestoration.lib.tiles.crystal;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalEffectGrounded extends CrystalEffect {

	public static ArrayList<TileCrystal> crystalTiles = new ArrayList<>();


	@Override
	public void performEffect(World world, BlockPos pos, TileCrystal tile) {
		if(!crystalTiles.contains(tile))
			crystalTiles.add(tile);
	}

	public static TileCrystal getCrystalNearby(BlockPos pos){
		for(TileCrystal c:crystalTiles) {
			if(c!=null)
				if(!c.gettingPower())
					if(c.getDistanceSq(pos.getX(), pos.getY(), pos.getZ())<=RANGE*RANGE)
						return c;
		}
		return null;
	}

}
