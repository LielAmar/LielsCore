package com.lielamar.lielscore.commands.extra;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.lielamar.lielscore.utils.Messages;

public class Rename implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.rename")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("rename")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				p.sendMessage(Messages.wrongUsage("Poke", "<Name>"));
				return true;
			}
			
			if(p.getItemInHand() == null) {
				p.sendMessage(ChatColor.RED + "You are not holding anything!");
				return true;
			}
			
			String name = "";
			for(int i = 0; i < args.length; i++)
				name += args[i] + " ";
			name = name.substring(0, name.length());
			
			ItemStack item = p.getItemInHand();
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
			item.setItemMeta(meta);
			p.setItemInHand(item);
			p.sendMessage(ChatColor.GRAY + "Renamed your " + ChatColor.AQUA + item.getType() + ChatColor.GRAY + " to " + ChatColor.YELLOW + name + ChatColor.GRAY + "!");
			return true;
		}
		return false;
	}

}
