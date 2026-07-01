package hr.fer.oop;

import java.util.Random;

public class Territory extends GameObject {
	 
    private boolean reinforced;
    private static final Random random = new Random();
 
    public Territory(String name, int defenseLevel) {
    	super(name, defenseLevel);
        this.reinforced = false;
    }
 
 
    
}