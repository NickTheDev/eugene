package com.vanilla.eugene.listeners;

import com.vanilla.eugene.Eugene;
import com.vanilla.eugene.util.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Eugene.get().getUserManager().createUser(player.getUniqueId(), player.getName());
        event.setJoinMessage(Chat.get(Chat.PREFIXED, "&b&l" + player.getName() + " &f&lhas joined the game."));
        //player.setResourcePack("https://www.curseforge.com/minecraft/texture-packs/bare-bones-texture-pack/download/2868407/file");
    }

}
