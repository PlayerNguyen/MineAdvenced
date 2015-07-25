package com.playernguyen;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemList {

	public static ItemList getItemList()
	{
		return new ItemList();
	}
	
	public ItemStack createStack(Material material, String name, List<String> lore){
		ItemStack items = new ItemStack(material, 1);
		
		ItemMeta meta = items.getItemMeta();
		
		meta.setDisplayName(name);
		meta.setLore(lore);
		
		items.setItemMeta(meta);
		
		return items; 
	}
	
	public ItemStack teleportCompass()
	{
		return createStack(Material.JUKEBOX,
				ChatColor.RED + "KHU" + ChatColor.GRAY + "(Chuột phải).",
				Arrays.asList(ChatColor.RED + "Chuột phải để mở lên."));
	}
	
}
