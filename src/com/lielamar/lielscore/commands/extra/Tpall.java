package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

import net.md_5.bungee.api.ChatColor;

public class Tpall implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.tpall")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("tpall")) {
			for(Player pl : Bukkit.getOnlinePlayers()) {
				if(pl != (Player)cs)
					pl.teleport((Player)cs);
			}
			cs.sendMessage(ChatColor.GRAY + "Teleported everyone to you!");
			return true;
		}
		return true;
	}
}
