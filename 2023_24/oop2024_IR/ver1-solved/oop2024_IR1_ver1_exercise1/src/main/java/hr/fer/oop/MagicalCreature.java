package hr.fer.oop;

public abstract class MagicalCreature extends Creature {

    protected int power;

    public MagicalCreature(String name, int energy, int power) {
        super(name, energy);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public abstract void performMagic();

    @Override
    public void rest() {
        super.rest();
        this.power += 10;
    }
}
