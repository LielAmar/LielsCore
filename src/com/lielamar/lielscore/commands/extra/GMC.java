package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class GMC implements CommandExecutor {
	
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
	
		if(cmd.getName().equalsIgnoreCase("gmc")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(ChatColor.GRAY + "Gamemode changed to " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + "!");
				return true;
			}

			Player t = Bukkit.getPlayer(args[0]);
				
			if(t == null) {
				cs.sendMessage(Messages.playerNotFound(args[0]));
				return true;
			}
				
			if(!cs.hasPermission("lielscore.commands.gamemode.others")) {
				cs.sendMessage(Messages.noPermissions);
				return true;
			}
			
			t.setGameMode(GameMode.CREATIVE);
			t.sendMessage(ChatColor.GRAY + "Gamemode changed to " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + "!");
			p.sendMessage(ChatColor.BLUE + t.getName() + ChatColor.GRAY + "'s Gamemode changed to " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + "!");
			return true;
		}
		return true;
	}
}
