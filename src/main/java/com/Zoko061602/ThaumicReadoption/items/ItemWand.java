package com.Zoko061602.ThaumicReadoption.items;

import com.Zoko061602.ThaumicReadoption.api.IWandTrigger;
import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;
import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import thaumcraft.api.crafting.IDustTrigger;
import thaumcraft.api.items.IRechargable;
import thaumcraft.api.items.RechargeHelper;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.lib.SoundsTC;
import thaumcraft.common.lib.utils.EntityUtils;

public class ItemWand extends Item implements IRechargable {


	public ItemWand() {
		this.setMaxStackSize(1);
		this.setRegistryName(ThaumicReadoption.ModID, "item_wand");
		this.setUnlocalizedName("item_wand");
		this.setCreativeTab(ReadoptedTab.tabReadopted);
		this.setHasSubtypes(true);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if(tab==ReadoptedTab.tabReadopted)
		 for(int i=0;!(i==3);i++) {
		  ItemStack is = new ItemStack(this, 1, i);
		  RechargeHelper.rechargeItemBlindly(is, null, getMaxCharge(is, null));
		  items.add(new ItemStack(this, 1, i));
		  items.add(is);
		 }


	}


     @Override
     public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
	    if(!player.canPlayerEdit(pos, side, player.getHeldItem(hand)))
	      return EnumActionResult.FAIL;
	    if(player.isSneaking())
	      return EnumActionResult.PASS;

	    player.swingArm(hand);

	    for(IWandTrigger trigger : IWandTrigger.triggers){
	    	IWandTrigger.Placement place = trigger.getValidFace(world, player, pos, side);
	      if(place != null){
	    	  int cost= trigger.getCost();
	        if(player.capabilities.isCreativeMode)cost=0;
	          if(RechargeHelper.getCharge(player.getHeldItem(hand))>=cost){
                 RechargeHelper.consumeCharge(player.getHeldItem(hand), player, cost);
	             trigger.execute(world, player, pos, place, side);
	            if(world.isRemote){
	    	      doSparkles(player, world, pos, hitX, hitY, hitZ, hand, trigger, place);
	    	      break;
	            }
	            return EnumActionResult.SUCCESS;
	          }
	      }
	    }
	    return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
   }

    private void doSparkles(EntityPlayer player, World world, BlockPos pos, float hitX, float hitY, float hitZ, EnumHand hand, IDustTrigger trigger, IDustTrigger.Placement place){
      Vec3d v1 = EntityUtils.posToHand(player, hand);
      Vec3d v2 = new Vec3d(pos);
      v2 = v2.addVector(0.5D, 0.5D, 0.5D);
      v2 = v2.subtract(v1);
      int cnt = 50;
      float r; for (int a = 0; a < cnt; a++) {
      boolean floaty = a < cnt / 3;
      r = MathHelper.getInt(world.rand, 255, 255) / 255.0F;
      float g = MathHelper.getInt(world.rand, 189, 255) / 255.0F;
      float b = MathHelper.getInt(world.rand, 64, 255) / 255.0F;
       FXDispatcher.INSTANCE.drawSimpleSparkle(world.rand, v1.x, v1.y, v1.z, v2.x / 6.0D + world.rand
           .nextGaussian() * 0.05D, v2.y / 6.0D + world.rand
           .nextGaussian() * 0.05D + (floaty ? 0.05D : 0.15D), v2.z / 6.0D + world.rand
           .nextGaussian() * 0.05D, 0.5F, r, g, b, world.rand
           .nextInt(5), floaty ? 0.3F + world.rand
           .nextFloat() * 0.5F : 0.85F, floaty ? 0.2F : 0.5F, 16);
       }
       world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundsTC.dust, SoundCategory.PLAYERS, 0.33F, 1.0F +
         (float)world.rand.nextGaussian() * 0.05F, false);


       java.util.List<BlockPos> sparkles = trigger.sparkle(world, player, pos, place);
       Vec3d v; if (sparkles != null) {
         v = new Vec3d(pos).addVector(hitX, hitY, hitZ);
         for (BlockPos p : sparkles) {
           FXDispatcher.INSTANCE.drawBlockSparkles(p, v);
         }
       }
     }


	@Override
	public int getMaxCharge(ItemStack stack, EntityLivingBase player) {
		switch (stack.getItemDamage()) {
		case 0: return 50;
		case 1: return 200;
		case 2: return 800;
		default: return 50;
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item_wand_"+stack.getItemDamage();
	}


	@Override
	public EnumChargeDisplay showInHud(ItemStack stack, EntityLivingBase player) {
		return EnumChargeDisplay.NEVER;
	}



}
