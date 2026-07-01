package hr.fer.oop;

public class MainCharacter extends Character implements CombatUnit{
  
	private int bittenTurns;
	 
    public MainCharacter(String name, int health) {
        super(name, health);
        this.bittenTurns = 0;
    }
 
    public int getBittenTurns() {
        return bittenTurns;
    }
 
    public void increaseBittenTurns(int amount) {
        bittenTurns += amount;
    }
 
    public void craftMedkit() {
        if (bittenTurns > 0) {
            bittenTurns--;
            System.out.println("No healing, bites remaining: " + bittenTurns);
        } else {
            increaseHealth(15);
        }
    }
 
    @Override
    public void fight(Character character) {
        loseHealth(2);
        if (character instanceof Runner) {
            character.loseHealth(20);
        } else if (character instanceof Stalker) {
            character.loseHealth(10);
        } else {
            character.loseHealth(5);
        }
    }

}
