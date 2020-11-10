package com.lielamar.lielscore.commands.extra;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.lielamar.lielscore.utils.Messages;

public class Memory implements CommandExecutor {
	
	private Long uptime;
	
	public Memory() {
		uptime = System.currentTimeMillis();
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!cs.hasPermission("lielscore.commands.memory")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("memory")) {
			cs.sendMessage(ChatColor.GRAY + "===== Server Information =====");
			cs.sendMessage(ChatColor.GRAY + "• Up Time: " + ChatColor.YELLOW + ((System.currentTimeMillis()-uptime)/1000) + " seconds");
			double max = Runtime.getRuntime().maxMemory()/1048576;
			double free = Runtime.getRuntime().freeMemory()/1048576;
			cs.sendMessage(ChatColor.GRAY + "• Max Memory: " + ChatColor.YELLOW + max);
			cs.sendMessage(ChatColor.GRAY + "• Free Memory: " + ChatColor.YELLOW + free);
			return true;
		}
		return true;
	}
}
