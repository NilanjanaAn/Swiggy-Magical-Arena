package com.swiggy.magicalarena.util;

public class RandomPlayerIdSelector implements RandomNumberGenerator {

    public static int selectId(int playerCount) {
        return random.nextInt(playerCount) + 1;
    }
}
