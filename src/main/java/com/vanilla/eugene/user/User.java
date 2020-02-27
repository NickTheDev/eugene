package com.vanilla.eugene.user;

import com.vanilla.eugene.Eugene;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents an online player.
 *
 * @author NickTheDev
 */
public class User {

    private final UUID id;
    private final String name;
    private final Cache cache;

    /**
     * Creates a new user with the specified information.
     * @param id Id of the user.
     * @param name Name of the user.
     * @param cache Loaded cache.
     */
    User(UUID id, String name, Cache cache) {
        this.id = id;
        this.name = name;
        this.cache = cache;
    }

    /**
     * Gets the user's id.
     *
     * @return User id.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the user's formal name.
     *
     * @return User name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the user's statistic cache.
     *
     * @return User cache.
     */
    public Cache getCache() {
        return cache;
    }

    /**
     * Gets the Bukkit representation of this user.
     *
     * @return Player cast.
     */
    public Player toPlayer() {
        return Bukkit.getPlayer(getId());
    }

    /**
     * Gets the user based on the inputted id.
     *
     * @param id Id of the user.
     * @return User with the id.
     */
    public static Optional<User> get(UUID id) {
        return Eugene.get().getUserManager().getOnline().stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    /**
     * Gets the user based on the inputted name.
     *
     * @param name Name of the user.
     * @return User with the name.
     */
    public static Optional<User> get(String name) {
        return Eugene.get().getUserManager().getOnline().stream().filter(user -> user.getName().equals(name)).findFirst();
    }

}
