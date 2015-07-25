package com.playernguyen;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.playernguyen.cmds.DelWarpCmds;
import com.playernguyen.cmds.SetwarpCmd;
import com.playernguyen.cmds.WarpCmds;
import com.playernguyen.listener.PlayerJoinListener;
import com.playernguyen.listener.PlayerKillListener;
import com.playernguyen.listener.PlayerListener;

public class MineAdvenced extends JavaPlugin{

	public void onEnable(){
		Logger log = getLogger();
		log.info("MineAdvenced dang tai...");
		log.info("Tai cac khu vuc.");
		
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		SettingsManager.getSetting().setup(this);
		
		registerAllLogin();
		
	}
	
	public static Plugin getMineAdvenced(){
		return Bukkit.getServer().getPluginManager().getPlugin("MineAdvenced");
	}
	
	private void registerAllLogin(){
		getCommand("warp").setExecutor(new WarpCmds());
		getCommand("setwarp").setExecutor(new SetwarpCmd());
		getCommand("delwarp").setExecutor(new DelWarpCmds());
		
		getCommand("khu").setExecutor(new WarpCmds());
		getCommand("setkhu").setExecutor(new SetwarpCmd());
		getCommand("delkhu").setExecutor(new DelWarpCmds());
		
		
		// Listener
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerKillListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	}
	
}
