package com.Zoko061602.ThaumicRestoration.lib.research.cards;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import thaumcraft.api.research.theorycraft.ResearchTableData;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

public class CardRestoration extends TheorycraftCard {


	@Override
	public String getResearchCategory() {
		return "RESTORATION";
	}

	@Override
	public boolean activate(EntityPlayer arg0, ResearchTableData data) {
	    data.addTotal(getResearchCategory(), 25);
	    return true;
	}

	@Override
	public int getInspirationCost() {
		return 1;
	}

	@Override
	public String getLocalizedName() {
		return new TextComponentTranslation("card.restoration.name", new Object[0]).getUnformattedText();
	}

	@Override
	public String getLocalizedText() {
		return new TextComponentTranslation("card.restoration.text", new Object[0]).getUnformattedText();
	}

}
