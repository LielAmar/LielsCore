package com.lielamar.lielscore.listeners.coresettings;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class OnProtectionSettingsGUI implements Listener {

	private Main main;
	
	public OnProtectionSettingsGUI(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() == null) return;
		if(e.getCurrentItem() == null) return;
		if(e.getClickedInventory() == null) return;
		if(e.getInventory() == null) return;
		
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equalsIgnoreCase(main.getCoreHandler().getGUI("protectionsettings").getTitle())) {
			
			if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersDamage())) {
				boolean value = !main.getProtectionManager().isCanPlayersBeDamaged();
				
				main.getProtectionManager().setCanPlayersBeDamaged(value);
				main.getConfig().set("ProtectionSettings.CanPlayersBeDamaged", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Be Damaged", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersPvP())) {
				boolean value = !main.getProtectionManager().isCanPlayersPvP();
				
				main.getProtectionManager().setCanPlayersPvP(value);
				main.getConfig().set("ProtectionSettings.CanPlayersPvP", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players PvP", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersFallDamage())) {
				boolean value = !main.getProtectionManager().isCanPlayersReceiveFallDamage();
				
				main.getProtectionManager().setCanPlayersReceiveFallDamage(value);
				main.getConfig().set("ProtectionSettings.CanPlayersReceiveFallDamage", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Receive Fall Damage", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersRegen())) {
				boolean value = !main.getProtectionManager().isCanPlayersRegen();
				
				main.getProtectionManager().setCanPlayersRegen(value);
				main.getConfig().set("ProtectionSettings.CanPlayersRegen", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Regenerate Health", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersInteract())) {
				boolean value = !main.getProtectionManager().isCanPlayersInteract();
				
				main.getProtectionManager().setCanPlayersInteract(value);
				main.getConfig().set("ProtectionSettings.CanPlayersInteract", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Interact", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				
				// ALSO SETTING BUILD
				if(!value) {
					main.getProtectionManager().setCanPlayersBreakBlocks(value);
					main.getConfig().set("ProtectionSettings.CanPlayersBreakBlocks", value);
					main.saveConfig();
					
					p.sendMessage(Messages.changedSetting("Can Players Break Blocks", String.valueOf(value)));
					e.setCancelled(true);
					p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
					
					main.getProtectionManager().setCanPlayersPlaceBlocks(value);
					main.getConfig().set("ProtectionSettings.CanPlayersPlaceBlocks", value);
					main.saveConfig();
					
					p.sendMessage(Messages.changedSetting("Can Players Place Blocks", String.valueOf(value)));
					e.setCancelled(true);
					p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				}
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersHunger())) {
				boolean value = !main.getProtectionManager().isCanPlayersHungerChange();
				
				main.getProtectionManager().setCanPlayersHungerChange(value);
				main.getConfig().set("ProtectionSettings.CanPlayersHungerChange", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players' Hunger Change", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersBreak())) {
				boolean value = !main.getProtectionManager().isCanPlayersBreakBlocks();
				
				main.getProtectionManager().setCanPlayersBreakBlocks(value);
				main.getConfig().set("ProtectionSettings.CanPlayersBreakBlocks", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Break Blocks", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));

				// ALSO SETTING INTERACT
				if(value) {
					main.getProtectionManager().setCanPlayersInteract(value);
					main.getConfig().set("ProtectionSettings.CanPlayersInteract", value);
					main.saveConfig();
					
					p.sendMessage(Messages.changedSetting("Can Players Interact", String.valueOf(value)));
					e.setCancelled(true);
					p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				}
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersPlace())) {
				boolean value = !main.getProtectionManager().isCanPlayersPlaceBlocks();
				
				main.getProtectionManager().setCanPlayersPlaceBlocks(value);
				main.getConfig().set("ProtectionSettings.CanPlayersPlaceBlocks", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Place Blocks", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				
				// ALSO SETTING INTERACT
				if(value) {
					main.getProtectionManager().setCanPlayersInteract(value);
					main.getConfig().set("ProtectionSettings.CanPlayersInteract", value);
					main.saveConfig();
					
					p.sendMessage(Messages.changedSetting("Can Players Interact", String.valueOf(value)));
					e.setCancelled(true);
					p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				}
				
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersDrop())) {
				boolean value = !main.getProtectionManager().isCanPlayersDropItems();
				
				main.getProtectionManager().setCanPlayersDropItems(value);
				main.getConfig().set("ProtectionSettings.CanPlayersDropItems", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Drop Items", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersPickup())) {
				boolean value = !main.getProtectionManager().isCanPlayersPickupItems();
				
				main.getProtectionManager().setCanPlayersPickupItems(value);
				main.getConfig().set("ProtectionSettings.CanPlayersPickupItems", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Pickup Items", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getPlayersKeepInventory())) {
				boolean value = !main.getProtectionManager().isCanPlayersKeepInventory();
				
				main.getProtectionManager().setCanPlayersKeepInventory(value);
				main.getConfig().set("ProtectionSettings.CanPlayersKeepInventory", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Players Keep Inventory", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getMobsSpawn())) {
				boolean value = !main.getProtectionManager().isCanMobsSpawn();
				
				main.getProtectionManager().setCanMobsSpawn(value);
				main.getConfig().set("ProtectionSettings.CanMobsSpawn", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Mobs Spawn", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getAnimalsSpawn())) {
				boolean value = !main.getProtectionManager().isCanAnimalsSpawn();
				
				main.getProtectionManager().setCanAnimalsSpawn(value);
				main.getConfig().set("ProtectionSettings.CanAnimalsSpawn", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Animals Spawn", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getWeatherChange())) {
				boolean value = !main.getProtectionManager().isCanWeatherChange();
				
				main.getProtectionManager().setCanWeatherChange(value);
				main.getConfig().set("ProtectionSettings.CanWeatherChange", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Weather Change", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getWaterDamage())) {
				boolean value = !main.getProtectionManager().isCanWaterDamagePlayers();
				
				main.getProtectionManager().setCanWaterDamagePlayers(value);
				main.getConfig().set("ProtectionSettings.CanWaterDamagePlayers", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Can Water Damage Players", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("protectionsettings"));
				return;
			} else {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
		}
	}
}
