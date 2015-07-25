package com.playernguyen.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.playernguyen.MessageManager;
import com.playernguyen.warp.WarpManager;

public class SetwarpCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender.hasPermission("ma.setwarp") || sender.hasPermission("ma.*")){
			if (!(sender instanceof Player)){
				sender.sendMessage(ChatColor.RED + "Ban phai la nguoi.");
				return true;
			}
			
			Player p = (Player)sender;
			if (args.length == 0){
				MessageManager.getMessage().msg(p, ChatColor.RED + "Bạn hãy dùng " + ChatColor.GRAY + "/setwarp [tên] " + ChatColor.RED + " .");			
				return true;
			}
			
			
			
			WarpManager.getWarpManager().setWarp(p.getLocation(), args[0]);
			
			MessageManager.getMessage().msg(p, ChatColor.RED + "Đã tạo khu " + ChatColor.GRAY + args[0] + ChatColor.RED + ".");
			
		}else{
			MessageManager.getMessage().msg((Player)sender, ChatColor.RED + "Bạn không có quyền để thực hiện lệnh này!");
			return true;
		}
				
		return false;
	}
	
}
