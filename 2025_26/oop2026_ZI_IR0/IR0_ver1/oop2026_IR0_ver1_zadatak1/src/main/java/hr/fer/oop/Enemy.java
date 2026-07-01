package hr.fer.oop;

public class Enemy extends Character {
 
	 
    public Enemy(String type, int health) {
        super(type, health);
    }
 
    public void bite(Character character) {
        if (character instanceof MainCharacter mc) {
            mc.increaseBittenTurns(1);
        }
    }
 
    @Override
    public String toString() {
        return "(" + super.getName() + ", health: " + getHealth() + ")";
    }

}
