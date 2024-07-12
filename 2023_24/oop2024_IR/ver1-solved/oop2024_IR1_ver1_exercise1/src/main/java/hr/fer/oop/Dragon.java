package hr.fer.oop;

public class Dragon extends MagicalCreature implements FlyingCreature {

    public Dragon(String name, int energy, int power) {
        super(name, energy, power);
    }

    @Override
    public void performMagic() {
        super.energy -= 1;
        super.power -= 3;
    }

    @Override
    public void fly() {
        super.energy -= 5;
    }
}
