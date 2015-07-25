package com.playernguyen;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class DonateManager {

	private File donateFile = new File(MineAdvenced.getMineAdvenced().getDataFolder(), "config.yml");
	
	private YamlConfiguration donateYaml = YamlConfiguration.loadConfiguration(donateFile);
	
	public static DonateManager getDonate(){
		return new DonateManager();
	}
	
	public void save(){
		try {
			donateYaml.save(donateFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * With Update
	 * VIP : 20
	 * PLUS : 50
	 * SUPER : 100
	 * @author Admin
	 *
	 */
	public enum DonateRank{
		VIP, PLUS, SUPER, NONE;
	}
	
	public DonateRank getPlayer(Player p){
		return (DonateRank) donateYaml.get("doante." + p.getUniqueId() + ".rank");
	}
	
	
	public void setRank(DonateRank rank, Player p)
	{
		donateYaml.set("donate." + p.getUniqueId() + ".rank", rank);
		save();
	}
	
	public boolean hasRank(DonateRank rank)
	{
		if (rank == DonateRank.NONE){
			return false;
		} else {
			return true;
		}
	}
	
	
	
}
