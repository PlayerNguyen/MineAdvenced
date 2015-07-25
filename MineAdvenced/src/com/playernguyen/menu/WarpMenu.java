package com.playernguyen.menu;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.playernguyen.MineAdvenced;
import com.playernguyen.warp.WarpManager;

public class WarpMenu implements Listener{


	private Inventory inv;
	
	private ItemStack lobbySpawn, survival;
	
	public WarpMenu(String text)
	{
		
		inv = Bukkit.createInventory(null, 27, text);
		
		lobbySpawn = createItem(Material.BOOKSHELF,
				ChatColor.GRAY + "" + ChatColor.MAGIC +  "A" + ChatColor.RED + " Lobby Spawn " + ChatColor.GRAY + "" + ChatColor.MAGIC + "A",
				Arrays.asList(ChatColor.GRAY + "Trở về khu chính của Server.", ChatColor.RED + "Bấm chuột trái hay phải để di chuyển về khu chính."));
		
		survival = createItem(Material.DIAMOND_PICKAXE,
				ChatColor.GRAY + "" + ChatColor.MAGIC + "A" + ChatColor.RED + " Survival " + ChatColor.GRAY + "" + ChatColor.MAGIC + "A",
				Arrays.asList(ChatColor.GRAY + "Dịch chuyển đến Survival", ChatColor.RED + "Bấm vào để vào khu survival"));
		
		
		inv.setItem(9, lobbySpawn);
		inv.setItem(11, survival);
		
		Bukkit.getServer().getPluginManager().registerEvents(this, MineAdvenced.getMineAdvenced());
	}
	
	private ItemStack createItem(Material material, String name, List<String> lore){
		ItemStack items = new ItemStack(material, 1);
		
		ItemMeta meta = items.getItemMeta();
		
		meta.setDisplayName(name);
		meta.setLore(lore);
		
		items.setItemMeta(meta);
		
		return items;
	}
	
	public void show(Player p){
		p.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getInventory().getName() != inv.getName())
		{
			return;
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GRAY + "" + ChatColor.MAGIC +  "A" + ChatColor.RED + " Lobby Spawn " + ChatColor.GRAY + "" + ChatColor.MAGIC + "A"))
		{
			e.setCancelled(true);
			e.getWhoClicked().teleport(WarpManager.getWarpManager().getLocation("spawn"));
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GRAY + "" + ChatColor.MAGIC + "A" + ChatColor.RED + " Survival " + ChatColor.GRAY + "" + ChatColor.MAGIC + "A"))
		{
			e.setCancelled(true);
			e.getWhoClicked().teleport(WarpManager.getWarpManager().getLocation("survival"));
		}
	}
	
}
