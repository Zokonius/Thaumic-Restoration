package com.Zoko061602.ThaumicReadoption.tile;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.IRechargable;
import thaumcraft.api.items.RechargeHelper;
import thaumcraft.common.tiles.devices.TileRechargePedestal;

public class TileAdvRechargePedestal extends TileRechargePedestal {

	private int counter = 0;
	private int multi = 2;
	private boolean active;
	Block[] metals = new Block[] {
			BlocksTC.metalBlockBrass,
			BlocksTC.metalBlockThaumium,
			BlocksTC.metalBlockVoid
			};

	public Block getPedBlock(){
		return world.getBlockState(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()+2)).getBlock();
	}

	@Override
	public void update() {
		if(checkStructure()){
		 Block b = getPedBlock();
		 if(b==metals[0])multi=3;
		 else if(b==metals[1])multi=4;
		 else if(b==metals[2])multi=5;
		}

		else multi=2;

	    if(!getWorld().isRemote){
		 if(counter++ % 10 == 0)
		  if(getStackInSlot(0) != null)
		   if(RechargeHelper.rechargeItem(getWorld(), getStackInSlot(0), this.pos, null, 5) > 0.0F)
			if(multi==2)
		    if(RechargeHelper.rechargeItemBlindly(getStackInSlot(0), null, 5*(multi-1)) > 0.0F){
		      active= RechargeHelper.getCharge(getStackInSlot(0))!=((IRechargable)getStackInSlot(0).getItem()).getMaxCharge(getStackInSlot(0), null);
		      syncTile(false);
		      markDirty();
		      ArrayList<Aspect> al = Aspect.getPrimalAspects();
		      world.addBlockEvent(this.pos, getBlockType(), 5*multi, ((Aspect)al.get(getWorld().rand.nextInt(al.size()))).getColor());
		    }
	    }
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public int getInventoryStackLimit(){
	    return 1;
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack stack2){
	    return (stack2.isEmpty()) || (getStackInSlot(par1).isEmpty());
	}

	public int getMulti() {
		return multi;
	}

	public void setMulti(int multi) {
		this.multi = multi;
	}

	private boolean checkStructure() {

		for(int i=0;!(i==2);i++){
		if(world.getBlockState(new BlockPos(pos.getX()+2, pos.getY()+i, pos.getZ()+2)).getBlock()!=Blocks.QUARTZ_BLOCK)
          return false;
		if(world.getBlockState(new BlockPos(pos.getX()+2, pos.getY()+i, pos.getZ()-2)).getBlock()!=Blocks.QUARTZ_BLOCK)
	          return false;
		if(world.getBlockState(new BlockPos(pos.getX()-2, pos.getY()+i, pos.getZ()+2)).getBlock()!=Blocks.QUARTZ_BLOCK)
	          return false;
		if(world.getBlockState(new BlockPos(pos.getX()-2, pos.getY()+i, pos.getZ()-2)).getBlock()!=Blocks.QUARTZ_BLOCK)
	          return false;
		}

		ArrayList<Block> l = new ArrayList<Block>();
		 if(!l.contains(world.getBlockState(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()+2)).getBlock()))
		 l.add(world.getBlockState(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()+2)).getBlock());

		 if(!l.contains(world.getBlockState(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()-2)).getBlock()))
		 l.add(world.getBlockState(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()-2)).getBlock());

		 if(!l.contains(world.getBlockState(new BlockPos(pos.getX()-2, pos.getY()+2, pos.getZ()+2)).getBlock()))
		 l.add(world.getBlockState(new BlockPos(pos.getX()-2, pos.getY()+2, pos.getZ()+2)).getBlock());

		 if(!l.contains(world.getBlockState(new BlockPos(pos.getX()-2, pos.getY()+2, pos.getZ()-2)).getBlock()))
		 l.add(world.getBlockState(new BlockPos(pos.getX()-2, pos.getY()+2, pos.getZ()-2)).getBlock());

		 if(l.size()!=1)return false;

		 for(Block b:metals) {
          if(l.get(0)==b)break;
          if(b==BlocksTC.metalBlockVoid)return false;
         }
		 return true;
	}
}
