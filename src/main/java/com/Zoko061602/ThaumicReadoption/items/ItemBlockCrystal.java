package com.Zoko061602.ThaumicReadoption.items;

import java.util.List;

import javax.annotation.Nonnull;

import com.Zoko061602.ThaumicReadoption.blocks.ReadoptedBlocks;
import com.Zoko061602.ThaumicReadoption.lib.ItemNBTHelper;
import com.Zoko061602.ThaumicReadoption.tile.TileCrystal;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;

public class ItemBlockCrystal extends ItemBlock implements IItemColor {

	public ItemBlockCrystal(Block b) {
		super(b);
		setHasSubtypes(true);
	}

	@Override
	public boolean placeBlockAt( ItemStack stack,  EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, @Nonnull IBlockState newState) {
		boolean placed = super.placeBlockAt(stack, player, world, pos, side, hitX, hitY, hitZ, newState);
		if(placed) {
			Aspect a = getType(stack);
			TileEntity tile = world.getTileEntity(pos);
			if(tile instanceof TileCrystal) {
				((TileCrystal) tile).setAspect(a);
				if(!world.isRemote)
					world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 8);
			}
		}

		return placed;
	}


	public static ItemStack ofType(Aspect a) {
	 return ofType(new ItemStack(ReadoptedBlocks.blockCrystal), a);
	}

	public static ItemStack ofType(ItemStack stack, Aspect a) {
	 ItemNBTHelper.setString(stack, "aspect", a.getTag());
	 return stack;
	}

	public static Aspect getType(ItemStack stack) {
	 return Aspect.getAspect(ItemNBTHelper.getString(stack, "aspect", "aer"));
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
	 return super.getUnlocalizedName(stack);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(Aspect.getAspect(ItemNBTHelper.getString(stack, "aspect", "aer")).getName());
	}

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		if(tintIndex == 1) {
			String s = ItemNBTHelper.getString(stack, "aspect", "aer");
			Aspect a = Aspect.getAspect(s);
			if(a != null)
			 return a.getColor();
		}
		return Aspect.AIR.getColor();
	}

}
