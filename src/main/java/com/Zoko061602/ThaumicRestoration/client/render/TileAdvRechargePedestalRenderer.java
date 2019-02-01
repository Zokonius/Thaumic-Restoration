package com.Zoko061602.ThaumicRestoration.client.render;

import com.Zoko061602.ThaumicRestoration.tile.TileAdvRechargePedestal;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.client.fx.particles.FXBoreParticles;
import thaumcraft.client.renderers.tile.TileRechargePedestalRenderer;
import thaumcraft.common.tiles.devices.TileRechargePedestal;

@SideOnly(Side.CLIENT)
public class TileAdvRechargePedestalRenderer extends TileRechargePedestalRenderer {

	  public void render(TileRechargePedestal p, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		super.render(p, x, y, z, partialTicks, destroyStage, alpha);
	   if(p instanceof TileAdvRechargePedestal) {
	   TileAdvRechargePedestal ped = (TileAdvRechargePedestal) p;
	   if(true) {
        BlockPos pos = ped.getPos();
        if(ped.getMulti()!=2 && ped.doParticles() && ped.isActive()) {
        	drawParticles(ped, pos.getX()+2+ped.getWorld().rand.nextFloat(), pos.getY()+2+ped.getWorld().rand.nextFloat(), pos.getZ()+2+ped.getWorld().rand.nextFloat());
        	drawParticles(ped, pos.getX()+2+ped.getWorld().rand.nextFloat(), pos.getY()+2+ped.getWorld().rand.nextFloat(), pos.getZ()-2+ped.getWorld().rand.nextFloat());
        	drawParticles(ped, pos.getX()-2+ped.getWorld().rand.nextFloat(), pos.getY()+2+ped.getWorld().rand.nextFloat(), pos.getZ()+2+ped.getWorld().rand.nextFloat());
        	drawParticles(ped, pos.getX()-2+ped.getWorld().rand.nextFloat(), pos.getY()+2+ped.getWorld().rand.nextFloat(), pos.getZ()-2+ped.getWorld().rand.nextFloat());
         }
        }
	  }
	 }

		private void drawParticles(TileAdvRechargePedestal ped,float x, float y, float z){
		    FXBoreParticles fb = new FXBoreParticles(ped.getWorld(),x,y,z, ped.getPos().getX() + 0.5D, ped.getPos().getY() - 0.5D, ped.getPos().getZ()+ 0.5D,ped.getPedBlock().getDefaultState(), 0);
		    fb.setAlphaF(0.3F);
		    FMLClientHandler.instance().getClient().effectRenderer.addEffect(fb);
		}
}
