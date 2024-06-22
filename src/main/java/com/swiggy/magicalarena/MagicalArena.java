package com.swiggy.magicalarena;

import com.swiggy.magicalarena.gameplay.Player;
import com.swiggy.magicalarena.gameplay.PlayerManager;
import java.util.Optional;

public class MagicalArena {
    private static final PlayerManager playerManager = PlayerManager.INSTANCE;

    public static void main(String[] args) {
        System.out.println("\n*************** Welcome to MAGICAL ARENA ***************\n");

        Player player1 = new Player(200, 40, 30);
        playerManager.registerPlayer(player1);

        Player player2 = new Player(150, 50, 25);
        playerManager.registerPlayer(player2);

        Player player3 = new Player(250, 20, 40);
        playerManager.registerPlayer(player3);

        Player player4 = new Player(100, 40, 60);
        playerManager.registerPlayer(player4);

        initiateMatchBetweenAnyTwoPlayers();
    }

    private static void initiateMatchBetweenAnyTwoPlayers() {
        int playerId1 = selectRandomId();
        int playerId2;
        do {
            playerId2 = selectRandomId();
        } while (playerId1 == playerId2);

        System.out.println("\n=== Initiating match between Player #" + playerId1 + " and Player #" + playerId2 + " ===");
        Optional<Player> winner = playerManager.initiateMatchBetween(playerId1, playerId2);
        if (winner.isPresent())
            System.out.println("\nThe winner is Player #" + winner.get().getId() + "!");
        else
            System.out.println("\nSorry, the match could not be conducted.");

    }

    private static int selectRandomId() {
        return (int) Math.ceil(Math.random() * playerManager.getPlayerCount());
    }
}
