package hr.fer.oop;

public class InvalidWeightException extends CatchLogException {

    private final double weightKg;

    public InvalidWeightException(int row, double weightKg) {
        super(row, "Invalid weight " + weightKg + " at row " + row);
        this.weightKg = weightKg;
    }

    public double getWeightKg() {
        return weightKg;
    }
}
