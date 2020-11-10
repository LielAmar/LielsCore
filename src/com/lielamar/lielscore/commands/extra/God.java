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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.lielamar.lielscore.utils.Messages;

public class God implements CommandExecutor, Listener {
	
	private List<UUID> players;
	
	public God() {
		this.players = new ArrayList<UUID>();
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.god")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("god")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				if(players.contains(p.getUniqueId())) {
					players.remove(p.getUniqueId());
					p.sendMessage(ChatColor.GRAY + "Godmod " + ChatColor.RED + "disabled" + ChatColor.GRAY + "!");
					return true;
				} else {
					players.add(p.getUniqueId());
					p.sendMessage(ChatColor.GRAY + "Godmod " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
					return true;
				}
			}

			Player t = Bukkit.getPlayer(args[0]);
				
			if(t == null) {
				cs.sendMessage(Messages.playerNotFound(args[0]));
				return true;
			}
				
			if(!cs.hasPermission("lielscore.commands.god.others")) {
				cs.sendMessage(Messages.noPermissions);
				return true;
			}
			
			if(players.contains(t.getUniqueId())) {
				players.remove(t.getUniqueId());
				t.sendMessage(ChatColor.GRAY + "Godmod " + ChatColor.RED + "disabled" + ChatColor.GRAY + "!");
				p.sendMessage(ChatColor.RED + "Disabled " + ChatColor.GRAY + "god for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
				return true;
			} else {
				players.add(t.getUniqueId());
				t.sendMessage(ChatColor.GRAY + "Godmod " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
				p.sendMessage(ChatColor.GREEN + "Enabled " + ChatColor.GRAY + "god for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
				return true;
			}
		}
		return true;
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		
		if(players.contains(((Player)e.getEntity()).getUniqueId()))
			e.setCancelled(true);
	}
}