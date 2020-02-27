package com.vanilla.eugene.config.data;

import com.vanilla.eugene.config.Configs;
import com.vanilla.eugene.config.StoreException;
import com.vanilla.eugene.user.Cache;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Config file in charge of storing user data.
 *
 * @author NickTheDev
 */
public class UserConfig {
    
    private final FileConfiguration config;
    private final Map<UUID, Cache> store = new HashMap<>();

    /**
     * Creates and loads a new user config.
     *
     * @throws StoreException Thrown if an error occurs loading the file.
     */
    public UserConfig() throws StoreException {
        ConfigurationSerialization.registerClass(Cache.class);
        config = Configs.load("users", true);
        load();
    }

    /**
     * Loads the data from the config file.
     */
    private void load() {
        if(config.getConfigurationSection("users") != null) {
            config.getConfigurationSection("users").getKeys(false).forEach(id -> store.put(UUID.fromString(id), (Cache) config.get("users." + id)));
        }
    }

    /**
     * Creates a new cache from the unique id.
     *
     * @param id Id of the player.
     * @return Cache of the player.
     */
    public Cache create(UUID id) {
        store.putIfAbsent(id, new Cache(new HashMap<>()));

        return store.get(id);
    }

    /**
     * Saves the data from the store to the file.
     */
    public void save() {
        for(UUID id : store.keySet()) {
            config.set("users." + id, store.get(id));
        }

        Configs.save(config, "users");
    }

}
