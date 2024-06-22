package com.swiggy.magicalarena.gameplay;

import com.swiggy.magicalarena.util.Dice;

/**
 * An entity representing a match between two players
 */
public class Match {
    Player player1;
    Player player2;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * This method conducts a match between the players after checking if the matchup is valid.
     * As per the rules of the game, the player with lower health must attack first.
     *
     * @return The winning player if a match was conducted, otherwise, a null value
     */
    public Player conductMatch() {
        showInitialPlayerStats();
        if (checkValidMatchup())
            return simulateMatch(player1.getHealth() <= player2.getHealth());
        return null;
    }

    /**
     * This method simulates the turn-by-turn gameplay during the match until one player dies.
     * The attacker and defender are swapped after each turn.
     *
     * @param player1sTurn A true or false value representing whether player1 shall attack first
     * @return The winning player
     */
    private Player simulateMatch(boolean player1sTurn) {
        if (player1sTurn)
            System.out.println("\n>> Player #" + player1.getId() + " attacks first.");
        else
            System.out.println("\n>> Player #" + player2.getId() + " attacks first.");
        while (player1.isAlive() && player2.isAlive()) {
            if (player1sTurn)
                turn(player1, player2);
            else
                turn(player2, player1);
            player1sTurn = !player1sTurn;
        }
        return player1.isAlive() ? player1 : player2;
    }

    /**
     * This method uses the rules of the game to find the outcome of a single turn.
     * Attacking player rolls the attacking dice and the defending player rolls the defending dice.
     * The "attack" value multiplied by the outcome of the attacking dice roll is the damage created by the attacker.
     * The defender "strength" value, multiplied by the outcome of the defending dice is the damage defended by the defender.
     * Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the "health" of the defender.
     *
     * @param attacker The player who will attack during this turn
     * @param defender The player who will defend during this turn
     */
    private void turn(Player attacker, Player defender) {
        int attackerRoll = Dice.rollDice();
        int defenderRoll = Dice.rollDice();

        int attackDamage = attackerRoll * attacker.getAttack();
        int defendingStrength = defenderRoll * defender.getStrength();
        int absoluteImpact = Math.min(attackDamage - defendingStrength, defender.getHealth());

        System.out.println("\n>> Player #" + attacker.getId() + " attacks and rolls " + attackerRoll + ". Player #" + defender.getId() + " defends and rolls " + defenderRoll + ".");
        System.out.println("   Attack damage is " + attackerRoll + " x " + attacker.getAttack() + " = " + attackDamage + "." +
                " Defending strength is " + defenderRoll + " x " + defender.getStrength() + " = " + defendingStrength + ".");

        if (absoluteImpact <= 0)
            System.out.println("   Player #" + defender.getId() + "'s health remains " + defender.getHealth() + ".");
        else {
            defender.setHealth(defender.getHealth() - absoluteImpact);
            System.out.println("   Player #" + defender.getId() + "'s health reduced by " + absoluteImpact + " to " + defender.getHealth() + ".");
        }
    }

    /**
     * This method validates the players' stats before the initiation of a match.
     * It ensures that both players are alive.
     * It also ensures that at least one of the players is able to inflict damage on the other, preventing an infinite fruitless battle.
     *
     * @return A true or false value representing whether the match can be conducted
     */
    private boolean checkValidMatchup() {
        if (!player1.isAlive() || !player2.isAlive()) {
            System.out.println("\nOne or both players selected are not alive.");
            return false;
        }
        if (player1.getAttack() * 6 <= player2.getStrength() &&
                player2.getAttack() * 6 <= player1.getStrength()) {
            System.out.println("\nInvalid matchup," +
                    " Player #" + player1.getId() + " and Player #" + player2.getId() + " cannot inflict damage on each other.");
            return false;
        }
        return true;
    }

    /**
     * This method displays the initial stats of the two players before the match.
     */
    private void showInitialPlayerStats() {
        System.out.println("\nStats\n-----------------------------------------");
        System.out.format("Player #%-15s\tPlayer #%-15s\n", player1.getId(), player2.getId());
        System.out.format("\tHealth: %-15s\tHealth: %-15s\n", player1.getHealth(), player2.getHealth());
        System.out.format("\tStrength: %-13s\tStrength: %-15s\n", player1.getStrength(), player2.getStrength());
        System.out.format("\tAttack: %-15s\tAttack: %-15s\n", player1.getAttack(), player2.getAttack());
    }
}
