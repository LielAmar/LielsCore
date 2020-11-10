package com.lielamar.lielscore.commands.coresettings;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import com.lielamar.lielscore.Main;

public class CoreSettingsHandler {

	private Main main;

	private CoreSettingsItems items;
	
	public CoreSettingsHandler(Main main) {
		this.main = main;

		items = new CoreSettingsItems(getMain());
	}
	
	private Main getMain() {
		return this.main;
	}
	
	public CoreSettingsItems getItems() {
		return items;
	}
	
	public Inventory getGUI(String value) {
		Inventory inv = null;
		items.loadItems();
		if(value.equalsIgnoreCase("main")) {
			inv = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Core Settings");
			inv.setItem(10, items.getSpawnSettings());
			inv.setItem(11, items.getProtectionSettings());
			inv.setItem(12, items.getConnectionSettings());
		} else if(value.equalsIgnoreCase("spawnsettings")) {
			inv = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Spawn Settings");
			inv.setItem(10, items.getEnableSpawn());
			inv.setItem(11, items.getSetSpawn());
			inv.setItem(12, items.getFirstJoin());
			inv.setItem(13, items.getEveryJoin());
			inv.setItem(14, items.getRespawn());
			inv.setItem(15, items.getVoidtp());
			inv.setItem(16, items.getConnectionsettingsonspawncmd());
		} else if(value.equalsIgnoreCase("protectionsettings")) {
			inv = Bukkit.createInventory(null, 45, ChatColor.DARK_GRAY + "Protection Settings");
			inv.setItem(10, items.getPlayersDamage());
			inv.setItem(11, items.getPlayersPvP());
			inv.setItem(12, items.getPlayersFallDamage());
			inv.setItem(13, items.getPlayersRegen());
			inv.setItem(14, items.getPlayersInteract());
			inv.setItem(15, items.getPlayersHunger());
			inv.setItem(16, items.getPlayersBreak());
			inv.setItem(19, items.getPlayersPlace());
			inv.setItem(20, items.getPlayersDrop());
			inv.setItem(21, items.getPlayersPickup());
			inv.setItem(22, items.getPlayersKeepInventory());
			inv.setItem(23, items.getMobsSpawn());
			inv.setItem(24, items.getAnimalsSpawn());
			inv.setItem(25, items.getWeatherChange());
			inv.setItem(28, items.getWaterDamage());
		} else if(value.equalsIgnoreCase("connectionsettings")) {
			inv = Bukkit.createInventory(null, 36, ChatColor.DARK_GRAY + "Connection Settings");
			inv.setItem(10, items.getEnableConnectionSettings());
			inv.setItem(11, items.getClearInv());
			inv.setItem(12, items.getClearPots());
			inv.setItem(13, items.getHealth());
			inv.setItem(14, items.getHunger());
			inv.setItem(15, items.getExp());
			inv.setItem(16, items.getLevel());
			inv.setItem(19, items.getGamemode());
		}
		
		return inv;
	}
}