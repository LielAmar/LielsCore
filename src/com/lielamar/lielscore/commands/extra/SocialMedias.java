package com.lielamar.lielscore.commands.extra;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.lielamar.lielscore.enums.SocialMedia;
import com.lielamar.lielscore.utils.Messages;

public class SocialMedias implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
	
		if(cmd.getName().equalsIgnoreCase("discord"))
			cs.sendMessage(Messages.socialMedia(SocialMedia.Discord, "https://discord.com/invite/NzgBrqR0"));
		if(cmd.getName().equalsIgnoreCase("youtube"))
			cs.sendMessage(Messages.socialMedia(SocialMedia.Youtube, "https://www.youtube.com/channel/UCK9c8Rixqzy7LqG8eBDy9Fg"));
		if(cmd.getName().equalsIgnoreCase("twitter"))
			cs.sendMessage(Messages.socialMedia(SocialMedia.Twitter, "https://twitter.com/iamlielamar"));
		return true;
	}
}
