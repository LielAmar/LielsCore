package com.lielamar.lielscore.commands.extra;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class Vanish implements CommandExecutor {
	
	private List<UUID> players;
	
	public Vanish() {
		this.players = new ArrayList<UUID>();
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.vanish")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("vanish")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				if(players.contains(p.getUniqueId())) {
					players.remove(p.getUniqueId());
					
					for(Player pl : Bukkit.getOnlinePlayers())
						pl.showPlayer(p);
					
					p.sendMessage(ChatColor.GRAY + "Vanish " + ChatColor.RED + "disabled" + ChatColor.GRAY + "!");
					return true;
				} else {
					players.add(p.getUniqueId());
					
					for(Player pl : Bukkit.getOnlinePlayers()) {
						if(pl.hasPermission("lielscore.commands.vanish.see")) continue;
						pl.showPlayer(p);
					}
					
					p.sendMessage(ChatColor.GRAY + "Vanish " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
					return true;
				}
			}

			Player t = Bukkit.getPlayer(args[0]);
				
			if(t == null) {
				cs.sendMessage(Messages.playerNotFound(args[0]));
				return true;
			}
				
			if(!cs.hasPermission("lielscore.commands.vanish.others")) {
				cs.sendMessage(Messages.noPermissions);
				return true;
			}
			
			
			if(players.contains(t.getUniqueId())) {
				players.remove(t.getUniqueId());
				
				for(Player pl : Bukkit.getOnlinePlayers())
					pl.showPlayer(t);
				
				t.sendMessage(ChatColor.GRAY + "Vanish " + ChatColor.RED + "disabled" + ChatColor.GRAY + "!");
				p.sendMessage(ChatColor.RED + "Disabled " + ChatColor.GRAY + "vanish for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
				return true;
			} else {
				players.add(t.getUniqueId());
				
				for(Player pl : Bukkit.getOnlinePlayers()) {
					if(pl.hasPermission("lielscore.commands.vanish.see")) continue;
					pl.showPlayer(t);
				}
				
				t.sendMessage(ChatColor.GRAY + "Vanish " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
				p.sendMessage(ChatColor.GREEN + "Enabled " + ChatColor.GRAY + "vanish for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
				return true;
			}
		}
		return true;
	}
}
