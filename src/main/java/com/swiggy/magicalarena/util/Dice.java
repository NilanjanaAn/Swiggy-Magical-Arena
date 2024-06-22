package com.swiggy.magicalarena.util;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    public static int rollDice() {
        return random.nextInt(6) + 1;
    }
}
