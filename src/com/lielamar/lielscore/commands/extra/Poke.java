package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class Poke implements CommandExecutor{
	
	private Main main;
	
	public Poke(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.poke")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("poke")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				p.sendMessage(Messages.wrongUsage("Poke", "<Player>"));
				return true;
			}

			Player t = Bukkit.getPlayer(args[0]);
				
			if(t == null) {
				cs.sendMessage(Messages.playerNotFound(args[0]));
				return true;
			}
		
			p.sendMessage(ChatColor.GRAY + "Poked " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
			main.getPacketHander().getNMSHandler().sendTitle(t, ChatColor.RED + "Hi, Wake up!", "", 20, 80, 20);
			t.playSound(t.getLocation(), Sound.NOTE_PLING, 1, 1);
			return true;
		}
		return true;
	}
}
