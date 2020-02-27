package com.vanilla.eugene.listeners;

import com.vanilla.eugene.Eugene;
import com.vanilla.eugene.util.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void playerQuit(PlayerQuitEvent event) {
        Eugene.get().getUserManager().removeUser(event.getPlayer().getUniqueId());

        event.setQuitMessage(Chat.get(Chat.PREFIXED, "&b&l" + event.getPlayer().getName() + " &f&lhas left the game."));
    }

}
