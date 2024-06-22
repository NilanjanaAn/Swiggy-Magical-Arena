package com.swiggy.magicalarena.gameplay;

/**
 * Player entity primarily defined by "health", "strength" and "attack" attributes
 */
public class Player {
    private int id;
    private int health;
    private int strength;
    private int attack;

    public Player() {
    }

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * This method checks whether the player is alive or dead.
     * The player is considered alive when the health stat is greater than 0, else considered dead.
     *
     * @return A true or false value of player's alive state
     */
    public boolean isAlive() {
        return health > 0;
    }
}
