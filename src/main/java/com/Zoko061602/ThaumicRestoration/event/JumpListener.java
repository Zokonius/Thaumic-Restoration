package com.Zoko061602.ThaumicRestoration.event;

import com.Zoko061602.ThaumicRestoration.lib.crystal.CrystalEffectGrounded;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=ThaumicRestoration.modID)
public class JumpListener {

	@SubscribeEvent(priority=EventPriority.HIGH)
	public static void onJump(LivingJumpEvent e) {
		if(e.getEntityLiving()!=null) {
			if(CrystalEffectGrounded.getCrystalNearby(e.getEntityLiving().getPosition())!=null)
				e.getEntityLiving().jumpMovementFactor=0;
			else e.getEntityLiving().jumpMovementFactor=0.02F;
		}
	}

}
