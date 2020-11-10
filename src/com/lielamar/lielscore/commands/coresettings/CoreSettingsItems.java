package com.lielamar.lielscore.commands.coresettings;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Methods;

public class CoreSettingsItems {

	private Main main;
	
	private ItemStack spawnSettings, protectionSettings, connectionSettings;
	private ItemStack enableSpawn, setSpawn, firstJoin, everyJoin, respawn, voidtp, connectionsettingsonspawncmd;
	private ItemStack playersDamage, playersPvP, playersFallDamage, playersRegen, playersInteract, playersHunger, playersBreak, playersPlace, playersDrop, playersPickup, playersKeepInventory, mobsSpawn, animalsSpawn, weatherChange, waterDamage;
	private ItemStack enableConnectionSettings, clearInv, clearPots, health, hunger, exp, level, gamemode;
	
	int id;
	
	public CoreSettingsItems(Main main) {
		this.main = main;
		this.id = 8;
		
		loadItems();
	}
	
	public Main getMain() {
		return main;
	}

	public ItemStack getSpawnSettings() {
		return spawnSettings;
	}

	public ItemStack getProtectionSettings() {
		return protectionSettings;
	}

	public ItemStack getConnectionSettings() {
		return connectionSettings;
	}

	public ItemStack getEnableSpawn() {
		return enableSpawn;
	}
	
	public ItemStack getSetSpawn() {
		return setSpawn;
	}

	public ItemStack getFirstJoin() {
		return firstJoin;
	}

	public ItemStack getEveryJoin() {
		return everyJoin;
	}

	public ItemStack getRespawn() {
		return respawn;
	}

	public ItemStack getVoidtp() {
		return voidtp;
	}

	public ItemStack getConnectionsettingsonspawncmd() {
		return connectionsettingsonspawncmd;
	}

	public ItemStack getPlayersDamage() {
		return playersDamage;
	}

	public ItemStack getPlayersPvP() {
		return playersPvP;
	}

	public ItemStack getPlayersFallDamage() {
		return playersFallDamage;
	}

	public ItemStack getPlayersRegen() {
		return playersRegen;
	}
	
	public ItemStack getPlayersInteract() {
		return playersInteract;
	}

	public ItemStack getPlayersHunger() {
		return playersHunger;
	}

	public ItemStack getPlayersBreak() {
		return playersBreak;
	}

	public ItemStack getPlayersPlace() {
		return playersPlace;
	}

	public ItemStack getPlayersDrop() {
		return playersDrop;
	}

	public ItemStack getPlayersPickup() {
		return playersPickup;
	}

	public ItemStack getPlayersKeepInventory() {
		return playersKeepInventory;
	}
	
	public ItemStack getMobsSpawn() {
		return mobsSpawn;
	}

	public ItemStack getAnimalsSpawn() {
		return animalsSpawn;
	}

	public ItemStack getWeatherChange() {
		return weatherChange;
	}

	public ItemStack getWaterDamage() {
		return waterDamage;
	}

	public ItemStack getEnableConnectionSettings() {
		return enableConnectionSettings;
	}

	public ItemStack getClearInv() {
		return clearInv;
	}

	public ItemStack getClearPots() {
		return clearPots;
	}

	public ItemStack getHealth() {
		return health;
	}

	public ItemStack getHunger() {
		return hunger;
	}

	public ItemStack getExp() {
		return exp;
	}

	public ItemStack getLevel() {
		return level;
	}

	public ItemStack getGamemode() {
		return gamemode;
	}
	
	public void setSpawnSettings() {
		spawnSettings = Methods.getItemStack(Material.REDSTONE_COMPARATOR, 1, ChatColor.YELLOW + "Spawn Settings", new String[] {
				"",
				ChatColor.GRAY + "Open the " + ChatColor.YELLOW + "Spawn Settings" + ChatColor.GRAY + " menu",
				""});		
	}

	public void setProtectionSettings() {
		protectionSettings = Methods.getItemStack(Material.DIAMOND_CHESTPLATE, 1, ChatColor.YELLOW + "Protection Settings", new String[] {
				"",
				ChatColor.GRAY + "Open the " + ChatColor.YELLOW + "Protection Settings" + ChatColor.GRAY + " menu",
				""});
	}

	public void setConnectionSettings() {
		connectionSettings = Methods.getItemStack(Material.NETHER_STAR, 1 ,ChatColor.YELLOW + "Connection Settings", new String[] {
				"",
				ChatColor.GRAY + "Open the " + ChatColor.YELLOW + "Connection Settings" + ChatColor.GRAY + " menu",
				""});
	}

	public void setEnableSpawn() {
		id = 8; // Gray
		if(main.getSpawnManager().getSpawn() != null)
			id = 10; // Green
		enableSpawn = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Enable Spawn", new String[] {
				"",
				ChatColor.GRAY + "Enable Liel's Core",
				ChatColor.YELLOW + "Spawn System",
				""});
	}
	
	public void setSetSpawn() {
		Location loc = null;
		if(main.getSpawnManager().getSpawn() != null)
			loc = main.getSpawnManager().getSpawn();
		
		if(loc == null)
			setSpawn = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Set Spawn", new String[] {
					"",
					ChatColor.GRAY + "Set the server's " + ChatColor.YELLOW + "Spawn",
					"",
					ChatColor.GRAY + "Current Spawn: " + ChatColor.YELLOW + "no spawn",
					""});
		else
			setSpawn = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Set Spawn", new String[] {
					"",
					ChatColor.GRAY + "Set the server's " + ChatColor.YELLOW + "Spawn",
					"",
					ChatColor.GRAY + "Current Spawn: " + ChatColor.YELLOW + loc.getWorld().getName().toString() + ", " + loc.getX() + ", " + loc.getY() + ", " + loc.getZ(),
					""});
	}

	public void setFirstJoin() {
		id = 8; // Gray
		if(main.getSpawnManager().isTeleportToSpawnOnFirstJoin())
			id = 10; // Green
		firstJoin = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "First Join Spawn", new String[] {
				"",
				ChatColor.GRAY + "Teleport to the Spawn on",
				ChatColor.GRAY + "players' " + ChatColor.YELLOW + "First Join",
				""});
	}

	public void setEveryJoin() {
		id = 8; // Gray
		if(main.getSpawnManager().isTeleportToSpawnOnEveryJoin())
			id = 10; // Green
		everyJoin = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Every Join Spawn", new String[] {
				"",
				ChatColor.GRAY + "Teleport to the Spawn on",
				ChatColor.GRAY + "players' " + ChatColor.YELLOW + "Every Join",
				""});
	}

	public void setRespawn() {
		id = 8; // Gray
		if(main.getSpawnManager().isTeleportToSpawnOnRespawn())
			id = 10; // Green
		respawn = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Respawn Spawn", new String[] {
				"",
				ChatColor.GRAY + "Teleport to the Spawn on",
				ChatColor.GRAY + "players' " + ChatColor.YELLOW + "Respawn",
				""});
	}

	public void setVoidtp() {
		id = 8; // Gray
		if(main.getSpawnManager().isTeleportToSpawnOnVoid())
			id = 10; // Green
		voidtp = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Void Spawn", new String[] {
				"",
				ChatColor.GRAY + "Teleport to the Spawn on",
				ChatColor.GRAY + "players' " + ChatColor.YELLOW + "Void",
				""});
	}

	public void setConnectionsettingsonspawncmd() {
		id = 8; // Gray
		if(main.getSpawnManager().isConnectionSettingsOnSpawnCommand())
			id = 10; // Green
		connectionsettingsonspawncmd = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Apply ConnectionSettings on Spawn Command", new String[] {
				"",
				ChatColor.GRAY + "Apply " + ChatColor.YELLOW + "Connection Settings",
				ChatColor.GRAY + "to players on /spawn",
				""});
	}

	public void setPlayersDamage() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersBeDamaged())
			id = 10; // Green
		playersDamage = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Receive Damaged", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players receive Damage",
				""});
	}

	public void setPlayersPvP() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersPvP())
			id = 10; // Green
		playersPvP = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players PvP", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players can PvP",
				""});
	}

	public void setPlayersFallDamage() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersReceiveFallDamage())
			id = 10; // Green
		playersFallDamage = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Receive Fall Damage", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players receive Fall-Damage",
				""});
	}
	
	public void setPlayersRegen() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersRegen())
			id = 10; // Green
		playersRegen = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Regenerate", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players can Regenerate health",
				""});
	}

	public void setPlayersInteract() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersInteract())
			id = 10; // Green
		playersInteract = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Interact", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players can Interact",
				""});
	}

	public void setPlayersHunger() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersHungerChange())
			id = 10; // Green
		playersHunger = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Hunger Change", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players' Hunger change",
				""});
	}

	public void setPlayersBreak() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersBreakBlocks())
			id = 10; // Green
		playersBreak = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Break Blocks", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players Break Blocks",
				""});
	}

	public void setPlayersPlace() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersPlaceBlocks())
			id = 10; // Green
		playersPlace = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Place Blocks", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players Place Blocks",
				""});
	}

	public void setPlayersDrop() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersDropItems())
			id = 10; // Green
		playersDrop = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Drop Items", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players Drop Items",
				""});
	}

	public void setPlayersPickup() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersPickupItems())
			id = 10; // Green
		playersPickup = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Pickup Items", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players Pickup Items",
				""});
	}
	
	public void setPlayersKeepInventory() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanPlayersKeepInventory())
			id = 10; // Green
		playersKeepInventory = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Players Keep Inventory", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Players Keep Inventory",
				""});
	}

	public void setMobsSpawn() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanMobsSpawn())
			id = 10; // Green
		mobsSpawn = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Mobs Spawn", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Mobs Spawn",
				""});
	}

	public void setAnimalsSpawn() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanAnimalsSpawn())
			id = 10; // Green
		animalsSpawn = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Animals Spawn", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Animals Spawn",
				""});
	}

	public void setWeatherChange() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanWeatherChange())
			id = 10; // Green
		weatherChange = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Weather Change", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Weather Changes",
				""});
	}

	public void setWaterDamage() {
		id = 8; // Gray
		if(main.getProtectionManager().isCanWaterDamagePlayers())
			id = 10; // Green
		waterDamage = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Water Damage Players", new String[] {
				"",
				ChatColor.GRAY + "Whether or not",
				ChatColor.YELLOW + "Water Damage Players",
				ChatColor.GRAY + "(Acts like lava)",
				""});
	}

	public void setEnableConnectionSettings() {
		id = 8; // Gray
		if(main.getConnectionManager().isEnabled())
			id = 10; // Green
		enableConnectionSettings = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Enable Connection Settings", new String[] {
				"",
				ChatColor.GRAY + "Whether or not to",
				ChatColor.YELLOW + "Enable Connection Settings",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				""});
	}

	public void setClearInv() {
		id = 8; // Gray
		if(main.getConnectionManager().isClearinv())
			id = 10; // Green
		clearInv = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Clear Inventory", new String[] {
				"",
				ChatColor.GRAY + "Whether or not to",
				ChatColor.YELLOW + "Clear Inventory",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				""});
	}

	public void setClearPots() {
		id = 8; // Gray
		if(main.getConnectionManager().isClearpots())
			id = 10; // Green
		clearPots = Methods.getItemStack(Material.INK_SACK, 1, (byte)id, ChatColor.YELLOW + "Clear Potion Effects", new String[] {
				"",
				ChatColor.GRAY + "Whether or not to",
				ChatColor.YELLOW + "Clear Potion Effects",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				""});
	}

	public void setHealth() {
		id = main.getConnectionManager().getHealthOnJoin();
		health = Methods.getItemStack(Material.INK_SACK, id, (byte)1, ChatColor.YELLOW + "Health", new String[] {
				"",
				ChatColor.GRAY + "What is the",
				ChatColor.YELLOW + "Health amount" + ChatColor.GRAY + " to set",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				"",
				ChatColor.GRAY + "Left click to " + ChatColor.GREEN + "increase",
				ChatColor.GRAY + "Right click to " + ChatColor.RED + "decrease",
				"",
				ChatColor.GRAY + "Value: " + ChatColor.YELLOW + id,
				""});
	}

	public void setHunger() {
		id = main.getConnectionManager().getHungerOnJoin();
		hunger = Methods.getItemStack(Material.INK_SACK, id, (byte)11, ChatColor.YELLOW + "Hunger", new String[] {
				"",
				ChatColor.GRAY + "What is the",
				ChatColor.YELLOW + "Hunger amount" + ChatColor.GRAY + " to set",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				"",
				ChatColor.GRAY + "Left click to " + ChatColor.GREEN + "increase",
				ChatColor.GRAY + "Right click to " + ChatColor.RED + "decrease",
				"",
				ChatColor.GRAY + "Value: " + ChatColor.YELLOW + id,
				""});
	}

	public void setExp() {
		id = main.getConnectionManager().getExpOnJoin();
		exp = Methods.getItemStack(Material.INK_SACK, id, (byte)12, ChatColor.YELLOW + "Experience", new String[] {
				"",
				ChatColor.GRAY + "What is the",
				ChatColor.YELLOW + "Exp amount" + ChatColor.GRAY + " to set",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				"",
				ChatColor.GRAY + "Left click to " + ChatColor.GREEN + "increase",
				ChatColor.GRAY + "Right click to " + ChatColor.RED + "decrease",
				"",
				ChatColor.GRAY + "Value: " + ChatColor.YELLOW + id,
				""});
	}

	public void setLevel() {
		id = main.getConnectionManager().getLevelOnJoin();
		level = Methods.getItemStack(Material.INK_SACK, id, (byte)14, ChatColor.YELLOW + "Level", new String[] {
				"",
				ChatColor.GRAY + "What is the",
				ChatColor.YELLOW + "Level" + ChatColor.GRAY + " to set",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				"",
				ChatColor.GRAY + "Left click to " + ChatColor.GREEN + "increase",
				ChatColor.GRAY + "Right click to " + ChatColor.RED + "decrease",
				"",
				ChatColor.GRAY + "Value: " + ChatColor.YELLOW + id,
				""});
	}

	public void setGamemode() {
		String name = main.getConnectionManager().getGamemodeOnJoin().toString();
		gamemode = Methods.getItemStack(Material.INK_SACK, 1, (byte)7, ChatColor.YELLOW + "GameMode", new String[] {
				"",
				ChatColor.GRAY + "What is the",
				ChatColor.YELLOW + "GameMode" + ChatColor.GRAY + " to set",
				ChatColor.GRAY + "(Applies to players on join or",
				ChatColor.GRAY + "/spawn if enabled)",
				"",
				ChatColor.GRAY + "Click to " + ChatColor.GREEN + "change",
				"",
				ChatColor.GRAY + "Value: " + ChatColor.YELLOW + name,
				""});
	}

	/**
	 * Loads all items
	 */
	public void loadItems() {
		setSpawnSettings();
		setProtectionSettings();
		setConnectionSettings();
		setEnableSpawn();
		setSetSpawn();
		setFirstJoin();
		setEveryJoin();
		setRespawn();
		setVoidtp();
		setConnectionsettingsonspawncmd();
		setPlayersDamage();
		setPlayersPvP();
		setPlayersFallDamage();
		setPlayersRegen();
		setPlayersInteract();
		setPlayersHunger();
		setPlayersBreak();
		setPlayersPlace();
		setPlayersDrop();
		setPlayersPickup();
		setPlayersKeepInventory();
		setMobsSpawn();
		setAnimalsSpawn();
		setWeatherChange();
		setWaterDamage();
		setEnableConnectionSettings();
		setClearInv();
		setClearPots();
		setHealth();
		setHunger();
		setExp();
		setLevel();
		setGamemode();
	}
}
