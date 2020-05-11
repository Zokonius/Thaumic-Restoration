package com.Zoko061602.ThaumicRestoration.lib.crafting;

import java.util.ArrayList;

import com.Zoko061602.ThaumicRestoration.lib.research.AspectUtil;

import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;

public class RecipeCrystalInfusion {
    
    private static ArrayList<RecipeCrystalInfusion> recipes = new ArrayList<RecipeCrystalInfusion>();
    private String research;
    private Aspect aspect;
    private ItemStack input;
    private ItemStack output;
    
    public RecipeCrystalInfusion(String research, Aspect aspect, ItemStack input, ItemStack output) {
        this.research = research;
        this.aspect = aspect;
        this.input= input;
        this.output = output;
        register();
    }
    
    public String getResearch() {
        return research;
    }
    
    public ItemStack getInput() {
        return input;
    }
    
    public Aspect getAspect() {
        return aspect;
    }
    
    public ItemStack getOutput() {
        return output;
    }
    
    //Used only for JEI.
    public ArrayList<ItemStack> getInputs(){
        ArrayList<ItemStack> r = new ArrayList<>();
        r.add(input);
        for(int i = 0; !(i == 6); i++)
            r.add(AspectUtil.crystalEssence(aspect));
        return r;
    }
    
    private void register() {
        if (this.getAspect  () == null) return;
        if (this.getInput   () == null) return;
        if (this.getOutput  () == null) return;
        if (this.getResearch() == null) this.research="FIRSTSTEPS@1";
        recipes.add(this);
    }
    
    public static ArrayList<RecipeCrystalInfusion> getRecipes() {
        return recipes;
    }
    
}
