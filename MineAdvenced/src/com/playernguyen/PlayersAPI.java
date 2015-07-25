package com.playernguyen;

import java.util.UUID;

import org.bukkit.entity.Player;

import com.playernguyen.DonateManager.DonateRank;

import me.shukari.coins.CoinsAPI;

public class PlayersAPI {

	private Player p;
	
	private UUID uuid;
	
	private String address;
	
	public PlayersAPI(Player p){
		this.p = p;
		this.uuid = p.getUniqueId();
		this.address = p.getAddress().getAddress().getHostAddress();
	}
	
	public Player getPlayer(){
		return p;
	}
	
	public UUID getUUID(){
		return uuid;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void addCoin(int amount){
		CoinsAPI api = new CoinsAPI();
		
		api.addCoins(p, amount);
	}
	
	public int getCoin(){
		CoinsAPI api = new CoinsAPI();
		
		return api.getCoins(p);
	}
	
	public void addKill(){
		PlayerManager.getPlayerManager().getConfig().set("player." + uuid.toString() + ".kill",
				(PlayerManager.getPlayerManager().getConfig().getInt("player." + uuid.toString()+".kill") + 1));
	}
	
	public int getKill(){
		return PlayerManager.getPlayerManager().getConfig().getInt("player." + uuid.toString()+".kill");
	}
	
	public void addDeath(){
		PlayerManager pm = PlayerManager.getPlayerManager();
		
		pm.getConfig().set("player." + uuid.toString() + ".death", 
							(pm.getConfig().getInt("player" + uuid.toString() + ".death") + 1));
		
	}
	
	public int getDeath(){
		return PlayerManager.getPlayerManager().getConfig().getInt("player" + uuid.toString() + ".death");
	}
	
	public DonateRank getRank(){
		return DonateManager.getDonate().getPlayer(p);
	}
	
}
