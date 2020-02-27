package com.vanilla.eugene.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum Chat {

    PREFIXED("&e&lEUGENE&8&l> &f&l"),
    SUCCESS("&a&l(!) "),
    ERROR("&c&l(!) ");

    private final String prefix;

    Chat(String prefix) {
        this.prefix = prefix;
    }

    public static void to(Player player, Chat type, String message) {
        player.sendMessage(get(type, message));
    }

    public static String get(Chat type, String message) {
        return ChatColor.translateAlternateColorCodes('&', type.prefix + message);
    }

    public static String get(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}