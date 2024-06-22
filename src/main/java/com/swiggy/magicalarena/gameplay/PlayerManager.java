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

    public int getPlayerCount() {
        return players.size();
    }

    public void registerPlayer(Player player) {
        int idToAssign = getPlayerCount() + 1;
        player.setId(idToAssign);
        players.put(idToAssign, player);
        System.out.println("Player #" + idToAssign + " has been registered.");
    }

    public Optional<Player> initiateMatchBetween(int id1, int id2) {
        Match match = new Match(players.get(id1), players.get(id2));
        return Optional.ofNullable(match.conductMatch());
    }
}