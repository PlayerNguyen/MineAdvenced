package com.playernguyen;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerManager {

	private File playerFile = new File(MineAdvenced.getMineAdvenced().getDataFolder(), "player.yml");
	
	private YamlConfiguration playerYaml = YamlConfiguration.loadConfiguration(playerFile);
	
	public static PlayerManager getPlayerManager(){
		return new PlayerManager();
	}
	
	public YamlConfiguration getConfig(){
		return playerYaml;
	}
	
	public void save(){
		try {
			playerYaml.save(playerFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
