package com.Zoko061602.ThaumicReadoption.client.render;

import org.lwjgl.opengl.GL11;

import com.Zoko061602.ThaumicReadoption.tile.TileInfuser;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileInfuserRenderer extends TileEntitySpecialRenderer<TileInfuser>{

	  public void render(TileInfuser ped, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
	    super.render(ped, x, y, z, partialTicks, destroyStage, alpha);
        renderItem(ped, x, y, z, partialTicks, destroyStage, alpha);
        renderAnimation(ped, x, y, z, partialTicks, destroyStage, alpha);
	  }

	  private void renderItem(TileInfuser ped, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		    if ((ped != null) && (!ped.getStackInSlot(0).isEmpty())) {
			      EntityItem entityitem = null;
			      float ticks = Minecraft.getMinecraft().getRenderViewEntity().ticksExisted + partialTicks;
			      GL11.glPushMatrix();
			      GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
			      GL11.glScaled(1.25D, 1.25D, 1.25D);
			      GL11.glRotatef(ticks % 360.0F, 0.0F, 1.0F, 0.0F);
			      ItemStack is = ped.getStackInSlot(0).copy();
			      is.setCount(1);
			      entityitem = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D, is);
			      entityitem.hoverStart = 0.0F;
			      RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
			      rendermanager.renderEntity(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
			      GL11.glPopMatrix();
			    }
	  }


	  private void renderAnimation(TileInfuser ped, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
	      float ticks = Minecraft.getMinecraft().getRenderViewEntity().ticksExisted + partialTicks;
	        GL11.glPushMatrix();
	        GL11.glTranslated(x+0.5, y, z+0.5);
	        GL11.glPushMatrix();
	        GL11.glRotatef(ped.getRotation()+(ticks/2F), 0F, 1F, 0F);
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();

	  }
}
