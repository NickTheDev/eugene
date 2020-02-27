package com.vanilla.eugene.user;

import com.vanilla.eugene.Eugene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Manages user instances across the server.
 *
 * @author NickTheDev
 */
public class UserManager {

    private final List<User> online = new ArrayList<>();

    /**
     * Gets an unmodifiable copy of the online users.
     *
     * @return Online users.
     */
    public List<User> getOnline() {
        return Collections.unmodifiableList(online);
    }

    /**
     * Creates a user for the given info.
     *
     * @param id Id of the user.
     * @param name Name of the user.
     */
    public void createUser(UUID id, String name) {
        online.add(new User(id, name, Eugene.get().getUserConfig().create(id)));
    }

    /**
     * Removes a user from the online array.
     *
     * @param id Id of the user.
     */
    public void removeUser(UUID id) {
        online.remove(User.get(id).get());
    }

}
