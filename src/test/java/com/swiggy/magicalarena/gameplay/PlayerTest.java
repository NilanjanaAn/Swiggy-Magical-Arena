package com.swiggy.magicalarena.gameplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PlayerTest {

    Player player = new Player();

    @Test
    void testIsAliveTrue() {
        player.setHealth(100);
        assertTrue(player.isAlive());
    }

    @Test
    void testIsAliveFalse() {
        player.setHealth(0);
        assertFalse(player.isAlive());
    }
}
