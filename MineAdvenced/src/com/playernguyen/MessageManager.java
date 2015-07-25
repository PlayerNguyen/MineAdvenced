package com.playernguyen;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageManager {

	public static MessageManager getMessage(){
		return new MessageManager();
	}
	
	private String prefix = ChatColor.translateAlternateColorCodes('&', "&4[&8MineAdvenced&4]");
	
	public void msg(Player p, String msg){
		p.sendMessage(prefix + msg);
	}
	
}
