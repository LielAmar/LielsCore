package com.lielamar.lielscore.commands.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.lielamar.lielscore.utils.Messages;
import com.lielamar.lielscore.utils.Methods;

public class Event implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!cs.hasPermission("lielscore.commands.event")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("event")) {
			if(args.length == 0) {
				cs.sendMessage(Messages.wrongUsage("Event", "<Event Name>"));
				cs.sendMessage(ChatColor.GRAY + "Events: " + ChatColor.YELLOW + "LastToDie" + ChatColor.GRAY + ", " + ChatColor.YELLOW + "LastToStopRunning" + ChatColor.GRAY + ", " + ChatColor.YELLOW + "OneToKill");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("onetokill")) {
				for(Player pl : Bukkit.getOnlinePlayers()) {
					if(pl.getName().equalsIgnoreCase("lonelywolf1") || pl.getName().equalsIgnoreCase("lielamar")) {
						pl.getInventory().setBoots(oneToKillArmorOp(Material.DIAMOND_BOOTS));
						pl.getInventory().setLeggings(oneToKillArmorOp(Material.DIAMOND_LEGGINGS));
						pl.getInventory().setChestplate(oneToKillArmorOp(Material.DIAMOND_CHESTPLATE));
						pl.getInventory().setHelmet(oneToKillArmorOp(Material.DIAMOND_HELMET));
						pl.getInventory().setItem(0, oneToKillWeaponOP(Material.DIAMOND_SWORD));
						pl.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 32));
						pl.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5, (short)1));
						pl.getInventory().addItem(oneToKillBowOP(Material.BOW));
						pl.getInventory().addItem(new ItemStack(Material.FISHING_ROD));
						pl.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL));
						pl.getInventory().addItem(new ItemStack(Material.TNT, 32));
						pl.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
						pl.getInventory().addItem(new ItemStack(Material.STONE, 16));
						pl.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 16));
						pl.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 16));
						pl.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 16));
						pl.getInventory().addItem(new ItemStack(Material.WEB, 32));
						pl.getInventory().addItem(new ItemStack(Material.ARROW, 1));
						pl.getInventory().addItem(oneToKillArmorOp(Material.DIAMOND_BOOTS));
						pl.getInventory().addItem(oneToKillArmorOp(Material.DIAMOND_LEGGINGS));
						pl.getInventory().addItem(oneToKillArmorOp(Material.DIAMOND_CHESTPLATE));
						pl.getInventory().addItem(oneToKillArmorOp(Material.DIAMOND_HELMET));
						continue;
					}
					
					pl.getInventory().clear();
					pl.getInventory().setBoots(oneToKillArmor(Material.IRON_BOOTS));
					pl.getInventory().setLeggings(oneToKillArmor(Material.IRON_LEGGINGS));
					pl.getInventory().setChestplate(oneToKillArmor(Material.IRON_CHESTPLATE));
					pl.getInventory().setHelmet(oneToKillArmor(Material.IRON_HELMET));
					pl.getInventory().setItem(0, oneToKillWeapon(Material.IRON_SWORD));
					pl.getInventory().addItem(compass());
					pl.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
					pl.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 1));
					pl.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
				}
			}
		}
		return true;
	}
	
	public ItemStack oneToKillArmor(Material mat) {
		ItemStack item = Methods.getItemStack(mat, 1);
		item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		item.addEnchantment(Enchantment.DURABILITY, 3);
		return item;
	}
	
	public ItemStack oneToKillWeapon(Material mat) {
		ItemStack item = Methods.getItemStack(mat, 1);
		item.addEnchantment(Enchantment.DURABILITY, 3);
		return item;
	}
	
	public ItemStack oneToKillArmorOp(Material mat) {
		ItemStack item = Methods.getItemStack(mat, 1);
		item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item.addEnchantment(Enchantment.DURABILITY, 1);
		if(mat == Material.DIAMOND_BOOTS)
			item.addEnchantment(Enchantment.PROTECTION_FALL, 4);
		return item;
	}
	
	public ItemStack oneToKillWeaponOP(Material mat) {
		ItemStack item = Methods.getItemStack(mat, 1);
		item.addEnchantment(Enchantment.DAMAGE_ALL, 5);
		return item;
	}
	
	public ItemStack oneToKillBowOP(Material mat) {
		ItemStack item = Methods.getItemStack(mat, 1);
		item.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
		item.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		item.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		return item;
	}
	
	public ItemStack compass() {
		return Methods.getItemStack(Material.COMPASS, 1, ChatColor.GRAY + "Tracking " + ChatColor.YELLOW + "LielAmar", new String[] {
				"",
				ChatColor.GRAY + "Use this compass to",
				ChatColor.GRAY + "Track down Liel & Lonely!",
				"",
				ChatColor.YELLOW + "Right-Click " + ChatColor.GRAY + "to re-track",
				ChatColor.YELLOW + "Left-Click " + ChatColor.GRAY + "to change track",
				""
		});
	}
}
