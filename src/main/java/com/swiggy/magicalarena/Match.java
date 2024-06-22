package com.swiggy.magicalarena;

public class Match {
    Player player1;
    Player player2;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void conductMatch() {
        Player winner = null;
        winner = simulateMatch(player1.getHealth() <= player2.getHealth());
    }

    private Player simulateMatch(boolean player1sTurn) {
        while (player1.isAlive() && player2.isAlive()) {
            if (player1sTurn)
                turn(player1, player2);
            else
                turn(player2, player1);
            player1sTurn = !player1sTurn;
        }
        return player1.isAlive() ? player1 : player2;
    }

    private void turn(Player attacker, Player defender) {
        // gameplaying logic
    }
}
