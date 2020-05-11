package com.Zoko061602.ThaumicRestoration.client.render;

import org.lwjgl.opengl.GL11;

import com.Zoko061602.ThaumicRestoration.tile.TileStorageUnit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileStorageUnitRenderer extends TileEntitySpecialRenderer<TileStorageUnit> {
    
    public void render(TileStorageUnit sto, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(sto, x, y, z, partialTicks, destroyStage, alpha);
        
        if (sto == null || sto.getSyncedStackInSlot(0).isEmpty())
            return;
        
        EntityItem entityitem = null;
        float ticks = Minecraft.getMinecraft().getRenderViewEntity().ticksExisted + partialTicks;
        
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
        GL11.glScaled(1.5D, 1.5D, 1.5D);
        GL11.glRotatef(ticks % 360.0F, 0.0F, 1.0F, 0.0F);
        
        ItemStack is = sto.getSyncedStackInSlot(0).copy();
        is.setCount(1);
        
        entityitem = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D, is);
        entityitem.hoverStart = 0.0F;
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.renderEntity(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
        
        GL11.glPopMatrix();
    }
    
}