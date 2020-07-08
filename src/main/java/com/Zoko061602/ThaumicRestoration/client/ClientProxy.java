package com.Zoko061602.ThaumicRestoration.client;

import com.Zoko061602.ThaumicRestoration.client.handlers.ColorHandler;
import com.Zoko061602.ThaumicRestoration.client.render.tile.TileAdvRechargePedestalRenderer;
import com.Zoko061602.ThaumicRestoration.client.render.tile.TileInfuserRenderer;
import com.Zoko061602.ThaumicRestoration.client.render.tile.TileStorageUnitRenderer;
import com.Zoko061602.ThaumicRestoration.main.CommonProxy;
import com.Zoko061602.ThaumicRestoration.tile.TileAdvRechargePedestal;
import com.Zoko061602.ThaumicRestoration.tile.TileInfuser;
import com.Zoko061602.ThaumicRestoration.tile.TileStorageUnit;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ColorHandler.init();

        ClientRegistry.bindTileEntitySpecialRenderer(TileInfuser            .class, new TileInfuserRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileAdvRechargePedestal.class, new TileAdvRechargePedestalRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileStorageUnit        .class, new TileStorageUnitRenderer());


    }

}
