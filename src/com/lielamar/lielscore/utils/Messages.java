package com.lielamar.lielscore.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.enums.SocialMedia;

public class Messages {

	public static final String consoleSender = ChatColor.RED + "You must be a player to do that!";
	public static final String noPermissions = ChatColor.RED + "You don't have enough permissions to do that!";
	public static final String reloadLielsCore = ChatColor.GRAY + "Reloading Liel's Core";
	public static final String argumentMustBeAnInteger = ChatColor.RED + "Argument must be an integer!";
	
	public static final String spawnSetToYourLocation = ChatColor.GRAY + "Server's spawn set to your location!";
	public static final String disabledLielsCoreSpawnSystem = ChatColor.GRAY + "Disabled Liel's Core Spawn System!";
	public static final String changedSetting(String setting, String value) { return ChatColor.GRAY + "Set " + ChatColor.YELLOW + setting + ChatColor.GRAY + " to " + chatColor(value) + value; }
	
	
	public static final String playerNotFound(String name) {
		return ChatColor.GRAY + "Player " + ChatColor.RED + " wasn't found!";
	}
	
	public static final String wrongUsage(String command, String... args) {
		String usage = ChatColor.RED + "Usage: /" + command;
		for(String s : args)
			usage += " " + s;
		return  usage;
	}
	
	public static final String socialMedia(SocialMedia type, String link) {
		return ChatColor.GRAY + "Liel's " + type.toString() + ": " + ChatColor.YELLOW + link;
	}
	
	public static final String teleporting(String loc) {
		return ChatColor.GRAY + "Teleporting to " + ChatColor.YELLOW + loc + ChatColor.GRAY + "!";
	}
	
	public static final String teleporting(Player player, String loc) {
		return ChatColor.GRAY + "Teleporting " + ChatColor.AQUA + player.getName() + ChatColor.GRAY + " to " + ChatColor.YELLOW + loc + ChatColor.GRAY + "!";
	}
	
	public static final String performCommand(String target, String cmd) {
		return ChatColor.GRAY + "Performed the command " + ChatColor.YELLOW + cmd + ChatColor.GRAY + " as " + ChatColor.YELLOW + target + ChatColor.GRAY + "!";
	}
	
	public static final String bypassModeEnabled(String player) {
		if(player.length() > 0)
			player = " for " + ChatColor.YELLOW + player;
		return ChatColor.GRAY + "Bypass mode enabled" + player + ChatColor.GRAY + "!";
	}
	
	public static final String bypassModeDisabled(String player) {
		if(player.length() > 0)
			player = " for " + ChatColor.RED + player;
		return ChatColor.GRAY + "Bypass mode disabled" + player + ChatColor.GRAY + "!";
	}
	
	public static final String chatColor(String v) {
		if(v.equalsIgnoreCase("false"))
			return ChatColor.RED + "";
		return ChatColor.GREEN + "";
	}
}
