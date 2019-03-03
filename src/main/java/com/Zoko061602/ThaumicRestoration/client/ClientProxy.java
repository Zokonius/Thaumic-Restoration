package com.Zoko061602.ThaumicRestoration.client;

import com.Zoko061602.ThaumicRestoration.client.event.RenderEventHandler;
import com.Zoko061602.ThaumicRestoration.client.handlers.ColorHandler;
import com.Zoko061602.ThaumicRestoration.client.render.TileAdvRechargePedestalRenderer;
import com.Zoko061602.ThaumicRestoration.client.render.TileInfuserRenderer;
import com.Zoko061602.ThaumicRestoration.client.render.TileStorageUnitRenderer;
import com.Zoko061602.ThaumicRestoration.main.CommonProxy;
import com.Zoko061602.ThaumicRestoration.tile.TileAdvRechargePedestal;
import com.Zoko061602.ThaumicRestoration.tile.TileInfuser;
import com.Zoko061602.ThaumicRestoration.tile.TileStorageUnit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
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

		ClientRegistry.bindTileEntitySpecialRenderer(TileInfuser.class, new TileInfuserRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileAdvRechargePedestal.class, new TileAdvRechargePedestalRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileStorageUnit.class, new TileStorageUnitRenderer());

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		MinecraftForge.EVENT_BUS.register(new RenderEventHandler());

	}

}
