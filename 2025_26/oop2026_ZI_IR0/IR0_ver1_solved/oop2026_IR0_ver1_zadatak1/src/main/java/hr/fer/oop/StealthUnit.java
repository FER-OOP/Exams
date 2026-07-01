package hr.fer.oop;

public abstract class StealthUnit extends Enemy {
 
	private boolean stealthy;
	 
    public StealthUnit(String type, int health) {
        super(type, health);
        this.stealthy = false;
    }
 
    public abstract int getStealthLevel();
 
    public boolean isStealthy() {
        return stealthy;
    }
 
    public abstract void hide() ;
 
    public void toggleStealth() {
        stealthy = !stealthy;
    }
}
