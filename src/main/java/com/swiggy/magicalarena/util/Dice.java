package com.swiggy.magicalarena.util;

public class Dice {

    public static int rollDice() {
        return (int) Math.ceil(Math.random() * 6);
    }
}
