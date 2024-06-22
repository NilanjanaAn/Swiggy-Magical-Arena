package com.swiggy.magicalarena.gameplay;

import com.swiggy.magicalarena.util.Dice;

public class Match {
    Player player1;
    Player player2;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void conductMatch() {
        if (checkValidMatchup()) {
            Player winner = simulateMatch(player1.getHealth() <= player2.getHealth());
            System.out.println("\nThe winner is Player #" + winner.getId() + ".");
        }
    }

    private Player simulateMatch(boolean player1sTurn) {
        if (player1sTurn)
            System.out.println("\nPlayer #" + player1.getId() + " attacks first.");
        else
            System.out.println("\nPlayer #" + player2.getId() + " attacks first.");
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

        System.out.println("\nPlayer #" + attacker.getId() + " attacks and rolls " + attackerRoll + ". Player #" + defender.getId() + " defends and rolls " + defenderRoll + ".");
        System.out.println("Attack damage is " + attackerRoll + " x " + attacker.getAttack() + " = " + attackDamage + "." +
                " Defending strength is " + defenderRoll + " x " + defender.getStrength() + " = " + defendingStrength + ".");

        if (absoluteImpact <= 0)
            System.out.println("Player #" + defender.getId() + "'s health remains " + defender.getHealth() + ".");
        else {
            defender.setHealth(defender.getHealth() - absoluteImpact);
            System.out.println("Player #" + defender.getId() + "'s health reduced by " + absoluteImpact + " to " + defender.getHealth() + ".");
        }
    }

    private boolean checkValidMatchup() {
        if (!player1.isAlive() || !player2.isAlive()) {
            System.out.println("One or both players selected are not alive.");
            return false;
        }
        if (player1.getAttack() * 6 <= player2.getStrength() &&
                player2.getAttack() * 6 <= player1.getStrength()) {
            System.out.println("Invalid matchup," +
                    " Player #" + player1.getId() + " and Player #" + player2.getId() + " cannot inflict damage on each other.");
            return false;
        }
        return true;
    }
}
