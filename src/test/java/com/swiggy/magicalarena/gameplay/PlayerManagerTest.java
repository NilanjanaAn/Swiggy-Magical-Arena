package com.swiggy.magicalarena.gameplay;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerManagerTest {
    private final PlayerManager playerManager = PlayerManager.INSTANCE;

    @Test
    @Order(1)
    public void testGetPlayerCountEmpty() {
        assertEquals(0, playerManager.getPlayerCount());
    }

    @Order(2)
    @Test
    public void testRegisterPlayerAndGetPlayerCountNonEmpty() {
        Player player1 = new Player(100, 10, 10);
        playerManager.registerPlayer(player1);
        Player player2 = new Player(100, 10, 10);
        playerManager.registerPlayer(player2);

        assertEquals(2, playerManager.getPlayerCount());
    }
}
