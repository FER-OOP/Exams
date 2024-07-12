package hr.fer.oop;

public class Bee extends Creature implements FlyingCreature {

    public Bee(String name, int energy) {
        super(name, energy);
    }
        
    public void collectHoney() {
        super.energy -= 2;
    }

    @Override
    public void fly() {
        super.energy -= 5;
    }    
}
