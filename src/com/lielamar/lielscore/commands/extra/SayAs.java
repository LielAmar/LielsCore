package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class SayAs implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.sayas")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("sayas")) {
			Player p = (Player)cs;
			
			if(args.length < 2) {
				p.sendMessage(Messages.wrongUsage("SayAS", "<Player>", "<Message>"));
				return true;
			}

			Player t = Bukkit.getPlayer(args[0]);
				
			if(t == null) {
				cs.sendMessage(Messages.playerNotFound(args[0]));
				return true;
			}
			
			String message = "";
			for(int i = 1; i < args.length; i++)
				message = args[i] + " ";
			message.substring(0, message.length());
			
			if(message.startsWith("/")) {
				t.performCommand(message.substring(1));
				p.sendMessage(ChatColor.GRAY + "Peforming the command " + ChatColor.YELLOW + message + ChatColor.GRAY + " as " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
				return true;
			} else {
				t.chat(message);
			}
		}
		return true;
	}
}
