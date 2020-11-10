package com.lielamar.lielscore.managers;

import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import com.lielamar.lielscore.Main;

public class ConnectionManager {

	private Main main;
	
	private boolean enabled;
	private boolean clearinv;
	private boolean clearpots;
	private int healthOnJoin;
	private int hungerOnJoin;
	private int expOnJoin;
	private int levelOnJoin;
	private GameMode gamemodeOnJoin;
	
	public ConnectionManager(Main main) {
		this.main = main;
		
		FileConfiguration config = getMain().getConfig();
		
		this.enabled = config.getBoolean("ConnectionSettings.enabled");
		this.clearinv = config.getBoolean("ConnectionSettings.clearinv");
		this.clearpots = config.getBoolean("ConnectionSettings.clearpots");
		this.healthOnJoin = config.getInt("ConnectionSettings.health");
		this.hungerOnJoin = config.getInt("ConnectionSettings.hunger");
		this.expOnJoin = config.getInt("ConnectionSettings.exp");
		this.levelOnJoin = config.getInt("ConnectionSettings.level");
		try {
			this.gamemodeOnJoin = GameMode.valueOf(config.getString("ConnectionSettings.GameMode"));
		} catch(Exception e) {
			this.gamemodeOnJoin = GameMode.SURVIVAL;
		}
	}

	private Main getMain() {
		return this.main;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isClearinv() {
		return clearinv;
	}

	public void setClearinv(boolean clearinv) {
		this.clearinv = clearinv;
	}

	public boolean isClearpots() {
		return clearpots;
	}

	public void setClearpots(boolean clearpots) {
		this.clearpots = clearpots;
	}

	public int getHealthOnJoin() {
		return healthOnJoin;
	}

	public void setHealthOnJoin(int healthOnJoin) {
		this.healthOnJoin = healthOnJoin;
	}

	public int getHungerOnJoin() {
		return hungerOnJoin;
	}

	public void setHungerOnJoin(int hungerOnJoin) {
		this.hungerOnJoin = hungerOnJoin;
	}

	public int getExpOnJoin() {
		return expOnJoin;
	}

	public void setExpOnJoin(int expOnJoin) {
		this.expOnJoin = expOnJoin;
	}

	public int getLevelOnJoin() {
		return levelOnJoin;
	}

	public void setLevelOnJoin(int levelOnJoin) {
		this.levelOnJoin = levelOnJoin;
	}

	public GameMode getGamemodeOnJoin() {
		return gamemodeOnJoin;
	}

	public void setGamemodeOnJoin(GameMode gamemodeOnJoin) {
		this.gamemodeOnJoin = gamemodeOnJoin;
	}
	
	/**
	 * Fixes a player
	 * 
	 * @param p      Player to fix
	 */
	public void fixPlayer(Player p) {
		if(!enabled) return;
		
		if(isClearinv()) {
			p.getInventory().setBoots(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setHelmet(null);
			p.getInventory().clear();
		}
		if(isClearpots()) {
			for(PotionEffect pe : p.getActivePotionEffects())
				p.removePotionEffect(pe.getType());
		}
		
		p.setHealth(getHealthOnJoin());
		p.setFoodLevel(getHungerOnJoin());
		p.setExp(getExpOnJoin());
		p.setLevel(getLevelOnJoin());
		p.setGameMode(getGamemodeOnJoin());
	}
}
