package com.swiggy.magicalarena.gameplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MatchTest {
    Player player1, player2;
    Match match;

    @Test
    void testConductMatchInvalidPlayerNotAlive() {
        player1 = new Player(0, 10, 10);
        player2 = new Player(5, 10, 10);
        match = new Match(player1, player2);

        assertNull(match.conductMatch());
    }

    @Test
    void testConductMatchInvalidPlayersCannotInflictDamage() {
        player1 = new Player(100, 30, 1);
        player2 = new Player(100, 6, 5);
        match = new Match(player1, player2);

        assertNull(match.conductMatch());
    }

    @Test
    void testConductMatchValid() {
        player1 = new Player(100, 50, 50);
        player2 = new Player(100, 10, 0);
        match = new Match(player1, player2);

        assertEquals(player1, match.conductMatch());
    }
}
