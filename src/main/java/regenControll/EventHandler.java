package regenControll;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventHandler {
	
	@SubscribeEvent
	public void tickPlayer(PlayerTickEvent event){
		if(event.phase==TickEvent.Phase.START&&
				event.player.getHealth()<event.player.getMaxHealth()&&
				event.player.getFoodStats().getFoodLevel()>=Config.minHunger){
			if(event.player.getEntityWorld().getWorldTime()%Config.regenTime==0){
				event.player.heal(1F);
				event.player.getFoodStats().addExhaustion(Config.exhaustion);
			}
		}
	}
	@SubscribeEvent
	public void event(WorldEvent.Load event){
		event.getWorld().getGameRules().setOrCreateGameRule("naturalRegeneration", "false");
	}
	
}
