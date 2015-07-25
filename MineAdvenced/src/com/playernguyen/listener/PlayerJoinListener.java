package com.playernguyen.listener;


import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.playernguyen.DonateManager;
import com.playernguyen.ItemList;
import com.playernguyen.DonateManager.DonateRank;
import com.playernguyen.PlayersAPI;
import com.playernguyen.SettingsManager;

import ca.wacos.nametagedit.NametagAPI;


public class PlayerJoinListener implements Listener{

	private String prefix = ChatColor.translateAlternateColorCodes('&', "&4[&8MineAdvenced&4]");
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		List<String> motd = SettingsManager.getSetting().getConfig().getStringList("motd");
		
		for (String s : motd){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
		}
		
		PlayersAPI playerAPI = new PlayersAPI(p);
		
		e.setJoinMessage(prefix + ChatColor.RED + "Người chơi " + ChatColor.GRAY +  p.getName() + ChatColor.RED +" đã vào server với IP: "+ ChatColor.GRAY+ playerAPI.getAddress()+ ChatColor.RED + ".");
		
		if (e.getPlayer().getWorld() == Bukkit.getServer().getWorld("world"))
		{
			e.getPlayer().getInventory().setItem(1, ItemList.getItemList().teleportCompass());
		}
		
		if (DonateManager.getDonate().getPlayer(p) == DonateRank.NONE)
		{
			
		}
		else if (DonateManager.getDonate().getPlayer(p) == DonateRank.VIP)
		{
			NametagAPI.setPrefix(p.getName(), ChatColor.YELLOW + "VIP");
		} else if (DonateManager.getDonate().getPlayer(p) == DonateRank.SUPER) {
			NametagAPI.setPrefix(p.getName(), ChatColor.BLUE + "SUPER");
		} else if (DonateManager.getDonate().getPlayer(p) == DonateRank.PLUS) {
			NametagAPI.setPrefix(p.getName(), ChatColor.BLUE + "PLUS");
		}
		
	}
	
//	@EventHandler
//	public void onPlayerIntectEvent(PlayerInteractEvent e){
//		if (e.getPlayer().getItemInHand().getType() == Material.JUKEBOX
//				&& e.getAction() == Action.LEFT_CLICK_AIR
//				|| e.getAction() == Action.RIGHT_CLICK_AIR && e.getPlayer().getItemInHand().getType() == Material.JUKEBOX
//				|| e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getItemInHand().getType() == Material.JUKEBOX
//				|| e.getAction() == Action.LEFT_CLICK_BLOCK && e.getPlayer().getItemInHand().getType() == Material.JUKEBOX);
//			
//		{
//			e.setCancelled(true);
//			WarpMenu menu = new WarpMenu("Dịch chuyển");
//			menu.show(e.getPlayer());
//		}
//	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getAction() == InventoryAction.DROP_ALL_CURSOR
				|| e.getAction() == InventoryAction.DROP_ONE_CURSOR
				&& e.getCurrentItem().getItemMeta().getDisplayName() == ItemList.getItemList().teleportCompass().getItemMeta().getDisplayName()){
			
			
			e.setCancelled(true);
			
		}
	}
	
}
