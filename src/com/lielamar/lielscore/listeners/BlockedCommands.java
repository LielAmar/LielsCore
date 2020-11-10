package com.lielamar.lielscore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.lielamar.lielscore.utils.Messages;

public class BlockedCommands implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if(!e.getMessage().startsWith("/")) return;
		
		Player p = e.getPlayer();
		if(p.hasPermission("lielscore.bypass")) return;
		
		String msg = e.getMessage().toLowerCase();
		if(msg.contains("/pl") || msg.contains("/plugins") || msg.contains("/bukkit:")) {
			e.getPlayer().sendMessage(Messages.noPermissions);
			e.setCancelled(true);
		}
	}
}
