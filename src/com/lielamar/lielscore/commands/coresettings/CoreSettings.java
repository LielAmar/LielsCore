package com.lielamar.lielscore.commands.coresettings;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class CoreSettings implements CommandExecutor {

	private Main main;
	
	public CoreSettings(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.coresettings")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("coresettings")) {
			Player p = (Player)cs;
			p.openInventory(main.getCoreHandler().getGUI("main"));
			return true;
		}
		return true;
	}
}
