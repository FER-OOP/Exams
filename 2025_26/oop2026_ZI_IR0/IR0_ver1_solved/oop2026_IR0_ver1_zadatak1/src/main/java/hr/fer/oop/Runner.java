 package hr.fer.oop;

public class Runner extends Enemy implements CombatUnit{
 
	 private boolean enraged;
	 
	    public Runner(String type, int health) {
	        super(type, health);
	        this.enraged = false;
	    }
	 
	    public void rage() {
	        enraged = true;
	    }
	 
	    @Override
	    public void bite(Character character) {
      
        	if (enraged) {
        		super.bite(character);
        		super.bite(character);
        	} else {
        		super.bite(character);
        	}
        	
	    }
	    
	 
	    @Override
	    public void fight(Character character) {
	        if (enraged) {
	            loseHealth(4);
	            character.loseHealth(20);
	        } else {
	            loseHealth(2);
	            character.loseHealth(10);
	        }
	        bite(character);
	    }

}
