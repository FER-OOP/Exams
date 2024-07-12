package hr.fer.oop;

public abstract class Creature {

    private String name;
    protected int energy;

    public Creature(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void rest() {
         this.energy += 10;
    }
}
