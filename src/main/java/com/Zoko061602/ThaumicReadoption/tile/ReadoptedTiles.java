package com.Zoko061602.ThaumicReadoption.tile;

import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ReadoptedTiles {

	public static void initTiles(){
		GameRegistry.registerTileEntity(TileInfuser.class, new ResourceLocation(ThaumicReadoption.ModID, "tileInfuser"));
	}

}
