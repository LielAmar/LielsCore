package com.lielamar.lielscore.commands.coresettings;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class CoreReload implements CommandExecutor {

	private Main main;

	public CoreReload(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!cs.hasPermission("lielscore.commands.corereload")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("corereload")) {
			main.onDisable();
			main.onEnable();
			cs.sendMessage(Messages.reloadLielsCore);
		}
		return true;
	}
}