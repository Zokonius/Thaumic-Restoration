package com.Zoko061602.ThaumicRestoration.client.compat.jei.crystalinfusion;

import org.lwjgl.opengl.GL11;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.client.compat.jei.AlphaDrawable;
import com.Zoko061602.ThaumicRestoration.client.compat.jei.ItemStackDrawable;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CrystalCategory implements IRecipeCategory<CrystalWrapper> {
    
    public static final String UUID = "THAUMICRESTORATION_CRYSTAL";
    public static final int ASPECT_Y = 66;
    public static final int ASPECT_X = 66;
    public static final int SPACE = 22;
    
    private final IGuiHelper helper;
    
    public CrystalCategory(IGuiHelper guiHelper){
        this.helper = guiHelper;
    }
    
    @Override
    public String getUid(){
        return UUID;
    }
    
    @Override
    public String getModName() {
        return ThaumicRestoration.ModName;
    }
    
    @Override
    public String getTitle() {
        return new ItemStack(TR_Blocks.blockInfuser).getDisplayName();
    }
    
    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(TR_Blocks.blockInfuser));
    }
    
    @Override
    public IDrawable getBackground() {
        return new AlphaDrawable(new ResourceLocation("thaumicrestoration", "textures/gui/gui_crystal_infusion_overlay.png"), 0, 0, 128, 128, 0, 0, 0, 0);
    }
    
    @Override
    public void drawExtras(Minecraft minecraft) {
        minecraft.renderEngine.bindTexture(new ResourceLocation("thaumicrestoration", "textures/gui/gui_crystal_infusion_overlay.png"));
        GL11.glEnable(3042);
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 128, 128, 128, 128, 128, 128);
        GL11.glDisable(3042);
    }
    
    @Override
    public void setRecipe(IRecipeLayout layout, CrystalWrapper wrapper, IIngredients ingr) {
        layout.getItemStacks().init(0, false, 56, 13);
        layout.getItemStacks().set(0, ingr.getOutputs(ItemStack.class).get(0));
        
        layout.getItemStacks().init(1, true, 55, 42);
        layout.getItemStacks().set(1, ingr.getInputs(ItemStack.class).get(0));
        
        for (int i = 0; !(i == 6); i++) {
            layout.getItemStacks().init(i + 2, true, 4 + 20 * i, 110);
            layout.getItemStacks().set(i + 2, ingr.getInputs(ItemStack.class).get(1));
        }
    }
    
}
