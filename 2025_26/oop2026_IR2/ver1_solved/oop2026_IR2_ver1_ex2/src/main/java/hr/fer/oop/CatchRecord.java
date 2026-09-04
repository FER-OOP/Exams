package hr.fer.oop;

public class CatchRecord {

    private final FishSpecies species;
    private final double weightKg;
    private final String location;

    public CatchRecord(FishSpecies species, double weightKg, String location) {
        this.species = species;
        this.weightKg = weightKg;
        this.location = location;
    }

    public FishSpecies getSpecies() {
        return species;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getLocation() {
        return location;
    }
}
