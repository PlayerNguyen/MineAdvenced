package com.playernguyen.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.playernguyen.MessageManager;
import com.playernguyen.warp.WarpManager;

public class DelWarpCmds implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (sender.hasPermission("ma.delwarp") || sender.hasPermission("ma.*")){
			if(!(sender instanceof Player)){
				sender.sendMessage("Ban phai la nguoi choi.");
				return true;
			}
			
			Player p = (Player)sender;
			
			if (args.length == 0){
				MessageManager.getMessage().msg(p, ChatColor.RED + "Bạn hãy dùng " + ChatColor.GRAY + "/delwarp [tên] " + ChatColor.RED + " .");
				
				for (String s : WarpManager.getWarpManager().getListWarp()){
					MessageManager.getMessage().msg(p, ChatColor.GRAY + s);
				}
			}

			
			WarpManager.getWarpManager().delWarp(args[0]);
			
			MessageManager.getMessage().msg(p, ChatColor.RED + "Đã xóa khu " + ChatColor.GRAY + args[0] + ChatColor.RED + ".");
			
		} else {
			MessageManager.getMessage().msg((Player)sender, ChatColor.RED + "Bạn không có quyền để thực hiện lệnh này!");
			return true;
		}
		return true;
	}
	
}
