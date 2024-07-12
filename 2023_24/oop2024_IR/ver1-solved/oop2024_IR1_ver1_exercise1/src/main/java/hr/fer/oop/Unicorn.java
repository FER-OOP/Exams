package hr.fer.oop;

public class Unicorn extends MagicalCreature {

    public Unicorn(String name, int energy, int power) {
        super(name, energy, power);
    }

    @Override
    public void performMagic() {
        super.energy -= 2;
        super.power -= 4;
    }

    public void gallop() {
        super.energy -= 3;
    }
}
