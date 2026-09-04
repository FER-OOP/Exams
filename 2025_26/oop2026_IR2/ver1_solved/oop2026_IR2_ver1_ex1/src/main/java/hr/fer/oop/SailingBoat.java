package hr.fer.oop;

public class SailingBoat extends Vessel implements SeaWorthy {

    private int crewCapacity;

    public SailingBoat(String name, String registrationCode, double lengthMeters, double fuelPercent, int crewCapacity) {
        super(name, registrationCode, lengthMeters, fuelPercent);
        this.crewCapacity = crewCapacity;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    @Override
    public boolean canSail() {
        return crewCapacity >= 1;
    }
}
