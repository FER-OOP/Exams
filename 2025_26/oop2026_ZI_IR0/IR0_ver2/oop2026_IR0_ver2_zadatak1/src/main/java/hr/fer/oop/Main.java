package hr.fer.oop;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Territory england = new Territory("England", 100);
        Territory france  = new Territory("France", 80);
        Soldier s         = new Soldier("Infantry", 40, 0);
        Tank tank         = new Tank("Heavy Tank", 80, 0);

        // --- ATTACK 1: Infantry attacks England ---
        int roll1 = rand.nextInt(12) + 1;
        s.attack(england, roll1);
        // win:  England: 95  | Infantry defense: 40 | territories: 1
        // tie:  England: 95 or Infantry: 35 (weaker takes damage) | territories: 1 or 0
        // lose: England: 100 | Infantry defense: 35 | territories: 0
        System.out.println("After attack 1 — England: " + england.getDefenseLevel()
                + " | Infantry defense: " + s.getDefenseLevel()
                + " | territories: " + s.getTerritoriesOwned());

        // --- England defends, Infantry attacks again ---
        england.defend();
        // England defense: previous + 5, reinforced: true
        System.out.println("England reinforced: " + england.isReinforced() + " | defense: " + england.getDefenseLevel());

        s.attack(england, rand.nextInt(12) + 1);
        // England was reinforced so attack is ignored regardless of roll → reinforced: false, defense unchanged
        System.out.println("After attack 2 — England: " + england.getDefenseLevel()
                + " | reinforced: " + england.isReinforced()); // reinforced: false

        // --- Infantry tries to move ---
        s.move(3);
        // canMove() requires territories >= 2, so:
        // if territories == 0 or 1: canMove: false | fields: 0
        // if territories >= 2:      canMove: true  | fields: 3
        System.out.println("Infantry canMove: " + s.canMove() + " | fields: " + s.getFieldsMoved());

        // --- Tank attacks France ---
        tank.attack(france, rand.nextInt(12) + 1);
        // Tank rolls 1-12 +3 (max 12), wins on >= territoryRoll:
        // win:  France: 65 | Tank defense: 80 | territories: 1
        // lose: France: 80 | Tank defense: 79 | territories: 0
        System.out.println("After attack 3 — France: " + france.getDefenseLevel()
                + " | Tank defense: " + tank.getDefenseLevel()
                + " | territories: " + tank.getTerritoriesOwned());

        // --- Tank moves ---
        tank.move(2);
        // canMove() requires territories >= 1:
        // if territories == 0: canMove: false | fields: 0, defense unchanged
        // if territories >= 1: canMove: true  | fields: 0+2+2=4, defense: previous - 2
        System.out.println("Tank canMove: " + tank.canMove() + " | fields: " + tank.getFieldsMoved()
                + " | defense: " + tank.getDefenseLevel());
    }
}