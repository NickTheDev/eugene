package com.vanilla.eugene.listeners;

import com.vanilla.eugene.user.Cache;
import com.vanilla.eugene.user.User;
import com.vanilla.eugene.util.Chat;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void asyncPlayerChat(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.DIAMOND_ORE) {
            User user = User.get(event.getPlayer().getUniqueId()).get();

            user.getCache().push(Cache.Key.DIAMONDS_MINED, (int) user.getCache().get(Cache.Key.DIAMONDS_MINED) + 1);
            Chat.to(user.toPlayer(), Chat.SUCCESS, "You have now mined &b&l" + user.getCache().get(Cache.Key.DIAMONDS_MINED));
        }

    }

}
