package me.Lorenzo0111.api.Chat;

import org.bukkit.ChatColor;

@SuppressWarnings("unused")
public class ChatUtility {

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String colorize(String string, char altColorChar) {
        return ChatColor.translateAlternateColorCodes(altColorChar, string);
    }

}
