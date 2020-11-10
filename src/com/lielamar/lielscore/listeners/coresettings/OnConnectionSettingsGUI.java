package com.lielamar.lielscore.listeners.coresettings;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class OnConnectionSettingsGUI implements Listener {

	private Main main;

	public OnConnectionSettingsGUI(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() == null) return;
		if(e.getCurrentItem() == null) return;
		if(e.getClickedInventory() == null) return;
		if(e.getInventory() == null) return;
		
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equalsIgnoreCase(main.getCoreHandler().getGUI("connectionsettings").getTitle())) {
			
			if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getEnableConnectionSettings())) {
				boolean value = !main.getConnectionManager().isEnabled();
				
				main.getConnectionManager().setEnabled(value);
				main.getConfig().set("ConnectionSettings.enabled", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection Settings Enabled", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getClearInv())) {
					boolean value = !main.getConnectionManager().isClearinv();
					
					main.getConnectionManager().setClearinv(value);
					main.getConfig().set("ConnectionSettings.clearinv", value);
					main.saveConfig();
					
					p.sendMessage(Messages.changedSetting("Connection ClearInv Enabled", String.valueOf(value)));
					e.setCancelled(true);
					p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
					return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getClearPots())) {
				boolean value = !main.getConnectionManager().isClearpots();
				
				main.getConnectionManager().setClearpots(value);
				main.getConfig().set("ConnectionSettings.clearpots", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection ClearPots Enabled", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getHealth())) {
				int value = main.getConnectionManager().getHealthOnJoin();
				
				if(!e.isRightClick())
					value++;
				else
					value--;
				
				if(value < 0)
					value = 0;
				
				if(value > 20)
					value = 20;
				
				main.getConnectionManager().setHealthOnJoin(value);
				main.getConfig().set("ConnectionSettings.health", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection Health", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getHunger())) {
				int value = main.getConnectionManager().getHungerOnJoin();
				
				if(!e.isRightClick())
					value++;
				else
					value--;
				
				if(value < 0)
					value = 0;
				
				if(value > 20)
					value = 20;
				
				main.getConnectionManager().setHungerOnJoin(value);
				main.getConfig().set("ConnectionSettings.hunger", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection Hunger", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getExp())) {
				int value = main.getConnectionManager().getExpOnJoin();
				
				if(!e.isRightClick())
					value++;
				else
					value--;
				
				if(value < 0)
					value = 0;
				
				main.getConnectionManager().setExpOnJoin(value);
				main.getConfig().set("ConnectionSettings.exp", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection Exp", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getLevel())) {
				int value = main.getConnectionManager().getLevelOnJoin();
				
				if(!e.isRightClick())
					value++;
				else
					value--;
				
				if(value < 0)
					value = 0;
				
				main.getConnectionManager().setLevelOnJoin(value);
				main.getConfig().set("ConnectionSettings.level", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection Level", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getGamemode())) {
				GameMode value = main.getConnectionManager().getGamemodeOnJoin();
				
				if(value == GameMode.SURVIVAL) value = GameMode.CREATIVE;
				else if(value == GameMode.CREATIVE) value = GameMode.SPECTATOR;
				else if(value == GameMode.SPECTATOR) value = GameMode.ADVENTURE;
				else if(value == GameMode.ADVENTURE) value = GameMode.SURVIVAL;
				
				main.getConnectionManager().setGamemodeOnJoin(value);
				main.getConfig().set("ConnectionSettings.gamemode", value.toString());
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection GameMode", String.valueOf(value.toString())));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("connectionsettings"));
				return;
			} else {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
		}
	}
}
