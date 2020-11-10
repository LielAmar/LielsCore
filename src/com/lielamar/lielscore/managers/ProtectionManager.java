package com.lielamar.lielscore.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;

import com.lielamar.lielscore.Main;

public class ProtectionManager {

	private Main main;
	
	private List<UUID> bypass;
	
	private boolean canPlayersBeDamaged;
	private boolean canPlayersPvP;
	private boolean canPlayersReceiveFallDamage;
	private boolean canPlayersRegen;
	private boolean canPlayersInteract;
	private boolean canPlayersHungerChange;
	private boolean canPlayersBreakBlocks;
	private boolean canPlayersPlaceBlocks;
	private boolean canPlayersDropItems;
	private boolean canPlayersPickupItems;
	private boolean canPlayersKeepInventory;
	private boolean canMobsSpawn;
	private boolean canAnimalsSpawn;
	private boolean canWeatherChange;
	private boolean canWaterDamagePlayers;
	
	public ProtectionManager(Main main) {
		this.main = main;
		
		this.bypass = new ArrayList<UUID>();
		
		FileConfiguration config = getMain().getConfig();
		
		this.canPlayersBeDamaged = config.getBoolean("ProtectionSettings.CanPlayersBeDamaged");
		this.canPlayersPvP = config.getBoolean("ProtectionSettings.CanPlayersPvP");
		this.canPlayersReceiveFallDamage = config.getBoolean("ProtectionSettings.CanPlayersReceiveFallDamage");
		this.canPlayersRegen = config.getBoolean("ProtectionSettings.CanPlayersRegen");
		this.canPlayersInteract = config.getBoolean("ProtectionSettings.CanPlayersInteract");
		this.canPlayersHungerChange = config.getBoolean("ProtectionSettings.CanPlayersHungerChange");
		this.canPlayersBreakBlocks = config.getBoolean("ProtectionSettings.CanPlayersBreakBlocks");
		this.canPlayersPlaceBlocks = config.getBoolean("ProtectionSettings.CanPlayersPlaceBlocks");
		this.canPlayersDropItems = config.getBoolean("ProtectionSettings.CanPlayersDropItems");
		this.canPlayersPickupItems = config.getBoolean("ProtectionSettings.CanPlayersPickupItems");
		this.canPlayersKeepInventory = config.getBoolean("ProtectionSettings.CanPlayersKeepInventory");
		this.canMobsSpawn = config.getBoolean("ProtectionSettings.CanMobsSpawn");
		this.canAnimalsSpawn = config.getBoolean("ProtectionSettings.CanAnimalsSpawn");
		this.canWeatherChange = config.getBoolean("ProtectionSettings.CanWeatherChange");
		this.canWaterDamagePlayers = config.getBoolean("ProtectionSettings.CanWaterDamagePlayers");
	}

	private Main getMain() {
		return this.main;
	}

	public List<UUID> getBypass() {
		return bypass;
	}

	public void setBypass(List<UUID> bypass) {
		this.bypass = bypass;
	}

	public boolean isCanPlayersBeDamaged() {
		return canPlayersBeDamaged;
	}

	public void setCanPlayersBeDamaged(boolean canPlayersBeDamaged) {
		this.canPlayersBeDamaged = canPlayersBeDamaged;
	}

	public boolean isCanPlayersPvP() {
		return canPlayersPvP;
	}

	public void setCanPlayersPvP(boolean canPlayersPvP) {
		this.canPlayersPvP = canPlayersPvP;
	}

	public boolean isCanPlayersReceiveFallDamage() {
		return canPlayersReceiveFallDamage;
	}

	public void setCanPlayersReceiveFallDamage(boolean canPlayersReceiveFallDamage) {
		this.canPlayersReceiveFallDamage = canPlayersReceiveFallDamage;
	}
	
	public boolean isCanPlayersRegen() {
		return canPlayersRegen;
	}

	public void setCanPlayersRegen(boolean canPlayersRegen) {
		this.canPlayersRegen = canPlayersRegen;
	}

	public boolean isCanPlayersInteract() {
		return canPlayersInteract;
	}

	public void setCanPlayersInteract(boolean canPlayersInteract) {
		this.canPlayersInteract = canPlayersInteract;
	}

	public boolean isCanPlayersHungerChange() {
		return canPlayersHungerChange;
	}

	public void setCanPlayersHungerChange(boolean canPlayersHungerChange) {
		this.canPlayersHungerChange = canPlayersHungerChange;
	}

	public boolean isCanPlayersBreakBlocks() {
		return canPlayersBreakBlocks;
	}

	public void setCanPlayersBreakBlocks(boolean canPlayersBreakBlocks) {
		this.canPlayersBreakBlocks = canPlayersBreakBlocks;
	}

	public boolean isCanPlayersPlaceBlocks() {
		return canPlayersPlaceBlocks;
	}

	public void setCanPlayersPlaceBlocks(boolean canPlayersPlaceBlocks) {
		this.canPlayersPlaceBlocks = canPlayersPlaceBlocks;
	}

	public boolean isCanPlayersDropItems() {
		return canPlayersDropItems;
	}

	public void setCanPlayersDropItems(boolean canPlayersDropItems) {
		this.canPlayersDropItems = canPlayersDropItems;
	}

	public boolean isCanPlayersPickupItems() {
		return canPlayersPickupItems;
	}

	public void setCanPlayersPickupItems(boolean canPlayersPickupItems) {
		this.canPlayersPickupItems = canPlayersPickupItems;
	}
	
	public boolean isCanPlayersKeepInventory() {
		return canPlayersKeepInventory;
	}

	public void setCanPlayersKeepInventory(boolean canPlayersKeepInventory) {
		this.canPlayersKeepInventory = canPlayersKeepInventory;
	}

	public boolean isCanMobsSpawn() {
		return canMobsSpawn;
	}

	public void setCanMobsSpawn(boolean canMobsSpawn) {
		this.canMobsSpawn = canMobsSpawn;
	}

	public boolean isCanAnimalsSpawn() {
		return canAnimalsSpawn;
	}

	public void setCanAnimalsSpawn(boolean canAnimalsSpawn) {
		this.canAnimalsSpawn = canAnimalsSpawn;
	}

	public boolean isCanWeatherChange() {
		return canWeatherChange;
	}

	public void setCanWeatherChange(boolean canWeatherChange) {
		this.canWeatherChange = canWeatherChange;
	}

	public boolean isCanWaterDamagePlayers() {
		return canWaterDamagePlayers;
	}

	public void setCanWaterDamagePlayers(boolean canWaterDamagePlayers) {
		this.canWaterDamagePlayers = canWaterDamagePlayers;
	}
}
