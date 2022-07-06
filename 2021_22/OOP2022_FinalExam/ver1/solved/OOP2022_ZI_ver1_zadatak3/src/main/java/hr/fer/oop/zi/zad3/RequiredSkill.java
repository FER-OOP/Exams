package hr.fer.oop.zi.zad3;

public class RequiredSkill {

    private final String name;
    private double minimum;
    private double multiplier;

    public RequiredSkill(String name, double minimum, double multiplier) {
        this.name = name;
        this.minimum = minimum;
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public String getName() {
        return name;
    }

    
    
}