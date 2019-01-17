package com.Zoko061602.ThaumicRestoration.compat.crafttweaker;

import com.Zoko061602.ThaumicRestoration.lib.crafting.RecipeCrystalInfusion;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.Aspect;

@ZenClass("mods.thaumicrestoration.CrystalInfusion")
@ZenRegister
public class CrystalInfusion {

    public static final String name = "Thaumic Restoration Crystal Infusion";


	@ZenMethod
	public static void addRecipe(String key, IItemStack output, String aspect, IItemStack input) {
	 if(parseAspects(aspect) == null)return;
     Aspect a = parseAspects(aspect);
     CraftTweakerCompat.lateAdditions.add(new Add(new RecipeCrystalInfusion(key, a, toStack(input), toStack(output))));
	}

    public static Aspect parseAspects(String str) {
        if (str == null || str.equals("")) return null;
            if (str.startsWith(" ")) str = str.replace(" ", "");
            return Aspect.aspects.get(str);
    }

    public static ItemStack toStack(IItemStack iStack) {
        if(iStack == null)
          return ItemStack.EMPTY;
        Object internal = iStack.getInternal();
        return (ItemStack)internal;
    }

    private static class Add implements IAction {
	RecipeCrystalInfusion r;

	public Add(RecipeCrystalInfusion r) {
		this.r = r;
	}

	@Override
	public void apply() {
		r.register();
	}

	@Override
	public String describe() {
		return "";
	}

}

}
