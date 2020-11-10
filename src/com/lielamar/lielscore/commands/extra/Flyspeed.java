package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.utils.Messages;

public class Flyspeed implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(Messages.consoleSender);
			return true;
		}
		
		if(!cs.hasPermission("lielscore.commands.flyspeeed")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
	
		if(cmd.getName().equalsIgnoreCase("flyspeed")) {
			Player p = (Player)cs;
			
			if(args.length == 0) {
				p.sendMessage(Messages.wrongUsage("Flyspeed", "<Speed/Target> [Speed]"));
				return true;
			}
			
			if(args.length == 2) {
				Player t = Bukkit.getPlayer(args[0]);
				
				if(t == null) {
					cs.sendMessage(Messages.playerNotFound(args[0]));
					return true;
				}
				
				if(!cs.hasPermission("lielscore.commands.flyspeeed.others")) {
					cs.sendMessage(Messages.noPermissions);
					return true;
				}
				
				try {
					int speed = Integer.parseInt(args[1]);
					
					if(t.isFlying()) {
						float final_speed = 0;
						if(speed == 1)
							final_speed = 0.1f;
						else if(speed == 2)
							final_speed = 0.2f;
						else if(speed == 3)
							final_speed = 0.3f;
						else if(speed == 4)
							final_speed = 0.4f;
						else if(speed == 5)
							final_speed = 0.5f;
						else if(speed == 6)
							final_speed = 0.6f;
						else if(speed == 7)
							final_speed = 0.7f;
						else if(speed == 8)
							final_speed = 0.8f;
						else if(speed == 9)
							final_speed = 9.0f;
						else if(speed == 10)
							final_speed = 1.0f;
						else
							final_speed = 0.1f;
						
						t.setFlySpeed(final_speed);
						t.sendMessage(ChatColor.GRAY + "Fly speed changed to " + ChatColor.YELLOW + "" + speed);
						p.sendMessage(ChatColor.GRAY + "Fly speed changed to " + ChatColor.YELLOW + "" + speed + ChatColor.GRAY + " for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
						return true;
					} else {
						float final_speed = 0;
						if(speed == 1)
							final_speed = 0.2f;
						else if(speed == 2)
							final_speed = 0.3f;
						else if(speed == 3)
							final_speed = 0.4f;
						else if(speed == 4)
							final_speed = 0.5f;
						else if(speed == 5)
							final_speed = 0.6f;
						else if(speed == 6)
							final_speed = 0.7f;
						else if(speed == 7)
							final_speed = 0.8f;
						else if(speed == 8)
							final_speed = 0.9f;
						else if(speed == 9)
							final_speed = 1.0f;
						else if(speed == 10)
							final_speed = 1.0f;
						else
							final_speed = 0.2f;
						
						t.setWalkSpeed(final_speed);
						t.sendMessage(ChatColor.GRAY + "Walk speed changed to " + ChatColor.YELLOW + "" + speed);
						p.sendMessage(ChatColor.GRAY + "Walk speed changed to " + ChatColor.YELLOW + "" + speed + ChatColor.GRAY + " for " + ChatColor.AQUA + t.getName() + ChatColor.GRAY + "!");
						return true;
					}
				} catch(Exception e) {
					e.printStackTrace();
					p.sendMessage(Messages.argumentMustBeAnInteger);
					return true;
				}
			}
			
			try {
				int speed = Integer.parseInt(args[0]);
				
				if(p.isFlying()) {
					float final_speed = 0;
					if(speed == 1)
						final_speed = 0.1f;
					else if(speed == 2)
						final_speed = 0.2f;
					else if(speed == 3)
						final_speed = 0.3f;
					else if(speed == 4)
						final_speed = 0.4f;
					else if(speed == 5)
						final_speed = 0.5f;
					else if(speed == 6)
						final_speed = 0.6f;
					else if(speed == 7)
						final_speed = 0.7f;
					else if(speed == 8)
						final_speed = 0.8f;
					else if(speed == 9)
						final_speed = 9.0f;
					else if(speed == 10)
						final_speed = 1.0f;
					else
						final_speed = 0.1f;
					
					p.setFlySpeed(final_speed);
					p.sendMessage(ChatColor.GRAY + "Fly speed changed to " + ChatColor.YELLOW + "" + speed);
					return true;
				} else {
					float final_speed = 0;
					if(speed == 1)
						final_speed = 0.2f;
					else if(speed == 2)
						final_speed = 0.3f;
					else if(speed == 3)
						final_speed = 0.4f;
					else if(speed == 4)
						final_speed = 0.5f;
					else if(speed == 5)
						final_speed = 0.6f;
					else if(speed == 6)
						final_speed = 0.7f;
					else if(speed == 7)
						final_speed = 0.8f;
					else if(speed == 8)
						final_speed = 0.9f;
					else if(speed == 9)
						final_speed = 1.0f;
					else if(speed == 10)
						final_speed = 1.0f;
					else
						final_speed = 0.2f;
					
					p.setWalkSpeed(final_speed);
					p.sendMessage(ChatColor.GRAY + "Walk speed changed to " + ChatColor.YELLOW + "" + speed);
					return true;
				}
			} catch(Exception e) {
				e.printStackTrace();
				p.sendMessage(Messages.argumentMustBeAnInteger);
				return true;
			}
		}
		return true;
	}
}
