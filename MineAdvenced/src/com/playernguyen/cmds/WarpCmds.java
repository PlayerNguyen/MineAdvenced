package com.playernguyen.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.playernguyen.MessageManager;
import com.playernguyen.warp.WarpManager;

public class WarpCmds implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Ban phai la nguoi.");
			return true;
		}
		
		Player p = (Player)sender;
		if (args.length == 0){
			MessageManager.getMessage().msg(p, ChatColor.RED + "Bạn hãy dùng " + ChatColor.GRAY + "/warp [tên] " + ChatColor.RED + " .");
			
			if(WarpManager.getWarpManager().getListWarp() == null){
				MessageManager.getMessage().msg(p, ChatColor.RED + "Không có warp nào...Tại thằng Admin hay owner chưa set nhé.");
			} else {

				MessageManager.getMessage().msg(p, ChatColor.GRAY + WarpManager.getWarpManager().getListWarp().toString());
			}
			
			return true;
		}
		
		
		p.teleport(WarpManager.getWarpManager().getLocation(args[0]));
		
		MessageManager.getMessage().msg(p, ChatColor.RED + "Đã di chuyển tới khu " + ChatColor.GRAY + args[0]+ ChatColor.RED + ".");
		
		return false;
	}
	
}
