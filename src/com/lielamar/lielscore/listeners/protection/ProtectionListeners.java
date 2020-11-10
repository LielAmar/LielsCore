package com.lielamar.lielscore.listeners.protection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;

import com.lielamar.lielscore.Main;

public class ProtectionListeners implements Listener {

	private Main main;
	
	private Map<UUID, Long> waterDamagePlayers;
	
	private Map<UUID, ItemStack[]> contents;
	private Map<UUID, ItemStack[]> armor;

	public ProtectionListeners(Main main) {
		this.main = main;
		this.waterDamagePlayers = new HashMap<UUID, Long>();
		this.contents = new HashMap<UUID, ItemStack[]>();
		this.armor = new HashMap<UUID, ItemStack[]>();
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		
		if(this.main.getProtectionManager().isCanPlayersBeDamaged()) return;
		
		Player p = (Player) e.getEntity();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPvP(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		if(!(e.getDamager() instanceof Player)) return;
		
		if(this.main.getProtectionManager().isCanPlayersPvP()) return;
		
		Player p = (Player) e.getEntity();
		Player d = (Player) e.getDamager();
		if(this.main.getProtectionManager().getBypass().contains(d.getUniqueId())) return;
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}

	@EventHandler
	public void onFallDamage(EntityDamageEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		
		if(this.main.getProtectionManager().isCanPlayersReceiveFallDamage()) return;
		
		if(e.getCause() != DamageCause.FALL) return;
		
		Player p = (Player) e.getEntity();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onRegen(EntityRegainHealthEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		
		if(this.main.getProtectionManager().isCanPlayersRegen()) return;
		
		Player p = (Player) e.getEntity();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(this.main.getProtectionManager().isCanPlayersInteract()) return;
		
		Player p = e.getPlayer();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		if(this.main.getProtectionManager().isCanPlayersHungerChange()) return;
		
		Player p = (Player) e.getEntity();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBreakBlocks(BlockBreakEvent e) {
		if(this.main.getProtectionManager().isCanPlayersBreakBlocks()) return;
		
		Player p = e.getPlayer();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBreakEntity(PlayerInteractAtEntityEvent e) {
		if(!(e.getRightClicked() instanceof Painting || e.getRightClicked() instanceof Minecart || e.getRightClicked() instanceof HopperMinecart)) return;
		
		if(this.main.getProtectionManager().isCanPlayersBreakBlocks()) return;
		
		Player p = e.getPlayer();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlaceBlocks(BlockPlaceEvent e) {
		if(this.main.getProtectionManager().isCanPlayersPlaceBlocks()) return;
		
		Player p = e.getPlayer();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(this.main.getProtectionManager().isCanPlayersDropItems()) return;
		
		Player p = e.getPlayer();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if(this.main.getProtectionManager().isCanPlayersPickupItems()) return;
		
		Player p = e.getPlayer();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onKeepInventory(PlayerDeathEvent e) {
		if(this.main.getProtectionManager().isCanPlayersKeepInventory()) return;
		
		Player p = e.getEntity();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		this.contents.put(p.getUniqueId(), p.getInventory().getContents());
		this.armor.put(p.getUniqueId(), p.getInventory().getArmorContents());
	}
	
	@EventHandler
	public void onKeepInventoryRestore(PlayerRespawnEvent e) {
		if(this.main.getProtectionManager().isCanPlayersKeepInventory()) return;
		
		Player p = e.getPlayer();
		if(this.main.getProtectionManager().getBypass().contains(p.getUniqueId())) return;
		
		if(this.contents.containsKey(p.getUniqueId()))
			p.getInventory().setContents(this.contents.get(p.getUniqueId()));
			
		if(this.armor.containsKey(p.getUniqueId()))
			p.getInventory().setArmorContents(this.armor.get(p.getUniqueId()));
	}

	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent e) {
		if(this.main.getProtectionManager().isCanMobsSpawn()) return;
		
		if(!(e.getEntity() instanceof Monster)) return;
			
		e.setCancelled(true);
	}

	@EventHandler
	public void onAnimalSpawn(CreatureSpawnEvent e) {
		if(this.main.getProtectionManager().isCanMobsSpawn()) return;
		
		if(!(e.getEntity() instanceof Animals)) return;
			
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(this.main.getProtectionManager().isCanWeatherChange()) return;
		
		boolean rain = e.toWeatherState();
		if(rain) e.setCancelled(true);
	}
	
	@EventHandler
	public void onThunderChange(ThunderChangeEvent e) {
		if(this.main.getProtectionManager().isCanWeatherChange()) return;
		
		boolean rain = e.toThunderState();
		if(rain) e.setCancelled(true);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(!this.main.getProtectionManager().isCanWaterDamagePlayers()) return;
		
		Player p = e.getPlayer();
		
		if(p.getLocation().getBlock().getType() == Material.WATER
				|| p.getLocation().getBlock().getType() == Material.STATIONARY_WATER) {
			if(!waterDamagePlayers.containsKey(p.getUniqueId())) {
				p.damage(4);
				waterDamagePlayers.put(p.getUniqueId(), System.currentTimeMillis());
			} else {
				if((System.currentTimeMillis()-waterDamagePlayers.get(p.getUniqueId()))/1000 > 0.5) {
					p.damage(4);
					waterDamagePlayers.put(p.getUniqueId(), System.currentTimeMillis());
				}
			}
		}
	}
}
