package com.vanilla.eugene;

import com.vanilla.eugene.command.RankCommand;
import com.vanilla.eugene.config.StoreException;
import com.vanilla.eugene.config.data.UserConfig;
import com.vanilla.eugene.listeners.*;
import com.vanilla.eugene.user.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Stream;

/**
 * Main plugin that is responsible for bootstrapping the startup processes.
 *
 * @author NickTheDev
 */
public class Eugene extends JavaPlugin {

    private static Eugene instance;
    private final UserManager userManager = new UserManager();
    private  UserConfig userConfig;

    @Override
    public void onEnable() {
        instance = this;

        try {
            saveDefaultConfig();
            userConfig = new UserConfig();

        } catch(StoreException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);

            return;
        }

        Bukkit.getPluginCommand("setrank").setExecutor(new RankCommand());
        Stream.of(new PlayerJoin(), new PlayerQuit(), new PlayerResourcePackStatus(), new PlayerDeath(), new AsyncPlayerChat(),
                new BlockBreak()).forEach(l -> Bukkit.getPluginManager().registerEvents(l, this));
    }

    @Override
    public void onDisable() {
        userConfig.save();
    }

    /**
     * Gets the user manager of the plugin.
     *
     * @return User manager.
     */
    public UserManager getUserManager() {
        return userManager;
    }

    /**
     * Gets the user config of the plugin.
     *
     * @return User config.
     */
    public UserConfig getUserConfig() {
        return userConfig;
    }

    /**
     * Gets the static instance of this plugin manager.
     *
     * @return Static instance.
     */
    public static Eugene get() {
        return instance;
    }
}
