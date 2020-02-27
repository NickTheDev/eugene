package com.vanilla.eugene.listeners;

import com.vanilla.eugene.util.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class PlayerDeath implements Listener {

    private final Random random = new Random();
    private final String[] quips = {
            "has divided by zero.",
            "has voted democrat.",
            "has failed to conform to all 5 pillars of Islam.",
            "has attempted to steal one of Tanmay's pillars of Islam.",
            "has questioned Tanmay's executive authority."
    };

    @EventHandler
    public void playerDeath(PlayerDeathEvent event) {
        if(event.getEntity().getName().contains("Geo1017")) {
            event.setDeathMessage(Chat.get(Chat.PREFIXED, "&b&l" + event.getEntity().getName() + " &f&lhas died in Navy Seal training."));
            return;
        }

        event.setDeathMessage(Chat.get(Chat.PREFIXED, "&b&l" + event.getEntity().getName() + " &f&l" + quips[random.nextInt(quips.length)]));
    }

}
