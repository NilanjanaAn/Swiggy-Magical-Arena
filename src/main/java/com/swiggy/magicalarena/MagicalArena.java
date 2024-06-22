package com.swiggy.magicalarena;

import com.swiggy.magicalarena.util.RandomPlayerIdSelector;

public class MagicalArena {
    private static final PlayerManager playerManager = PlayerManager.INSTANCE;

    public static void main(String[] args) {
        System.out.println("*************** Welcome to MAGICAL ARENA ***************\n");

        Player player1 = new Player(200, 40, 30);
        playerManager.registerPlayer(player1);

        Player player2 = new Player(150, 50, 25);
        playerManager.registerPlayer(player2);

        Player player3 = new Player(250, 20, 40);
        playerManager.registerPlayer(player3);

        Player player4 = new Player(100, 40, 60);
        playerManager.registerPlayer(player4);

        initiateFightBetweenAnyTwoPlayers();
    }

    private static void initiateFightBetweenAnyTwoPlayers() {
        int playerId1 = RandomPlayerIdSelector.selectId(playerManager.getPlayerCount());
        int playerId2;
        do {
            playerId2 = RandomPlayerIdSelector.selectId(playerManager.getPlayerCount());
        } while (playerId1 == playerId2);

        System.out.println("\n=== Initiating match between Player #"+playerId1+" and Player #"+playerId2+" ===");
        playerManager.initiateMatchBetween(playerId1, playerId2);
    }
}
