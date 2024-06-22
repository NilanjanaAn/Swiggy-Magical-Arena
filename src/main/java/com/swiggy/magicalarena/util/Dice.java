package com.swiggy.magicalarena.util;

public class Dice implements RandomNumberGenerator {

    public static int rollDice() {
        return random.nextInt(6) + 1;
    }
}
