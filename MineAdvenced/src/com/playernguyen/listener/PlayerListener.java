package com.playernguyen.listener;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.playernguyen.ItemList;

import ca.wacos.nametagedit.NametagAPI;

public class PlayerListener implements Listener {

	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e)
	{
		if (e.getPlayer().getWorld() == Bukkit.getServer().getWorld("world"))
		{
			e.getPlayer().getInventory().setItem(1, ItemList.getItemList().teleportCompass());
		}
	}
	
	// Chat
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent e)
	{
		
		String chat = e.getMessage();
		
		e.setFormat(NametagAPI.getPrefix(e.getPlayer().getName()) + ChatColor.GRAY + e.getPlayer().getName() + ChatColor.DARK_GRAY + ">" + ChatColor.GRAY + chat);
	}
}
