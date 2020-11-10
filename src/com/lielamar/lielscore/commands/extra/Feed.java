package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class Feed implements CommandExecutor{

	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.feed")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("feed")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				p.setFoodLevel(20);
				return true;
			}

			Player t = Bukkit.getPlayer(args[0]);
				
			if(t == null) {
				cs.sendMessage(Messages.playerNotFound(args[0]));
				p.sendMessage(ChatColor.YELLOW + "You were fed!");
				return true;
			}
			
			p.sendMessage(ChatColor.YELLOW + "You fed " + ChatColor.AQUA + t.getName() + ChatColor.YELLOW + "!");
			t.sendMessage(ChatColor.YELLOW + "You were fed!");
			t.setFoodLevel(20);
			return true;
		}
		return true;
	}
}
