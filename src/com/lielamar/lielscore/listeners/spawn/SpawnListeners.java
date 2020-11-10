package com.lielamar.lielscore.listeners.spawn;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.util.Vector;

import com.lielamar.lielscore.Main;

public class SpawnListeners implements Listener {

	private Main main;
	
	public SpawnListeners(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onFirstJoin(PlayerJoinEvent e) {
		Location spawn = this.main.getSpawnManager().getSpawn();
		if(spawn == null) return;
		
		if(!this.main.getSpawnManager().isTeleportToSpawnOnFirstJoin()) return;
		
		Player p = e.getPlayer();
		if(p.hasPlayedBefore()) return;
		
		p.teleport(spawn);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Location spawn = this.main.getSpawnManager().getSpawn();
		if(spawn == null) return;
		
		if(!this.main.getSpawnManager().isTeleportToSpawnOnEveryJoin()) return;
		
		Player p = e.getPlayer();
		p.teleport(spawn);
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Location spawn = this.main.getSpawnManager().getSpawn();
		if(spawn == null) return;
		
		if(!this.main.getSpawnManager().isTeleportToSpawnOnRespawn()) return;
		
		Player p = e.getPlayer();
		p.teleport(spawn);
	}
	
	@EventHandler
	public void onVoid(PlayerMoveEvent e) {
		if(e.getTo().getY() > 0) return;
		
		Location spawn = this.main.getSpawnManager().getSpawn();
		if(spawn == null) return;
		
		if(!this.main.getSpawnManager().isTeleportToSpawnOnVoid()) return;
		
		Player p = e.getPlayer();
		p.teleport(spawn);
		p.setVelocity(new Vector(0, 0, 0));
	}
}
