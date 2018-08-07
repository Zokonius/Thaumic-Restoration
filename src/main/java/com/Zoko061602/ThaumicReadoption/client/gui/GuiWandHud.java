package com.Zoko061602.ThaumicReadoption.client.gui;

import com.Zoko061602.ThaumicReadoption.items.ItemWand;
import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiWandHud extends Gui {

	private static final ResourceLocation texture = new ResourceLocation(ThaumicReadoption.ModID, "textures/gui/wand_bar.png");

    public GuiWandHud(Minecraft mc){
    	makeGui(mc);

    }

    private void makeGui(Minecraft mc) {

    	int xPos = 2;
		int yPos = 2;
		mc.getTextureManager().bindTexture(texture);

		GlStateManager.pushAttrib();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableLighting();
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		drawTexturedModalRect(xPos, yPos, 0, 0, 80, 8);

		int manabarwidth = (int)(ItemWand.getVis(mc.player.getHeldItemMainhand()) / ItemWand.getMaxVis(mc.player.getHeldItemMainhand()) * 80);
		drawTexturedModalRect(xPos, yPos, 0, 8, manabarwidth, 16);
		GlStateManager.popAttrib();

	}


}
