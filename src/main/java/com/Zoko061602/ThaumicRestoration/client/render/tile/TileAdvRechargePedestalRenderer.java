package com.Zoko061602.ThaumicRestoration.client.render.tile;

import java.util.Random;

import com.Zoko061602.ThaumicRestoration.tile.TileAdvRechargePedestal;
import com.Zoko061602.ThaumicRestoration.util.BlockPosUtil;
import com.Zoko061602.ThaumicRestoration.util.IterUtil;

import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.client.fx.particles.FXBoreParticles;
import thaumcraft.client.renderers.tile.TileRechargePedestalRenderer;
import thaumcraft.common.tiles.devices.TileRechargePedestal;

@SideOnly(Side.CLIENT)
public class TileAdvRechargePedestalRenderer extends TileRechargePedestalRenderer {

    public void render(TileRechargePedestal p, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(p, x, y, z, partialTicks, destroyStage, alpha);
        if (p instanceof TileAdvRechargePedestal) {
            TileAdvRechargePedestal ped = (TileAdvRechargePedestal) p;
            BlockPosUtil.Vec3s pos = BlockPosUtil.translate(ped.getPos(), 0, 2, 0);
            Random rand = ped.getWorld().rand;

            if (ped.getMulti() != 2
            && ped.doParticles()
            && ped.isActive()) {
                for (int i = 0; i < 4; i++) {
                    drawParticles(ped, (float) pos.x + (2 * IterUtil.tick1(i)) + rand.nextFloat(),
                                       (float) pos.y                           + rand.nextFloat(),
                                       (float) pos.z + (2 * IterUtil.tick2(i)) + rand.nextFloat());
                }
            }
        }
    }

    private void drawParticles(TileAdvRechargePedestal ped,float x, float y, float z) {
        BlockPosUtil.Vec3s pos = BlockPosUtil.translate(ped.getPos(), 0.5D, -0.5D, 0.5D);
        FXBoreParticles fb = new FXBoreParticles(ped.getWorld(), x, y, z, pos.x, pos.y, pos.z, ped.getPedBlock().getDefaultState(), 0);
        fb.setAlphaF(0.3F);
        FMLClientHandler.instance().getClient().effectRenderer.addEffect(fb);
    }
}
