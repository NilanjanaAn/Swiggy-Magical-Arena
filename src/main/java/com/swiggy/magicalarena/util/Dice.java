package com.swiggy.magicalarena.util;

/**
 * Dice entity for player attack and defense rolls
 */
public class Dice {

    /**
     * @return An integer between 1 and 6 representing the faces of dice
     */
    public static int rollDice() {
        return (int) Math.ceil(Math.random() * 6);
    }
}
