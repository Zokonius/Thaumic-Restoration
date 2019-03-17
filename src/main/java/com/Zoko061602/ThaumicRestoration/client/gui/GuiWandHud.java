package com.Zoko061602.ThaumicRestoration.client.gui;

import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.items.RechargeHelper;

public class GuiWandHud extends Gui {

	private static final ResourceLocation texture = new ResourceLocation(ThaumicRestoration.ModID, "textures/gui/wand_bar.png");

    public GuiWandHud(Minecraft mc){
		mc.getTextureManager().bindTexture(texture);

		GlStateManager.pushAttrib();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableLighting();
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		int visbarwidth = (int)(RechargeHelper.getChargePercentage(mc.player.getHeldItemMainhand(), mc.player) * 80);
		drawTexturedModalRect(2, 2, 0, 0, 80, 8);
		drawTexturedModalRect(2, 2, 0, 8, visbarwidth, 16);
		GlStateManager.popAttrib();

    }


}
