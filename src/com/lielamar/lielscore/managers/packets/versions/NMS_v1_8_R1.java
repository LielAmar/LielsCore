package com.lielamar.lielscore.managers.packets.versions;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.lielamar.lielscore.managers.packets.PacketVersion;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

public class NMS_v1_8_R1 implements PacketVersion {

	public void sendTitle(Player p, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime) {
		IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + title + "\"}");
		PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, icbc, fadeInTime, showTime, fadeOutTime);
		icbc = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
		PacketPlayOutTitle packetSubtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, icbc, fadeInTime, showTime, fadeOutTime);
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packetTitle);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packetSubtitle);
	}
	
	public void sendActionBar(Player p, String message) {
		IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat packet = new PacketPlayOutChat(icbc, (byte)2);
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
}
