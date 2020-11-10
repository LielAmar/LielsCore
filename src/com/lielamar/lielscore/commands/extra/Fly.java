package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class Fly implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.fly")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("fly")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				if(p.getAllowFlight()) {
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(ChatColor.GRAY + "Flight " + ChatColor.RED + "disabled" + ChatColor.GRAY + "!");
					return true;
				} else {
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(ChatColor.GRAY + "Flight " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
					return true;
				}
			} else {
				if(!cs.hasPermission("lielscore.commands.fly.others")) {
					cs.sendMessage(Messages.noPermissions);
					return true;
				}
				
				Player t = Bukkit.getPlayer(args[0]);
							
				if(t == null) {
					cs.sendMessage(Messages.playerNotFound(args[0]));
					return true;
				}
							
				if(t.getAllowFlight()) {
					t.setAllowFlight(false);
					t.setFlying(false);
					t.sendMessage(ChatColor.GRAY + "Flight " + ChatColor.RED + "disabled" + ChatColor.GRAY + "!");
					p.sendMessage(ChatColor.RED + "Disabled " + ChatColor.GRAY + "flight for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
					return true;
				} else {
					t.setAllowFlight(true);
					t.setFlying(true);
					t.sendMessage(ChatColor.GRAY + "Flight " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
					p.sendMessage(ChatColor.GREEN + "Enabled " + ChatColor.GRAY + "flight for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
					return true;
				}

			}
		}
		return true;
	}
}
