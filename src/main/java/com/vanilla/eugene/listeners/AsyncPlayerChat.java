package com.vanilla.eugene.listeners;

import com.vanilla.eugene.user.Cache;
import com.vanilla.eugene.user.User;
import com.vanilla.eugene.util.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {

    @EventHandler
    public void asyncPlayerChat(AsyncPlayerChatEvent event) {
        User user = User.get(event.getPlayer().getUniqueId()).get();

        event.setFormat(Chat.get(user.getCache().get(Cache.Key.RANK) + " &e" + user.getName() + " &f" + event.getMessage()));
    }

}
