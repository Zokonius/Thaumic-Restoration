package com.Zoko061602.ThaumicRestoration.items;

import java.util.List;
import java.util.Random;

import com.Zoko061602.ThaumicRestoration.crafting.TR_Research;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.common.lib.SoundsTC;

public class ItemShard extends ItemBase {

	public ItemShard() {
		super("item_shard");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand){
		worldIn.playSound(null, player.posX, player.posY, player.posZ, SoundsTC.learn, SoundCategory.NEUTRAL, 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));

		if(!worldIn.isRemote){
			int oProg = EnumKnowledgeType.OBSERVATION.getProgression();
			int tProg = EnumKnowledgeType.THEORY.getProgression();

			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.OBSERVATION, TR_Research.catRestoration, MathHelper.getInt(player.getRNG(), oProg / 3, oProg / 2));
			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.THEORY, TR_Research.catRestoration, MathHelper.getInt(player.getRNG(), tProg / 5, tProg / 4));

			ResearchCategory[] rc = ResearchCategories.researchCategories.values().toArray(new ResearchCategory[0]);
			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.OBSERVATION, rc[player.getRNG().nextInt(rc.length)], MathHelper.getInt((Random) player.getRNG(), (int) (oProg / 3), (int) (oProg / 2)));
			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.THEORY, rc[player.getRNG().nextInt(rc.length)], MathHelper.getInt((Random) player.getRNG(), (int) (tProg / 5), (int) (tProg / 4)));

			if(!player.capabilities.isCreativeMode)
				player.getHeldItem(hand).shrink(1);
		}

		player.addStat(StatList.getObjectUseStats(this));
		player.sendMessage(new TextComponentString(TextFormatting.DARK_PURPLE + I18n.format("tc.knowledge.gained")));
		return super.onItemRightClick(worldIn, player, hand);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(I18n.format("item.curio.text"));
		tooltip.add(TextFormatting.BLUE + I18n.format(getUnlocalizedName() + ".tip"));
	}
}
