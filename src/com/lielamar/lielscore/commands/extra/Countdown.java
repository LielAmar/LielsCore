package com.lielamar.lielscore.commands.extra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.lielamar.lielscore.Main;
import com.lielamar.lielscore.utils.Messages;

public class Countdown implements CommandExecutor {

	private Main main;
	
	private boolean running;
	private BukkitTask task;
	
	public Countdown(Main main) {
		this.main = main;
		
		running = false;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if(!cs.hasPermission("lielscore.commands.countdown")) {
			cs.sendMessage(Messages.noPermissions);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("countdown")) {
			if(args.length == 0) {
				cs.sendMessage(Messages.wrongUsage("Countdown", "<Time/Stop>"));
				return true;
			}
			
			if(args[0].equalsIgnoreCase("stop")) {
				if(!running) {
					cs.sendMessage(ChatColor.RED + "There isn't a countdown running at the moment!");
					return true;
				}
				
				task.cancel();
				cs.sendMessage(ChatColor.RED + "Countdown stopped");
				return true;
			}
			
			try {
				int i = Integer.parseInt(args[0]);
				
				if(i <= 0) {
					cs.sendMessage(ChatColor.RED + "Countdown must be higher than 0 seconds!");
					return true;
				}
				
				if(running) {
					cs.sendMessage(ChatColor.RED + "There's a countdown running already. Use /countdown stop to stop it!");
					return true;
				}
				
				task = new BukkitRunnable() {
					int c = i;
					@Override
					public void run() {
						if(c <= 0)
							this.cancel();
						
						for(Player pl : Bukkit.getOnlinePlayers())
							main.getPacketHander().getNMSHandler().sendTitle(pl, ChatColor.YELLOW + "" + c, "", 20, 40, 20);
						c = c-1;
					}
				}.runTaskTimer(main, 20L, 20L);
			} catch(Exception e) {
				e.printStackTrace();
				cs.sendMessage(Messages.argumentMustBeAnInteger);
			}
		}
		return true;
	}
}
