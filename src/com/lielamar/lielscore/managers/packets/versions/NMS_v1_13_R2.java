package com.lielamar.lielscore.managers.packets.versions;

import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.managers.packets.PacketVersion;

import net.minecraft.server.v1_13_R2.ChatMessageType;
import net.minecraft.server.v1_13_R2.IChatBaseComponent;
import net.minecraft.server.v1_13_R2.PacketPlayOutChat;
import net.minecraft.server.v1_13_R2.PacketPlayOutTitle;

public class NMS_v1_13_R2 implements PacketVersion {

	public void sendTitle(Player p, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime) {
		IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
		PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, icbc, fadeInTime, showTime, fadeOutTime);
		icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
		PacketPlayOutTitle packetSubtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, icbc, fadeInTime, showTime, fadeOutTime);
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packetTitle);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packetSubtitle);
	}

	public void sendActionBar(Player p, String message) {
		IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat packet = new PacketPlayOutChat(icbc, ChatMessageType.GAME_INFO);
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
}
