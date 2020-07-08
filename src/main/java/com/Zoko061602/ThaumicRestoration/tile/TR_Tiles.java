package com.Zoko061602.ThaumicRestoration.tile;

import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TR_Tiles {

    public static void initTiles(){
        GameRegistry.registerTileEntity(TileInfuser            .class, new ResourceLocation(ThaumicRestoration.modID, "tileInfuser"));
        GameRegistry.registerTileEntity(TileAdvRechargePedestal.class, new ResourceLocation(ThaumicRestoration.modID, "tileAdvRechargePedestal"));
        GameRegistry.registerTileEntity(TileCrystal            .class, new ResourceLocation(ThaumicRestoration.modID, "tileCrystal"));
        GameRegistry.registerTileEntity(TileMagicWall          .class, new ResourceLocation(ThaumicRestoration.modID, "tileMagicWall"));
        GameRegistry.registerTileEntity(TileStorageUnit        .class, new ResourceLocation(ThaumicRestoration.modID, "tileStorageUnit"));
    }

}
