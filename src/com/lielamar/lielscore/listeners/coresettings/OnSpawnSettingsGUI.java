package com.lielamar.lielscore.listeners.coresettings;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.commands.Spawn;
import com.lielamar.lielscore.utils.Messages;

public class OnSpawnSettingsGUI implements Listener {

	private Main main;
	
	public OnSpawnSettingsGUI(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() == null) return;
		if(e.getCurrentItem() == null) return;
		if(e.getClickedInventory() == null) return;
		if(e.getInventory() == null) return;
		
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equalsIgnoreCase(main.getCoreHandler().getGUI("spawnsettings").getTitle())) {
			if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getEnableSpawn())) {
				
				if(main.getSpawnManager().getSpawn() == null) {
					setSpawn(p.getLocation());
					p.sendMessage(Messages.spawnSetToYourLocation);
				} else {
					setSpawn(null);
					p.sendMessage(Messages.disabledLielsCoreSpawnSystem);
				}
				
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getSetSpawn())) {
				setSpawn(p.getLocation());
				p.sendMessage(Messages.spawnSetToYourLocation);
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				main.getCoreHandler().getItems().setSetSpawn();
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getFirstJoin())) {
				boolean value = !main.getSpawnManager().isTeleportToSpawnOnFirstJoin();
				
				main.getSpawnManager().setTeleportToSpawnOnFirstJoin(value);
				main.getConfig().set("SpawnSettings.TeleportOnFirstJoin", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Teleport On First Join", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getEveryJoin())) {
				boolean value = !main.getSpawnManager().isTeleportToSpawnOnEveryJoin();
				
				main.getSpawnManager().setTeleportToSpawnOnEveryJoin(value);
				main.getConfig().set("SpawnSettings.TeleportOnEveryJoin", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Teleport On Every Join", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getRespawn())) {
				boolean value = !main.getSpawnManager().isTeleportToSpawnOnRespawn();
				
				main.getSpawnManager().setTeleportToSpawnOnRespawn(value);
				main.getConfig().set("SpawnSettings.TeleportOnRespawn", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Teleport On Respawn", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getVoidtp())) {
				boolean value = !main.getSpawnManager().isTeleportToSpawnOnVoid();
				
				main.getSpawnManager().setTeleportToSpawnOnVoid(value);
				main.getConfig().set("SpawnSettings.TeleportOnVoid", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Teleport On Void", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				return;
			} else if(e.getCurrentItem().equals(main.getCoreHandler().getItems().getConnectionsettingsonspawncmd())) {
				boolean value = !main.getSpawnManager().isConnectionSettingsOnSpawnCommand();
				
				main.getSpawnManager().setConnectionSettingsOnSpawnCommand(value);
				main.getConfig().set("SpawnSettings.ConnectionSettingsOnSpawnCommand", value);
				main.saveConfig();
				
				p.sendMessage(Messages.changedSetting("Connection Settings On Spawn Command", String.valueOf(value)));
				e.setCancelled(true);
				p.openInventory(main.getCoreHandler().getGUI("spawnsettings"));
				return;
			} else {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
		}
	}
	
	public void setSpawn(Location loc) {
		if(loc != null) {
			
			if(main.getCommand("spawn").getExecutor() == null) {
				main.getCommand("spawn").setExecutor(new Spawn(main));
			}
			
			main.getSpawnManager().setSpawn(loc);
			main.getConfig().set("Spawn.enabled", true);
			main.getConfig().set("Spawn.x", loc.getX());
			main.getConfig().set("Spawn.y", loc.getY());
			main.getConfig().set("Spawn.z", loc.getZ());
			main.getConfig().set("Spawn.yaw", loc.getYaw());
			main.getConfig().set("Spawn.pitch", loc.getPitch());
			main.getConfig().set("Spawn.world", loc.getWorld().getName().toString());
			main.saveConfig();
		} else {
			main.getSpawnManager().setSpawn(loc);
			main.getConfig().set("Spawn.enabled", false);
			main.saveConfig();
		}
	}
}
