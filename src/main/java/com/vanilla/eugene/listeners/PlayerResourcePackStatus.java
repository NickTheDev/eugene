package com.vanilla.eugene.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class PlayerResourcePackStatus implements Listener {

    @EventHandler
    public void playerResource(PlayerResourcePackStatusEvent event) {
        //if(event.getStatus() == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD || event.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED) {
        //    event.getPlayer().kickPlayer("You must accept the resource pack to play.");
        //}
    }

}
