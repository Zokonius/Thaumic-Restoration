package com.Zoko061602.ThaumicRestoration.tile;

import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TR_Tiles {

	public static void initTiles(){
		GameRegistry.registerTileEntity(TileInfuser.class, new ResourceLocation(ThaumicRestoration.ModID, "tileInfuser"));
		GameRegistry.registerTileEntity(TileAdvRechargePedestal.class, new ResourceLocation(ThaumicRestoration.ModID, "tileAdvRechargePedestal"));
		GameRegistry.registerTileEntity(TileCrystal.class, new ResourceLocation(ThaumicRestoration.ModID,"tileCrystal"));
		GameRegistry.registerTileEntity(TileStorageUnit.class, new ResourceLocation(ThaumicRestoration.ModID, "tileStorageUnit"));

	}

}
