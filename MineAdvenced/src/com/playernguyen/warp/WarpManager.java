package com.playernguyen.warp;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import com.playernguyen.MineAdvenced;

public class WarpManager {

	private File warpFile = new File(MineAdvenced.getMineAdvenced().getDataFolder(), "warp.yml");
	
	private YamlConfiguration warpYaml = YamlConfiguration.loadConfiguration(warpFile);
	
	public static WarpManager getWarpManager(){
		return new WarpManager();
	}
	
	public YamlConfiguration getConfig(){
		return warpYaml;
	}
	
	public Location getLocation(String name){
		World w = Bukkit.getServer().getWorld(warpYaml.getString("warp." + name + ".world"));
		double x = warpYaml.getDouble("warp." + name + ".x");
		double y = warpYaml.getDouble("warp." + name + ".y");
		double z = warpYaml.getDouble("warp." + name + ".z");
		
		return new Location(w, x, y, z);
	}
	
	public void setWarp(Location loc, String name){
		warpYaml.set("warp." + name + ".world", loc.getWorld().getName());
		warpYaml.set("warp." + name + ".x", loc.getX());
		warpYaml.set("warp." + name + ".y", loc.getY());
		warpYaml.set("warp." + name + ".z", loc.getZ());
		
		try {
			warpYaml.save(warpFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delWarp(String name){
		warpYaml.set("warp." + name + ".world", null);
		warpYaml.set("warp." + name + ".x", null);
		warpYaml.set("warp." + name + ".y", null);
		warpYaml.set("warp." + name + ".z", null);
	}
	
	public boolean checkWarp(String name){
		if(warpYaml.contains("warp." + name)){
			return true;
		} else {
			return false;
		}
	}
	
	public Set<String> getListWarp(){
		return getConfig().getConfigurationSection("warp").getKeys(false);
	}
	
}
