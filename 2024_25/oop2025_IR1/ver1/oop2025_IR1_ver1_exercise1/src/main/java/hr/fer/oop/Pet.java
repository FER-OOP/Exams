package hr.fer.oop;

public abstract class Pet {
    private String name;
    protected int happiness;

    public Pet(String name, int happiness) {
        this.name = name;
        this.happiness = happiness;
    }

    public int getHappiness() {
        return happiness;
    }
    
    public String getName() {
        return name;
    }
    
    public void play() {
        this.happiness += 5;
    }
}
