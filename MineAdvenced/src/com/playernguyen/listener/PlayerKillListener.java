package com.playernguyen.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.playernguyen.PlayersAPI;
import com.playernguyen.SettingsManager;

public class PlayerKillListener implements Listener{

	@EventHandler
	public void onPlayerKillPlayerEvent(PlayerDeathEvent e){
		
		Player killer = e.getEntity().getKiller();
		
		PlayersAPI playersAPI = new PlayersAPI(killer);
		
		playersAPI.addKill();
		
		playersAPI.addCoin(SettingsManager.getSetting().randomMoney());
		
	}
	
	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent e){
		Player killed = e.getEntity();
		
		PlayersAPI playersAPI = new PlayersAPI(killed);
		
		playersAPI.addDeath();
		
	}
	
}
