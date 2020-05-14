package com.Zoko061602.ThaumicRestoration.client.render;

import com.Zoko061602.ThaumicRestoration.client.model.ModelInfuser;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;
import com.Zoko061602.ThaumicRestoration.tile.TileInfuser;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileInfuserRenderer extends TileEntitySpecialRenderer<TileInfuser> {

    public static final ModelInfuser modelInfuser = new ModelInfuser();;

	@Override
    public void render(TileInfuser ped, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
        super.render(ped, x, y, z, partialTicks, destroyStage, alpha);

        bindTexture(new ResourceLocation(ThaumicRestoration.ModID,"textures/models/block_infuser.png"));

		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);

		renderBlock(ped, x, y, z, partialTicks, destroyStage, alpha);
		renderItem(ped, x, y, z, partialTicks, destroyStage, alpha);

		GlStateManager.popMatrix();
    }

    public static void renderBlock(TileInfuser ped, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
    	GlStateManager.pushMatrix();
    	GlStateManager.translate(0.5F, 0, 0.5F);
		GlStateManager.rotate(ped.getAngle()%360F, 0F, 1F, 0F);
		modelInfuser.render();
		GlStateManager.popMatrix();

    }

    public static void renderItem(TileInfuser ped, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

        if (ped == null || ped.getSyncedStackInSlot(0).isEmpty())
            return;

    	EntityItem entityitem = null;
        float ticks = Minecraft.getMinecraft().getRenderViewEntity().ticksExisted + partialTicks;

		GlStateManager.pushMatrix();
		GlStateManager.translate(0.5F, 0.75F, 0.5F);
		GlStateManager.scale(1.25D, 1.25D, 1.25D);
        GlStateManager.rotate(ticks % 360.0F, 0.0F, 1.0F, 0.0F);

        ItemStack is = ped.getSyncedStackInSlot(0).copy();
        is.setCount(1);

        entityitem = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D, is);
        entityitem.hoverStart = 0.0F;

        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.renderEntity(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);

        GlStateManager.popMatrix();
    }

}
