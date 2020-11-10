package com.lielamar.lielscore.managers.packets;

import org.bukkit.entity.Player;

public interface PacketVersion {
	
	public void sendTitle(Player p, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime);
	
	public void sendActionBar(Player p, String message);
}
