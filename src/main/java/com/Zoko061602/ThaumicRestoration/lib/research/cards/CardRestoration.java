package com.Zoko061602.ThaumicRestoration.lib.research.cards;

import net.minecraft.entity.player.EntityPlayer;
import thaumcraft.api.research.theorycraft.ResearchTableData;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

public class CardRestoration extends TheorycraftCard {



	@Override
	public boolean activate(EntityPlayer arg0, ResearchTableData data) {
		return false;
	}

	@Override
	public int getInspirationCost() {
		return 1;
	}

	@Override
	public String getLocalizedName() {
		return "Regained Knowlege";
	}

	@Override
	public String getLocalizedText() {
		return null;
	}

}
