package hr.fer.oop;

public class Stalker extends StealthUnit implements CombatUnit {
	 
	 private int stealthLevel;
	 
	    public Stalker(String type, int health, int stealthLevel) {
	        super(type, health);
	        this.stealthLevel = stealthLevel;
	    }
	 
	    @Override
	    public int getStealthLevel() {
	        return stealthLevel;
	    }
	 
	    @Override
	    public void hide() {
	        stealthLevel++;
	    }

	    @Override
	    public void fight(Character character) {
	        if (isStealthy()) {
	            character.loseHealth(stealthLevel * 10);
	            super.bite(character);
	        } else {
	            character.loseHealth(10);
	        }
	        toggleStealth();
	    }
	 
	    @Override
	    public void loseHealth(int amount) {
	        if (!isStealthy()) {
	            super.loseHealth(amount);
	        }
	    }
}
