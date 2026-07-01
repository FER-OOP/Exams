package hr.fer.oop;

import java.util.Random;

public class Tank extends MovableUnit implements AttackUnit {
	 
    private static final Random random = new Random();
 
    public Tank(String name, int defenseLevel, int fieldsMoved) {
        super(name, defenseLevel, fieldsMoved);
    }
 
    @Override
    public boolean canMove() {
        return getTerritoriesOwned() >= 1;
    }
 
    @Override
    public void move(int fields) {
        if (canMove()) {
            addFields(fields + 2);
            weaken(2);
        }
    }
 
    @Override
    public void attack(Territory territory, int territoryRoll) {
        int myRoll = Math.min(random.nextInt(12) + 1 + 3, 12);
        if (myRoll >= territoryRoll) {
            territory.weaken(15);
            conquerTerritory();
        } else {
            weaken(1);
        }
    }
 
    @Override
    public void defend() {
        increaseDefenseLevel(8);
    }
}