package com.lielamar.lielscore.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import com.lielamar.lielscore.Main;

public class SpawnManager {

	private Main main;
	
	private Location spawn;
	
	private boolean teleportToSpawnOnFirstJoin;
	private boolean teleportToSpawnOnEveryJoin;
	private boolean teleportToSpawnOnRespawn;
	private boolean teleportToSpawnOnVoid;
	private boolean connectionSettingsOnSpawnCommand;
	
	public SpawnManager(Main main) {
		this.main = main;
		
		FileConfiguration config = getMain().getConfig();
		if(!config.getBoolean("Spawn.enabled"))
			spawn = null;
		else {
			try {
				this.spawn = new Location(
						Bukkit.getWorld(config.getString("Spawn.world")),
						config.getDouble("Spawn.x"),
						config.getDouble("Spawn.y"),
						config.getDouble("Spawn.z"),
						config.getLong("Spawn.yaw"),
						config.getLong("Spawn.pitch"));
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("[Liel's Core] Couldn't load the spawn from config.yml. Please make sure all of the information is valid!");
			}
		}
		
		this.teleportToSpawnOnFirstJoin = config.getBoolean("SpawnSettings.TeleportOnFirstJoin");
		this.teleportToSpawnOnEveryJoin = config.getBoolean("SpawnSettings.TeleportOnEveryJoin");
		this.teleportToSpawnOnRespawn = config.getBoolean("SpawnSettings.TeleportOnRespawn");
		this.teleportToSpawnOnVoid = config.getBoolean("SpawnSettings.TeleportOnVoid");
		this.connectionSettingsOnSpawnCommand = config.getBoolean("SpawnSettings.ConnectionSettingsOnSpawnCommand");
	}
	
	private Main getMain() {
		return this.main;
	}

	public Location getSpawn() {
		return this.spawn;
	}

	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}

	public boolean isTeleportToSpawnOnFirstJoin() {
		return this.teleportToSpawnOnFirstJoin;
	}

	public void setTeleportToSpawnOnFirstJoin(boolean teleportToSpawnOnFirstJoin) {
		this.teleportToSpawnOnFirstJoin = teleportToSpawnOnFirstJoin;
	}

	public boolean isTeleportToSpawnOnEveryJoin() {
		return this.teleportToSpawnOnEveryJoin;
	}

	public void setTeleportToSpawnOnEveryJoin(boolean teleportToSpawnOnEveryJoin) {
		this.teleportToSpawnOnEveryJoin = teleportToSpawnOnEveryJoin;
	}

	public boolean isTeleportToSpawnOnRespawn() {
		return this.teleportToSpawnOnRespawn;
	}

	public void setTeleportToSpawnOnRespawn(boolean teleportToSpawnOnRespawn) {
		this.teleportToSpawnOnRespawn = teleportToSpawnOnRespawn;
	}

	public boolean isTeleportToSpawnOnVoid() {
		return this.teleportToSpawnOnVoid;
	}

	public void setTeleportToSpawnOnVoid(boolean teleportToSpawnOnVoid) {
		this.teleportToSpawnOnVoid = teleportToSpawnOnVoid;
	}

	public boolean isConnectionSettingsOnSpawnCommand() {
		return connectionSettingsOnSpawnCommand;
	}

	public void setConnectionSettingsOnSpawnCommand(boolean connectionSettingsOnSpawnCommand) {
		this.connectionSettingsOnSpawnCommand = connectionSettingsOnSpawnCommand;
	}
}
