package com.swiggy.magicalarena.gameplay;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Singleton enum for player management
 */
public enum PlayerManager {
    INSTANCE;
    private final Map<Integer, Player> players;

    PlayerManager() {
        players = new HashMap<>();
    }

    /**
     * @return The total number of players registered in the arena
     */
    public int getPlayerCount() {
        return players.size();
    }

    /**
     * This method registers a new player into the arena and assigns a unique ID.
     * The player is saved in a map with key as unique ID.
     *
     * @param player The player details to register into the arena
     */
    public void registerPlayer(Player player) {
        int idToAssign = getPlayerCount() + 1;
        player.setId(idToAssign);
        players.put(idToAssign, player);
        System.out.println("Player #" + idToAssign + " has been registered.");
    }

    /**
     * This method fetches the two selected players from the map, then creates and initiates a match between them.
     *
     * @param id1 The unique ID of the first player selected for match
     * @param id2 The unique ID of the second player selected for match
     * @return The winning player if a match was conducted, otherwise, an empty value
     */
    public Optional<Player> initiateMatchBetween(int id1, int id2) {
        Match match = new Match(players.get(id1), players.get(id2));
        return Optional.ofNullable(match.conductMatch());
    }
}
