package com.lielamar.lielscore.listeners.coresettings;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.lielamar.lielscore.Main;

public class OnMainGUI implements Listener {

	private Main main;
	
	public OnMainGUI(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() == null) return;
		if(e.getCurrentItem() == null) return;
		if(e.getClickedInventory() == null) return;
		if(e.getInventory() == null) return;
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase(main.getCoreHandler().getGUI("main").getTitle())) {
			if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getSpawnSettings())) {
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				e.setCancelled(true);
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getProtectionSettings())) {
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				e.setCancelled(true);
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getConnectionSettings())) {
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				e.setCancelled(true);
				return;
			} else {
				e.setCancelled(true);
				return;
			}
		}
	}
}
