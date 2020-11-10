package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.lielamar.lielscore.utils.Messages;

public class GMX implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!cs.hasPermission("lielscore.commands.gmx")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("gmx")) {
			cs.sendMessage(ChatColor.GRAY + "Reloading...");
			Bukkit.getServer().reload();
		}
		return true;
	}
}
