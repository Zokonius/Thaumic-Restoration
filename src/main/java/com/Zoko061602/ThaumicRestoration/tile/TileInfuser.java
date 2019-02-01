package com.Zoko061602.ThaumicRestoration.tile;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IEssentiaContainerItem;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.items.resources.ItemCrystalEssence;
import thaumcraft.common.tiles.TileThaumcraftInventory;
import thaumcraft.common.tiles.crafting.TilePedestal;

public class TileInfuser extends TileThaumcraftInventory {

    private int rotation=0;
    private int rounds=0;
	private Aspect a;
    private boolean active, rotate=false;
    private ArrayList<Aspect> aspects;
    private RecipeCrystalInfusion recipe;

	public TileInfuser() {
		super(1);
		this.syncedSlots = new int[] { 0 };
	}

	@Override
	public void update() {
		if(rotate){
			rotation+=((rounds+1)*7)/3;
			if(rotation>=360){
				rotation=0;
				rounds++;
				rotate=false;
		    }
		}

		if(active&&(!rotate)&&rounds>=1) {
			if(getPedestals().get(rounds-1).getStackInSlot(0).getItem() instanceof ItemCrystalEssence){
			 if(((IEssentiaContainerItem)getPedestals().get(rounds-1).getStackInSlot(0).getItem()).getAspects(getPedestals().get(rounds-1).getStackInSlot(0)).getAspects()[0]==recipe.getAspect()) {
			  getPedestals().get(rounds-1).decrStackSize(0, 1);
			  BlockPos pos = getPedestals().get(rounds-1).getPos();
			  FXDispatcher.INSTANCE.visSparkle(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY()+1, pos.getZ(), recipe.getAspect().getColor());
			 }
			 rotate=true;
             if(rounds==6){
              FXDispatcher.INSTANCE.drawBlockSparkles(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()), new Vec3d(pos.getX(), pos.getY()+1, pos.getZ()));
			  setInventorySlotContents(0, recipe.getOutput());
			  active=false;
			  rounds=0;
            }
            return;
		   }
		}
	}

	private ArrayList<TilePedestal> getPedestals(){
	 ArrayList<TilePedestal> peds = new ArrayList<TilePedestal>();
	 Iterable<BlockPos> i = BlockPos.getAllInBox(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-2), new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+2));
	 for(BlockPos p:i)
	  if(world.getTileEntity(p)!=null && world.getTileEntity(p) instanceof TilePedestal)
		peds.add((TilePedestal) world.getTileEntity(p));
	 return peds;
	}

	private Aspect checkItems(){
		aspects = new ArrayList<Aspect>();
		Aspect a;
		for(TilePedestal p:getPedestals()){
			if(p.getStackInSlot(0)!=null && p.getStackInSlot(0).getItem() instanceof ItemCrystalEssence) {
			 a = ((IEssentiaContainerItem) p.getStackInSlot(0).getItem()).getAspects(p.getStackInSlot(0)).getAspects()[0];
			 if(!aspects.contains(a))
				 aspects.add(a);
			}
			else return null;
		}
		if(aspects.size()==1) return aspects.get(0);
		else return null;
	}

	private boolean isRecipeValid(){
     for(RecipeCrystalInfusion r: RecipeCrystalInfusion.getRecipes()) {
    	 if(a==r.getAspect())
    	 if(getStackInSlot(0).getItem() == r.getInput().getItem()&&getStackInSlot(0).getItemDamage() == r.getInput().getItemDamage()){
    		 recipe = r;
    		 return true;
    	 }
     }
     return false;
	}

	public boolean activate(EntityPlayer p){
		if(!active)
		if(getPedestals().size()==6)
		if((a=checkItems())!=null)
		if(isRecipeValid())
		if(ThaumcraftCapabilities.knowsResearch(p, recipe.getResearch())){
			rotate = true;
			return active = true;
		}

		return false;
	}

	public boolean isActive(){
		return active;
	}

	public int getRotation() {
		return rotation;
	}

	@Override
	public int getInventoryStackLimit(){
	    return 1;
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack stack2){
	    return (stack2.isEmpty()) || (getStackInSlot(par1).isEmpty());
	}
}
