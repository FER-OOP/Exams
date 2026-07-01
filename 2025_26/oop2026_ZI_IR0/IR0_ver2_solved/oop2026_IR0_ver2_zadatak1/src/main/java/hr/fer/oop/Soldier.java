package hr.fer.oop;

import java.util.Random;

public class Soldier extends MovableUnit implements AttackUnit {
	 
    private static final Random random = new Random();
 
    public Soldier(String name, int defenseLevel, int fieldsMoved) {
        super(name, defenseLevel, fieldsMoved);
    }
 
    @Override
    public boolean canMove() {
        return getTerritoriesOwned() >= 2;
    }
 
    @Override
    public void move(int fields) {
        if (canMove()) {
            addFields(fields);
        }
    }
 
    @Override
    public void attack(Territory territory, int territoryRoll) {
        int myRoll = random.nextInt(12) + 1;
        if (myRoll > territoryRoll) {
            territory.weaken(5);
            conquerTerritory();
        } else if (myRoll == territoryRoll) {
            if (getDefenseLevel() >= territory.getDefenseLevel()) {
                territory.weaken(5);
                conquerTerritory();
            } else {
                weaken(5);
            }
        } else {
            weaken(5);
        }
    }
 
    @Override
    public void defend() {
        increaseDefenseLevel(3);
    }
}