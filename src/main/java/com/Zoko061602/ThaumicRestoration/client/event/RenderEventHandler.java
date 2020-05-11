package com.Zoko061602.ThaumicRestoration.client.event;

import com.Zoko061602.ThaumicRestoration.client.gui.GuiWandHud;
import com.Zoko061602.ThaumicRestoration.items.ItemWand;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber({Side.CLIENT})
public class RenderEventHandler {
    
    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post e){
        if (e.getType() != ElementType.EXPERIENCE)
            return;
        if (Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof ItemWand)
            new GuiWandHud(Minecraft.getMinecraft());
    }
    
}
