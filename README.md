# ✨ Swiggy-Magical-Arena ⚔️

A Java Application to simulate a Match between two Players in a Magical Arena - Swiggy aSDE - Round 1 Coding Test

Submitted By: *Nilanjana Thakur* 😊

## Table of Contents

- [Problem Statement](#problem-statement)
- [Requirements](#requirements)
- [Compilation and Execution](#compilation-and-execution)
- [Testing](#testing)
- [Notes](#notes)

## Problem Statement

Design a Magical Arena. Every Player is defined by a "health" attribute, "strength" attribute and an "attack"
attribute - all positive integers. The player dies if his health attribute touches 0.

1. Any two players can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice
   and the defending player rolls the defending dice. The "attack" value multiplied by the outcome of the attacking dice
   roll is the damage created by the attacker. The defender "strength" value, multiplied by the outcome of the defending
   dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage
   defended by the defender will reduce the "health" of the defender. Game ends when any players health reaches 0.


2. Player with lower health attacks first at the start of a match.


3. Assume two players. Player A (50 health 5 strength 10 attack) and Player B (100 health 10 strength and 5 attack).
   Attacking die and Defending die are both 6 sided die with values ranging from 1 - 6.

   1. Player A attacks and rolls die. Die roll: 5. Player B defends and rolls die. Die roll: 2.

   2. Attack damage is 5 * 10 = 50; Defending strength = 10 * 2 = 20; Player B health reduced by 30 to 70.

   3. Player B attacks and rolls die. Die roll: 4. Player A defends and rolls die. Die Roll: 3.

   4. Attack damage is 4 * 5 = 20; Defending strength = 5 * 3 = 15; Player A health reduced by 5 to 45.

   5. And so on.

## Requirements

✔️ Java Development Kit JDK 19\
✔️ JUnit 5 (for testing)

## Compilation and Execution

### - From IDE UI 🖱️

> 1. Open the project from any IDE such as IntelliJ, Visual Studio Code, Eclipse, etc.
>
>
>2. Navigate to the main class (the class containing the main method): **src > main > java > com.swiggy.magicalarena >
    MagicalArena.java**
>
>
>3. Click the run button on the UI.

### - From Command Line ⌨️

> 1. Navigate to the root directory: **Swiggy-Magical-Arena**
>
>
>2. Build the project:
    ```
    mvn clean install
    ```
>
>
>3. Run the application:
    ```
    java -cp target/classes com.swiggy.magicalarena.MagicalArena  
    ```

## Testing

The application includes unit tests to ensure the correctness of the implemented functionality.
> The tests can be run using the following command::
    ```
    mvn test
    ```

## Notes

- For simplicity, some players have been automatically registered to the arena and any two of them are chosen for a fight.


- This can be replaced by either a menu-driven logic for manual user input (for console-based systems), or a frontend UI
for registering players and selecting two players for the match, which have been excluded from the scope of this
project.
    