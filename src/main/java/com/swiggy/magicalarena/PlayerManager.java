package com.swiggy.magicalarena;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton enum for player management
 */
public enum PlayerManager {
    INSTANCE;
    private final Map<Integer, Player> players;
    private int playerCount = 0;

    PlayerManager() {
        players = new HashMap<>();
    }

    public void registerPlayer(Player player) {
        player.setId(++playerCount);
        players.put(playerCount, player);
        System.out.println("Player #" + playerCount + " has been registered.");
    }

    public void initiateMatchBetween(int id1, int id2) {
        Match match = new Match(players.get(id1), players.get(id2));
        match.conductMatch();
    }
}