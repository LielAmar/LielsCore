package com.lielamar.lielscore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.lielamar.lielscore.Main;

import net.md_5.bungee.api.ChatColor;

public class PingEvents implements Listener {

	private Main main;
	
	public PingEvents(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMotd(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ServerMotd")));
	}
}