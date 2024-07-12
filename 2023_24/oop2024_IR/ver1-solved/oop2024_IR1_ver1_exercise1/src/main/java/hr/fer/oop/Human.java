package hr.fer.oop;

public class Human extends Creature {

    public Human(String name, int energy) {
        super(name, energy);
    }
    
    public void walk() {
        super.energy -= 2;
    }
        
    public void work() {
        super.energy -= 4;
    }
}
