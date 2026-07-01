package hr.fer.oop;

public class Player extends GameObject{
	
	private int territoriesOwned;
 
    public Player(String name, int defenseLevel) {
    	super(name, defenseLevel);
    	this.territoriesOwned = 0;
    }
 
    public int getTerritoriesOwned() {
        return territoriesOwned;
    }
     
    public void conquerTerritory() {
        territoriesOwned++;
        System.out.println(getName() + " conquered a territory! Total: " + territoriesOwned);
    }
}
