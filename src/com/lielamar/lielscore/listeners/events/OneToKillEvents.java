package com.lielamar.lielscore.listeners.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OneToKillEvents implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getItem() == null)
			return;

		Player p = e.getPlayer();
		if (p.getItemInHand() == null)
			return;
		
		ItemStack i = p.getItemInHand();
		if (i.getType() != Material.COMPASS)
			return;
		
		if (!i.hasItemMeta() || !i.getItemMeta().hasDisplayName())
			return;
		if (i.getItemMeta().getDisplayName().split(" ").length != 2)
			return; // "Tracking[0] LielAmar[1]"
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player t = Bukkit.getPlayer(ChatColor.stripColor(i.getItemMeta().getDisplayName().split(" ")[1]));
			if (t == null)
				return;
			p.setCompassTarget(t.getLocation());
			p.sendMessage(ChatColor.YELLOW + "Now tracking " + ChatColor.AQUA + t.getName());
		} else if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			String name = ChatColor.stripColor(i.getItemMeta().getDisplayName().split(" ")[1]);
			if (name.equalsIgnoreCase("lielamar"))
				name = "lonelywolf1";
			else
				name = "lielamar";
			Player t = Bukkit.getPlayer(name);
			if (t == null)
				return;
			
			String compassname = ChatColor.GRAY + "Tracking " + ChatColor.YELLOW + t.getName();
			ItemMeta meta = p.getItemInHand().getItemMeta();
			meta.setDisplayName(compassname);
			p.getItemInHand().setItemMeta(meta);
			
			p.setCompassTarget(t.getLocation());
			p.sendMessage(ChatColor.YELLOW + "Now tracking " + ChatColor.AQUA + t.getName());
		} else
			return;
	}
}
