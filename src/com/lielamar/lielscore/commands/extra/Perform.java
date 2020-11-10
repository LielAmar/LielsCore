package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class Perform implements CommandExecutor {
	
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!cs.hasPermission("lielscore.commands.perform")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("perform")) {
			if(args.length == 0) {
				cs.sendMessage(Messages.wrongUsage("Perform", "[Target]" ,"<Command>"));
				return false;
			}
			
			Player t = Bukkit.getPlayer(args[0]);
			
			if(t == null) {
				String command = "";
				for(int i = 0; i < args.length; i++)
					command += args[i] + " ";
				command.substring(0, command.length()-2);
				
				cs.sendMessage(Messages.performCommand("Console", command));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
			} else {
				if(args.length == 1) {
					cs.sendMessage(Messages.wrongUsage("Perform", "[Target]" ,"<Command>"));
					return false;
				}
				
				String command = "";
				for(int i = 1; i < args.length; i++)
					command += args[i] + " ";
				command.substring(0, command.length()-2);
				
				cs.sendMessage(Messages.performCommand(t.getName(), command));
				t.performCommand(command);
			}
		}
		return true;
	}
}
