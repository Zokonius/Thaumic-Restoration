package com.Zoko061602.ThaumicRestoration.client.handlers;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.lib.ItemNBTHelper;
import com.Zoko061602.ThaumicRestoration.tile.TileCrystal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import thaumcraft.api.aspects.Aspect;

public class ColorHandler {

	public static void init() {
		BlockColors blocks = Minecraft.getMinecraft().getBlockColors();
		ItemColors items = Minecraft.getMinecraft().getItemColors();

		blocks.registerBlockColorHandler(
				(state, world, pos, tintIndex) -> {
					if(world.getTileEntity(pos) instanceof TileCrystal) {
						TileCrystal tile = (TileCrystal) world.getTileEntity(pos);
						Aspect a = tile.getAspect();
						if(a==null)a = Aspect.AIR;
						if(tintIndex==1)
						return a.getColor();
						}
						return 0x55dd55;
				},
				TR_Blocks.blockCrystal
				);

		items.registerItemColorHandler(
				(stack, t) ->{
					if(t == 1) {
						String s = ItemNBTHelper.getString(stack, "aspect", "aer");
						Aspect a = Aspect.getAspect(s);
						if(a != null)
						 return a.getColor();
					}
					return Aspect.AIR.getColor();
				},
				TR_Blocks.blockCrystal
				);

	};
	}

