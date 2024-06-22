package com.swiggy.magicalarena;

import com.swiggy.magicalarena.util.Dice;

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
        int attackerRoll = Dice.rollDice();
        int defenderRoll = Dice.rollDice();

        int attackDamage = attackerRoll * attacker.getAttack();
        int defendingStrength = defenderRoll * defender.getStrength();
        int absoluteImpact = Math.min(attackDamage - defendingStrength, defender.getHealth());

        System.out.println("Player #" + attacker.getId() + " rolls " + attackerRoll + ". Player #" + defender.getId() + " rolls " + defenderRoll + ".");
        System.out.println("Attack damage is " + attackerRoll + " x " + attacker.getAttack() + " = " + attackDamage + "." +
                " Defending strength is " + defenderRoll + " x " + defender.getStrength() + " = " + defendingStrength + ".");

        if (absoluteImpact <= 0)
            System.out.println("Player #" + defender.getId() + "'s health remains " + defender.getHealth() + ".");
        else {
            defender.setHealth(defender.getHealth() - absoluteImpact);
            System.out.println("Player #" + defender.getId() + "'s health reduced by " + absoluteImpact + " to " + defender.getHealth() + ".");
        }

    }
}
