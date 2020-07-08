package com.Zoko061602.ThaumicRestoration.tile;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;
import com.Zoko061602.ThaumicRestoration.util.BlockPosUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.api.casters.ICaster;
import thaumcraft.api.casters.IInteractWithCaster;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.items.resources.ItemCrystalEssence;
import thaumcraft.common.tiles.TileThaumcraftInventory;
import thaumcraft.common.tiles.crafting.TilePedestal;

public class TileInfuser extends TileThaumcraftInventory implements IInteractWithCaster {

    private float angle = 0;
    private int rounds = 0;
    private boolean active = false;
    private RecipeCrystalInfusion recipe;

    public TileInfuser() {
        super(1);
        this.syncedSlots = new int[] { 0 };
    }


    @Override
    public void update() {
        if (active) {

            if (Math.floor(angle/360) > rounds) {

                if (!isStructureValid() && getSyncedStackInSlot(0) == ItemStack.EMPTY) {
                	reset();
                	return;
                }

                if (rounds < 6 && (getCurrentPedestal().getStackInSlot(0).getItem() instanceof ItemCrystalEssence)
                && (AspectHelper.getObjectAspects(getCurrentPedestal().getStackInSlot(0)).getAspects()[0] == recipe.getAspect())) {
                    getPedestals().get(rounds).decrStackSize(0, 1);
                    drawSparkles(BlockPosUtil.translateToBlockPos(getCurrentPedestal().getPos(), 0, 1, 0), recipe.getColor());
                    drawSparkles(BlockPosUtil.translateToBlockPos(pos, 0, 1, 0), recipe.getColor());
                }

                if (rounds == 6) {
                    setInventorySlotContents(0, recipe.getOutput());
                    drawSparkles(BlockPosUtil.translateToBlockPos(pos, 0, 1, 0), recipe.getColor());
                    reset();
                    return;
                }

                rounds++;
            }

            angle += ((rounds+1)* 7) / 3;
            syncProgress();
        }
    }

    private ArrayList<TilePedestal> getPedestals() {
        ArrayList<TilePedestal> peds = new ArrayList<TilePedestal>();
        Iterable<BlockPos> i = BlockPos.getAllInBox(new BlockPos(pos.getX() - 2, pos.getY(), pos.getZ() - 2), new BlockPos(pos.getX() + 2, pos.getY(), pos.getZ() + 2));
        for (BlockPos p : i)
            if (world.getTileEntity(p) != null && world.getTileEntity(p) instanceof TilePedestal)
                peds.add((TilePedestal) world.getTileEntity(p));
        return peds;
    }

    private Aspect checkItems() {
        ArrayList<Aspect> aspects = new ArrayList<Aspect>();
        Aspect a;
        for (TilePedestal p:getPedestals())
            if (!(p.getStackInSlot(0).isEmpty())
            && p.getStackInSlot(0).getItem() instanceof ItemCrystalEssence) {
                a = AspectHelper.getObjectAspects(p.getStackInSlot(0)).getAspects()[0];
                if (!aspects.contains(a))
                    aspects.add(a);
            }
            else return null;

        if (aspects.size() == 1)
            return aspects.get(0);
        else return null;
    }

    private boolean isRecipeValid() {
        Aspect a = checkItems();
        for(RecipeCrystalInfusion r : RecipeCrystalInfusion.getRecipes())
            if ((a != null && a == r.getAspect())
            && (getStackInSlot(0).getItem() == r.getInput().getItem() && getStackInSlot(0).getItemDamage() == r.getInput().getItemDamage())) {
                recipe = r;
                return true;
            }
        return false;
    }

    public boolean activate(EntityPlayer p){
        if ((!active)
        && isStructureValid()
        && isRecipeValid()
        && ThaumcraftCapabilities.knowsResearch(p, recipe.getResearch())) {
            return active = true;
        }
        return false;
    }

    public void reset() {
        active = false;
        angle = 0;
        rounds = 0;
        syncProgress();
    }

    public void syncProgress() {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setFloat("angle", angle);
    	nbt.setInteger("rounds", rounds);
    	sendMessageToClient(nbt, null);
    }

    public void syncSparkles(BlockPos p, int color) {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setLong("pos", p.toLong());
    	nbt.setInteger("color", color);
    	sendMessageToClient(nbt, null);
    }

    @Override
    public void messageFromServer(NBTTagCompound nbt) {
    	super.messageFromServer(nbt);
    	if(nbt.hasKey("angle"))
    		angle = nbt.getFloat("angle");
    	if(nbt.hasKey("rounds"))
    		rounds = nbt.getInteger("rounds");

    	if(nbt.hasKey("pos") && nbt.hasKey("color")) {
    		drawSparkles(BlockPos.fromLong(nbt.getLong("pos")), nbt.getInteger("color"));
    	}

    }

    @Override
    public NBTTagCompound writeSyncNBT(NBTTagCompound nbt) {
    	return super.writeSyncNBT(nbt);
    }

    @Override
    public void readSyncNBT(NBTTagCompound nbt) {
    	super.readSyncNBT(nbt);
    }

    public boolean isStructureValid() {
    	return getPedestals().size() == 6;
    }

    public boolean isActive() {
        return active;
    }

    public float getAngle() {
        return angle;
    }

    public int getRounds() {
        return rounds;
    }

    public TileThaumcraftInventory getCurrentPedestal() {
        return rounds < 6 ? getPedestals().get(rounds):this;
    }

    public RecipeCrystalInfusion getRecipe() {
        return recipe;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isItemValidForSlot(int par1, ItemStack stack2) {
        return (stack2.isEmpty()) || (getSyncedStackInSlot(par1).isEmpty());
    }

    public void drawSparkles(BlockPos pos, int color) {
    	if(world.isRemote)
    		FXDispatcher.INSTANCE.visSparkle(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY()+1, pos.getZ(), color);
    	else
    		syncSparkles(pos, color);
    }


	@Override
	public boolean onCasterRightClick(World world, ItemStack stack, EntityPlayer player, BlockPos pos, EnumFacing face, EnumHand hand) {
		if(stack!= null && !stack.isEmpty() && stack.getItem() instanceof ICaster && ! isActive()) {
			ICaster caster = (ICaster) stack.getItem();
			if(caster.consumeVis(stack, player, 50F, true, true) && activate(player)) {
				caster.consumeVis(stack, player, 50F, false, false);
				return true;
			}
		}
		return false;
	}
}
