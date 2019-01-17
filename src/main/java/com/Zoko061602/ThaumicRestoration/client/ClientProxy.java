package com.Zoko061602.ThaumicRestoration.client;

import com.Zoko061602.ThaumicRestoration.blocks.BlockCrystal;
import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.client.event.RenderEventHandler;
import com.Zoko061602.ThaumicRestoration.client.render.TileAdvRechargePedestalRenderer;
import com.Zoko061602.ThaumicRestoration.client.render.TileInfuserRenderer;
import com.Zoko061602.ThaumicRestoration.items.block.ItemBlockCrystal;
import com.Zoko061602.ThaumicRestoration.main.CommonProxy;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;
import com.Zoko061602.ThaumicRestoration.tile.TileAdvRechargePedestal;
import com.Zoko061602.ThaumicRestoration.tile.TileInfuser;

import net.minecraft.client.Minecraft;
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
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new BlockCrystal(), TR_Blocks.blockCrystal);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemBlockCrystal(TR_Blocks.blockCrystal), TR_Blocks.blockCrystal);
		ClientRegistry.bindTileEntitySpecialRenderer(TileInfuser.class, new TileInfuserRenderer());

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		MinecraftForge.EVENT_BUS.register(new RenderEventHandler());

	}

}
