package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class Gamemode implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.gamemode")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("gamemode")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				p.sendMessage(Messages.wrongUsage("Gamemode", "<Gamemode/Target> [Gamemode]"));
				return true;
			}
			
			if(args.length == 2) {
				Player t = Bukkit.getPlayer(args[0]);
				
				if(t == null) {
					cs.sendMessage(Messages.playerNotFound(args[0]));
					return true;
				}
				
				if(!cs.hasPermission("lielscore.commands.gamemode.others")) {
					cs.sendMessage(Messages.noPermissions);
					return true;
				}
				
				String gamemode = args[1];
				if(args[1].equalsIgnoreCase("0")) gamemode = "SURVIVAL";
				else if(args[1].equalsIgnoreCase("1")) gamemode = "CREATIVE";
				else if(args[1].equalsIgnoreCase("2")) gamemode = "SPECTATOR";
				else if(args[1].equalsIgnoreCase("3")) gamemode = "ADVENTURE";
				
				try {
					t.setGameMode(GameMode.valueOf(gamemode.toUpperCase()));
					t.sendMessage(ChatColor.GRAY + "Gamemode changed to " + ChatColor.YELLOW + gamemode + ChatColor.GRAY + "!");
					p.sendMessage(ChatColor.BLUE + t.getName() + ChatColor.GRAY + "'s Gamemode changed to " + ChatColor.YELLOW + gamemode + ChatColor.GRAY + "!");
					return true;
				} catch(Exception e) {
					e.printStackTrace();
					p.sendMessage(ChatColor.RED + "Wrong gamemode!");
					return true;
				}
			}
			
			String gamemode = args[0];
			if(args[0].equalsIgnoreCase("0")) gamemode = "SURVIVAL";
			else if(args[0].equalsIgnoreCase("1")) gamemode = "CREATIVE";
			else if(args[0].equalsIgnoreCase("2")) gamemode = "SPECTATOR";
			else if(args[0].equalsIgnoreCase("3")) gamemode = "ADVENTURE";
			
			try {
				p.setGameMode(GameMode.valueOf(gamemode.toUpperCase()));
				p.sendMessage(ChatColor.GRAY + "Gamemode changed to " + ChatColor.YELLOW + gamemode + ChatColor.GRAY + "!");
				return true;
			} catch(Exception e) {
				e.printStackTrace();
				p.sendMessage(ChatColor.RED + "Wrong gamemode!");
				return true;
			}
		}
		return true;
	}
}
