package com.Zoko061602.ThaumicReadoption.items;

import java.util.List;

import com.Zoko061602.ThaumicReadoption.lib.crafting.IWandTrigger;
import com.Zoko061602.ThaumicReadoption.main.ReadoptedTab;
import com.Zoko061602.ThaumicReadoption.main.ThaumicReadoption;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.crafting.IDustTrigger;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.lib.SoundsTC;
import thaumcraft.common.lib.utils.EntityUtils;

public class ItemWand extends Item {

	protected float vis = 0;
	protected float maxVis = 50;

	public ItemWand() {
		this.setMaxStackSize(1);
		this.setRegistryName(ThaumicReadoption.ModID, "item_wand");
		this.setUnlocalizedName("item_wand");
		this.setCreativeTab(ReadoptedTab.tabReadopted);
	}


	@Override
    public void onUpdate(ItemStack stack, World world, Entity player, int slot, boolean isSelected) {
		if(world.rand.nextInt(30)==1)
	     if(AuraHelper.getVis(world, player.getPosition())>50 && isSelected && getVis(stack)<maxVis) {
		  AuraHelper.drainVis(world, player.getPosition(), 0.25F, false);
		  addVis(stack, 0.1F);
	   }
	}

	public static ItemStack addVis(ItemStack stack, float vis){
		if(!(stack.getItem() instanceof ItemWand)) return null;
		 if(vis<0 && (ItemWand.getMaxVis(stack)>(getVis(stack)+vis)))return stack;
		   NBTTagCompound nbt = new NBTTagCompound();
		   if(stack.hasTagCompound()) {
		    nbt = stack.getTagCompound();
		      if(nbt.hasKey("vis"))
			    nbt.setFloat("vis", nbt.getFloat("vis")+vis);
			  else nbt.setFloat("vis", vis);
		      if(nbt.getFloat("vis")>getMaxVis(stack))
		    	  nbt.setFloat("vis", getMaxVis(stack));
		   }
		      stack.setTagCompound(nbt);
		return stack;
	}

	public static ItemStack consumeVis(ItemStack stack, float vis){
		if(!(stack.getItem() instanceof ItemWand)) return null;
		NBTTagCompound nbt = new NBTTagCompound();
		if(stack.hasTagCompound())nbt = stack.getTagCompound();
		 if(nbt.hasKey("vis"))
		  if(nbt.getFloat("vis")-vis>=0)
		   nbt.setFloat("vis", nbt.getFloat("vis")-vis);
		stack.setTagCompound(nbt);
		return stack;
	}

	public static float getVis(ItemStack stack){
		if(!(stack.getItem() instanceof ItemWand)) return 0;
		NBTTagCompound nbt = new NBTTagCompound();
		if(!stack.hasTagCompound())return 0;
		nbt = stack.getTagCompound();
		if(!nbt.hasKey("vis"))return 0;
		   return nbt.getFloat("vis");
	}

	public static float getMaxVis(ItemStack stack){
		if(!(stack.getItem() instanceof ItemWand)) return 0;
		return 50;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if(tab==ReadoptedTab.tabReadopted) {
		 ItemStack is = new ItemStack(this, 1, 0);
	     items.add(new ItemStack(this, 1, 0));
	     NBTTagCompound nbt = new NBTTagCompound();
	     nbt.setFloat("vis", 50);
	     is.setTagCompound(nbt);
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
	          if(getVis(player.getHeldItem(hand))>=cost){
                 consumeVis(player.getHeldItem(hand),cost);
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

     @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	 tooltip.add("Stored Vis: " + ((int)getVis(stack)));
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



}
