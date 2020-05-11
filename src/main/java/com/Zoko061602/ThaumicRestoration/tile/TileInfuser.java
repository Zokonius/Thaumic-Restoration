package com.Zoko061602.ThaumicRestoration.tile;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.common.items.resources.ItemCrystalEssence;
import thaumcraft.common.tiles.TileThaumcraftInventory;
import thaumcraft.common.tiles.crafting.TilePedestal;

public class TileInfuser extends TileThaumcraftInventory {
    
    private int rotation = 0;
    private int rounds = 0;
    private boolean active = false;
    private BlockPos posPed = null;
    private RecipeCrystalInfusion recipe;
    
    public TileInfuser() {
        super(1);
        this.syncedSlots = new int[] { 0 };
    }
    
    @Override
    public void update() {
        if (active) {
            rotation += ((rounds + 1) * 7) / 3;
            if (rotation >= 360) {
                rotation = 0;
                rounds++;
                
                ArrayList<TilePedestal> peds = getPedestals();
                if (peds.size() != 6) {
                    active = false;
                    return;
                }
                
                if ((getPedestals().get(rounds - 1).getStackInSlot(0).getItem() instanceof ItemCrystalEssence)
                && (AspectHelper.getObjectAspects(getPedestals().get(rounds-1).getStackInSlot(0)).getAspects()[0] == recipe.getAspect())) {
                    getPedestals().get(rounds - 1).decrStackSize(0, 1);
                    if (rounds != 6)
                        posPed = getPedestals().get(rounds).getPos();
                }
                
                if (rounds == 6) {
                    setInventorySlotContents(0, recipe.getOutput());
                    active = false;
                    rounds = 0;
                }
                return;
            }
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
        && (getPedestals().size() == 6)
        && (isRecipeValid())
        && (ThaumcraftCapabilities.knowsResearch(p, recipe.getResearch()))) {
            posPed = getPedestals().get(0).getPos();
            return active = true;
        }
        return false;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public int getRounds() {
        return rounds;
    }
    
    public BlockPos getCurrentPed() {
        return posPed;
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
}
