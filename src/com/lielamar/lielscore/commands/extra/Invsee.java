package com.lielamar.lielscore.commands.extra;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.lielamar.lielscore.utils.Messages;

public class Invsee implements CommandExecutor, Listener {
	
	private Map<UUID, Inventory> players;
	
	public Invsee() {
		this.players = new HashMap<UUID, Inventory>();
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.invsee")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("invsee")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				p.sendMessage(Messages.wrongUsage("Invsee", "<Player>"));
				return true;
			}

			Player t = Bukkit.getPlayer(args[0]);
				
			if(t == null) {
				cs.sendMessage(Messages.playerNotFound(args[0]));
				return true;
			}
			
			p.openInventory(t.getInventory());
			this.players.put(p.getUniqueId(), t.getInventory());
			return true;
		}
		return true;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() == null) return;
		if(e.getCurrentItem() == null) return;
		if(e.getClickedInventory() == null) return;
		if(e.getInventory() == null) return;
		
		Player p = (Player) e.getWhoClicked();
		
		if(!this.players.containsKey(p.getUniqueId())) return;
		
		if(e.getInventory().equals(this.players.get(p.getUniqueId()))) {
			if(!p.hasPermission("lielscore.commands.invsee.interact")) {
				e.setCancelled(true);
				return;
			}
		}
	}
}