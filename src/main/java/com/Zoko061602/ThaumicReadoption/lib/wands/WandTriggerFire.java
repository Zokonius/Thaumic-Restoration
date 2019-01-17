package com.Zoko061602.ThaumicReadoption.lib.wands;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WandTriggerFire extends WandTrigger {

	public WandTriggerFire(String research) {
		super(research);
	}

	@Override
	public Placement getValidFace(World world, EntityPlayer player, BlockPos pos,
			EnumFacing face) {
		   if(face==EnumFacing.UP)
				if(player.getEntityWorld().provider.getDimension()==-1)
				 if(world.getBlockState(pos).getBlock()==Blocks.OBSIDIAN)
		return new Placement(0, 1, 0, EnumFacing.UP);
		return null;
	}

	@Override
	public void execute(World world, EntityPlayer player, BlockPos pos,
			Placement placement, EnumFacing face) {
			world.setBlockState(pos.up(), Blocks.FIRE.getDefaultState());

	}

	@Override
	public int getCost() {
		return 1;
	}

}
