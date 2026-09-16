package hr.fer.oop;

public abstract class WellnessFacility {

    private String name;
    private int numberOfUses;

    public WellnessFacility(String name) {
        this.name = name;
        this.numberOfUses = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void use() {
        numberOfUses++;
    }
}