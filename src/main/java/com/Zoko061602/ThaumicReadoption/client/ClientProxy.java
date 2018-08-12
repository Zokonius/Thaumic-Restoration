package com.Zoko061602.ThaumicReadoption.client;

import com.Zoko061602.ThaumicReadoption.client.event.RenderEventHandler;
import com.Zoko061602.ThaumicReadoption.client.render.TileAdvRechargePedestalRenderer;
import com.Zoko061602.ThaumicReadoption.client.render.TileInfuserRenderer;
import com.Zoko061602.ThaumicReadoption.main.CommonProxy;
import com.Zoko061602.ThaumicReadoption.tile.TileAdvRechargePedestal;
import com.Zoko061602.ThaumicReadoption.tile.TileInfuser;

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
		ClientRegistry.bindTileEntitySpecialRenderer(TileInfuser.class, new TileInfuserRenderer());

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		MinecraftForge.EVENT_BUS.register(new RenderEventHandler());

	}

}
