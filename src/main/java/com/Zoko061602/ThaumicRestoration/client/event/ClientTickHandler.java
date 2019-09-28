package com.Zoko061602.ThaumicRestoration.client.event;

import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value=Side.CLIENT, modid=ThaumicRestoration.ModID)
public class ClientTickHandler {

	public static int ticksInGame = 0;

	@SubscribeEvent
	public static void clientTickEnd(ClientTickEvent event) {
		GuiScreen gui = Minecraft.getMinecraft().currentScreen;
		if(gui == null || !gui.doesGuiPauseGame()) {
			ticksInGame++;
	    }
	}

}
