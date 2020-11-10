package com.lielamar.lielscore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.lielamar.lielscore.commands.Spawn;
import com.lielamar.lielscore.commands.coresettings.Bypass;
import com.lielamar.lielscore.commands.coresettings.CoreReload;
import com.lielamar.lielscore.commands.coresettings.CoreSettings;
import com.lielamar.lielscore.commands.coresettings.CoreSettingsHandler;
import com.lielamar.lielscore.commands.events.Event;
import com.lielamar.lielscore.commands.extra.Countdown;
import com.lielamar.lielscore.commands.extra.Feed;
import com.lielamar.lielscore.commands.extra.Fly;
import com.lielamar.lielscore.commands.extra.Flyspeed;
import com.lielamar.lielscore.commands.extra.GMC;
import com.lielamar.lielscore.commands.extra.GMS;
import com.lielamar.lielscore.commands.extra.GMX;
import com.lielamar.lielscore.commands.extra.Gamemode;
import com.lielamar.lielscore.commands.extra.God;
import com.lielamar.lielscore.commands.extra.Heal;
import com.lielamar.lielscore.commands.extra.Invsee;
import com.lielamar.lielscore.commands.extra.Memory;
import com.lielamar.lielscore.commands.extra.Perform;
import com.lielamar.lielscore.commands.extra.Poke;
import com.lielamar.lielscore.commands.extra.Rename;
import com.lielamar.lielscore.commands.extra.SayAs;
import com.lielamar.lielscore.commands.extra.SocialMedias;
import com.lielamar.lielscore.commands.extra.Teleport;
import com.lielamar.lielscore.commands.extra.Tpall;
import com.lielamar.lielscore.commands.extra.Vanish;
import com.lielamar.lielscore.listeners.BlockedCommands;
import com.lielamar.lielscore.listeners.PingEvents;
import com.lielamar.lielscore.listeners.coresettings.OnConnectionSettingsGUI;
import com.lielamar.lielscore.listeners.coresettings.OnMainGUI;
import com.lielamar.lielscore.listeners.coresettings.OnProtectionSettingsGUI;
import com.lielamar.lielscore.listeners.coresettings.OnSpawnSettingsGUI;
import com.lielamar.lielscore.listeners.events.OneToKillEvents;
import com.lielamar.lielscore.listeners.protection.ProtectionListeners;
import com.lielamar.lielscore.listeners.spawn.SpawnListeners;
import com.lielamar.lielscore.managers.ConnectionManager;
import com.lielamar.lielscore.managers.ProtectionManager;
import com.lielamar.lielscore.managers.SpawnManager;
import com.lielamar.lielscore.managers.packets.PacketHandler;

public class Main extends JavaPlugin {
	
	private PacketHandler packetHandler;
	private SpawnManager spawnManager;
	private ConnectionManager connectionManager;
	private ProtectionManager protectionManager;
	
	private CoreSettingsHandler coreSettingsHandler;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		registerManagers();
		registerListeners();
		registerCommands();
		
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(getSpawnManager().isConnectionSettingsOnSpawnCommand())
				getConnectionManager().fixPlayer(pl);
			
			Location spawn = getSpawnManager().getSpawn();
			if(spawn == null) return;
				
			pl.teleport(spawn);
		}
	}
	
	@Override
	public void onDisable() {
		saveConfig();
		destroyManagers();
	}
	
	public void registerManagers() {
		this.packetHandler = new PacketHandler();
		this.spawnManager = new SpawnManager(this);
		this.connectionManager = new ConnectionManager(this);
		this.protectionManager = new ProtectionManager(this);
		
		this.coreSettingsHandler = new CoreSettingsHandler(this);
	}
	
	public void destroyManagers() {
		this.spawnManager = null;
		this.connectionManager = null;
		this.protectionManager = null;
		
		this.coreSettingsHandler = null;
	}
	
	public void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		
		// ===== General =====
		pm.registerEvents(new BlockedCommands(), this);
		pm.registerEvents(new PingEvents(this), this);
		
		// ===== Events =====
		pm.registerEvents(new OneToKillEvents(), this);
		
		// ===== Managers =====
		pm.registerEvents(new ProtectionListeners(this), this);
		pm.registerEvents(new SpawnListeners(this), this);
		
		// ===== GUIs =====
		pm.registerEvents(new OnMainGUI(this), this);
		pm.registerEvents(new OnSpawnSettingsGUI(this), this);
		pm.registerEvents(new OnProtectionSettingsGUI(this), this);
		pm.registerEvents(new OnConnectionSettingsGUI(this), this);
		
		// ===== Commands =====
		pm.registerEvents(new God(), this);
		pm.registerEvents(new Invsee(), this);
	}

	public void registerCommands() {
		// ===== General =====
		getCommand("coresettings").setExecutor(new CoreSettings(this));
		getCommand("corereload").setExecutor(new CoreReload(this));
		getCommand("bypass").setExecutor(new Bypass(this));
		
		// ===== Events =====
		getCommand("event").setExecutor(new Event());
		
		// ===== Managers =====
		if(this.spawnManager.getSpawn() != null) // If the server's spawn isn't null
			getCommand("spawn").setExecutor(new Spawn(this));
		
		// ===== Extra
		getCommand("perform").setExecutor(new Perform());
		getCommand("discord").setExecutor(new SocialMedias());
		getCommand("youtube").setExecutor(new SocialMedias());
		getCommand("twitter").setExecutor(new SocialMedias());
		getCommand("countdown").setExecutor(new Countdown(this));
		getCommand("fly").setExecutor(new Fly());
		getCommand("flyspeed").setExecutor(new Flyspeed());
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("gmc").setExecutor(new GMC());
		getCommand("gms").setExecutor(new GMS());
		getCommand("gmx").setExecutor(new GMX());
		getCommand("god").setExecutor(new God());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("memory").setExecutor(new Memory());
		getCommand("poke").setExecutor(new Poke(this));
		getCommand("rename").setExecutor(new Rename());
		getCommand("sayas").setExecutor(new SayAs());
		getCommand("teleport").setExecutor(new Teleport());
		getCommand("tpall").setExecutor(new Tpall());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("feed").setExecutor(new Feed());
		getCommand("heal").setExecutor(new Heal());
	}
	
	public PacketHandler getPacketHander() { return this.packetHandler; }
	public SpawnManager getSpawnManager() { return this.spawnManager; }
	public ConnectionManager getConnectionManager() { return this.connectionManager; }
	public ProtectionManager getProtectionManager() { return this.protectionManager; }
	
	public CoreSettingsHandler getCoreHandler() { return this.coreSettingsHandler; }
}