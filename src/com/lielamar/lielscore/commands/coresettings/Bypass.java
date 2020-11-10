package com.lielamar.lielscore.commands.coresettings;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class Bypass implements CommandExecutor {

	private Main main;
	
	public Bypass(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.bypass")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("bypass")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				if(!main.getProtectionManager().getBypass().contains(p.getUniqueId())) {
					main.getProtectionManager().getBypass().add(p.getUniqueId());
					p.sendMessage(Messages.bypassModeEnabled(""));
				} else {
					main.getProtectionManager().getBypass().remove(p.getUniqueId());
					p.sendMessage(Messages.bypassModeDisabled(""));
				}
				return true;
			}
			
			if(!cs.hasPermission("lielscore.commands.bypass.others")) {
				cs.sendMessage(Messages.noPermissions);
				return true;
			}
			
			Player t = Bukkit.getPlayer(args[0]);
			if(t == null) {
				p.sendMessage(Messages.playerNotFound(args[0]));
				return true;
			}
			
			if(!main.getProtectionManager().getBypass().contains(t.getUniqueId())) {
				main.getProtectionManager().getBypass().add(t.getUniqueId());
				p.sendMessage(Messages.bypassModeEnabled(t.getName()));
				t.sendMessage(Messages.bypassModeEnabled(""));
			} else {
				main.getProtectionManager().getBypass().remove(t.getUniqueId());
				p.sendMessage(Messages.bypassModeDisabled(t.getName()));
				t.sendMessage(Messages.bypassModeDisabled(""));
			}
			return true;
		}
		return true;
	}
}