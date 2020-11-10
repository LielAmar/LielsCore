package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class Teleport implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.teleport")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("teleport")) {
			if(args.length == 0) {
				cs.sendMessage(Messages.wrongUsage("Teleport", "<Player/Location> [Player]"));
				return true;
			}
			
			Player p = (Player)cs;
			
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				
				if(t == null) {
					cs.sendMessage(Messages.playerNotFound(args[0]));
					return true;
				}
				
				p.teleport(t);
				p.sendMessage(Messages.teleporting(t.getName()));
				return true;
			} else if(args.length == 2) {
				Player t1 = Bukkit.getPlayer(args[0]);
				
				if(t1 == null) {
					cs.sendMessage(Messages.wrongUsage("Teleport", "<Player/Location> [Player]"));
					return true;
				}
				
				Player t2 = Bukkit.getPlayer(args[1]);
				
				if(t2 == null) {
					cs.sendMessage(Messages.wrongUsage("Teleport", "<Player/Location> [Player]"));
					return true;
				}
				
				t1.teleport(t2);
				p.sendMessage(Messages.teleporting(t1, t2.getName()));
				return true;
			} else if(args.length == 3) {
				try {
					double x = Double.parseDouble(args[0]);
					double y = Double.parseDouble(args[1]);
					double z = Double.parseDouble(args[2]);
					
					Location loc = new Location(p.getWorld(), x, y, z);
					p.teleport(loc);
					p.sendMessage(Messages.teleporting("(" + x + ", " + y + ", " + z + ")"));
					return true;
				} catch(Exception e) {
					cs.sendMessage(Messages.wrongUsage("Teleport", "<Player/Location> [Player]"));
					return true;
				}
			}
			return true;
		}
		return true;
	}
}
