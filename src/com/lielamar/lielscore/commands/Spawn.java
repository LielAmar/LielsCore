package com.lielamar.lielscore.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class Spawn implements CommandExecutor {

	private Main main;
	
	public Spawn(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.spawn")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			Location spawn = main.getSpawnManager().getSpawn();
			if(spawn == null) return true;
			
			Player p = (Player)cs;
			
			p.sendMessage(Messages.teleporting("Spawn"));
			p.teleport(spawn);
			if(main.getSpawnManager().isConnectionSettingsOnSpawnCommand())
				main.getConnectionManager().fixPlayer(p);
			return true;
		}
		return true;
	}
}