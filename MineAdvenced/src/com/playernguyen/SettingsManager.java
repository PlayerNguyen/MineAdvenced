package com.playernguyen;

import java.io.File;
import java.util.Random;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {

	private File configFile;
	private YamlConfiguration configYaml;
	
	private static SettingsManager sm = new SettingsManager();
	
	public static SettingsManager getSetting(){
		return sm;
	}
	
	@SuppressWarnings("unused")
	public void setup(Plugin p){
		if(!p.getDataFolder().exists()) p.getDataFolder().mkdir();
		
		configFile = new File(p.getDataFolder(), "config.yml");
		
		boolean n = false;
		
		if (!configFile.exists()) {
			try { configFile.createNewFile(); n = true; }
			catch (Exception e) { e.printStackTrace(); }
		}
		
		configYaml = YamlConfiguration.loadConfiguration(configFile);
		
	}
	
	public YamlConfiguration getConfig(){
		return configYaml;
	}
	
	public int randomMoney(){
		Random rand = new Random();
		int moneyValue = getConfig().getInt("maxMoneyKill") - getConfig().getInt("minMoneyKill") + 1;
		int randMoney = rand.nextInt(moneyValue);
		
		return randMoney;
	}
	
	 
	
}
