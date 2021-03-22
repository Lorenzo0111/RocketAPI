package me.lorenzo0111.api.chat;

import org.bukkit.ChatColor;

@SuppressWarnings("unused")
public class ChatUtils {

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String colorize(String string, char altColorChar) {
        return ChatColor.translateAlternateColorCodes(altColorChar, string);
    }

}
