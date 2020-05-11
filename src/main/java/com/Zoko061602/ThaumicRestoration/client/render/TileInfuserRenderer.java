package com.Zoko061602.ThaumicRestoration.client.render;

import org.lwjgl.opengl.GL11;

import com.Zoko061602.ThaumicRestoration.tile.TileInfuser;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.client.fx.FXDispatcher;

@SideOnly(Side.CLIENT)
public class TileInfuserRenderer extends TileEntitySpecialRenderer<TileInfuser>{
    
    public void render(TileInfuser ped, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
        super.render(ped, x, y, z, partialTicks, destroyStage, alpha);
        
        if (ped == null || ped.getSyncedStackInSlot(0).isEmpty())
            return;
        
        EntityItem entityitem = null;
        float ticks = Minecraft.getMinecraft().getRenderViewEntity().ticksExisted + partialTicks;
        
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
        GL11.glScaled(1.25D, 1.25D, 1.25D);
        GL11.glRotatef(ticks % 360.0F, 0.0F, 1.0F, 0.0F);
        
        ItemStack is = ped.getSyncedStackInSlot(0).copy();
        is.setCount(1);
        
        entityitem = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D, is);
        entityitem.hoverStart = 0.0F;
        
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.renderEntity(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
        
        GL11.glPopMatrix();
        
//      if (ped.isActive() && false) { // A && false is always false, commented
//          BlockPos pos = ped.getCurrentPed();
//          if(ped.getRounds() == 6)
//              FXDispatcher.INSTANCE.visSparkle((int)x, (int)y, (int)z, pos.getX(),pos.getY() + 1, pos.getZ(), ped.getRecipe().getAspect().getColor());
//          else if(ped.getRounds() < 6)
//              FXDispatcher.INSTANCE.drawBlockSparkles(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), new Vec3d(pos.getX(), pos.getY() + 1, pos.getZ()));
//      }
    }
    
}
