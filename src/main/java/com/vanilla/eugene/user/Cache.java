package com.vanilla.eugene.user;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

import java.util.Map;

/**
 * Represents an attribute or statistic that a user can posses.
 *
 * @author NickTheDev
 */
@SerializableAs("Cache")
public class Cache implements ConfigurationSerializable {

    private final Map<String, Object> store;

    /**
     * Loads a new attributes store with the loaded info.
     *
     * @param store Store to encapsulate.
     */
    public Cache(Map<String, Object> store) {
        this.store = store;

        populate();
    }

    /**
     * Gets a value from the key store assuming the input is smart.
     *
     * @param key Key of the value to get.
     * @param <T> Type of value.
     * @return Stored value.
     */
    @SuppressWarnings("unchecked")
    public <T> T get(Key key) {
        return (T) store.get(key.toString());
    }

    /**
     * Ensures that this cache contains a value for each key.
     */
    private void populate() {
        for(Cache.Key key : Cache.Key.values()) {
            if(!store.containsKey(key.toString())) {
                push(key, key.getDefault());
            }
        }

    }

    /**
     * Updates the value for the specified attribute in the store.
     *
     * @param key Key of the value to push.
     * @param value Value to update.
     */
    public void push(Key key, Object value) {
        store.put(key.toString(), value);
    }

    @Override
    public Map<String, Object> serialize() {
        return store;
    }

    /**
     * Creates a new cache from config data.
     *
     * @param data Data to load.
     * @return New loaded cache.
     */
    public static Cache deserialize(Map<String, Object> data) {
        return new Cache(data);
    }

    /**
     * Represents a key that has access to a specific value.
     */
    public enum Key {

        RANK("&d&lBev"),
        DIAMONDS_MINED(0);

        private Object value;

        Key(Object value) {
            this.value = value;
        }

        public Object getDefault() {
            return value;
        }

        /**
         * Returns a config ready string representation of this key.
         *
         * @return String representation.
         */
        @Override
        public String toString() {
            return name().toLowerCase().replaceAll("_", "-");
        }

    }

}
