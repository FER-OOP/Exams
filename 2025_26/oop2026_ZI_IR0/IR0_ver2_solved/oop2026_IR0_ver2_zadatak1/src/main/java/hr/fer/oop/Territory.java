package hr.fer.oop;

import java.util.Random;

public class Territory extends GameObject implements AttackUnit {
	 
    private boolean reinforced;
    private static final Random random = new Random();
 
    public Territory(String name, int defenseLevel) {
        super(name, defenseLevel);
        this.reinforced = false;
    }
 
    public boolean isReinforced() {
        return reinforced;
    }
 
    @Override
    public void weaken(int amount) {
        if (reinforced) {
            reinforced = false;
        } else {
            super.weaken(amount);
        }
    }
 
    @Override
    public void defend() {
        increaseDefenseLevel(5);
        reinforced = true;
    }
 
    @Override
    public void attack(Territory territory, int territoryRoll) {
        int myRoll = random.nextInt(12) + 1;
        if (myRoll > territoryRoll) {
            territory.weaken(5);
        } else if (myRoll == territoryRoll) {
            if (getDefenseLevel() >= territory.getDefenseLevel()) {
                territory.weaken(5);
            } else {
                weaken(5);
            }
        } else {
            weaken(3);
        }
    }
}