package com.Zoko061602.ThaumicRestoration.compat.tconstruct;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitEntropic extends AbstractTrait {

	public TraitEntropic(int color) {
		super("tr_entropic", color);
	}

	@Override
	public void blockHarvestDrops(ItemStack tool, HarvestDropsEvent event) {
		/*List<ItemStack> drops = event.getDrops();
		 if(drops.size()==1)
		  if(drops.get(0).getItem()!=new ItemStack(Blocks.COBBLESTONE).getItem())
		 event.setDropChance(0);
        */
	}

}
