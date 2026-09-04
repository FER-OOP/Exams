package hr.fer.oop;

public class FishingTrawler extends Vessel implements SeaWorthy {

    private double cargoCapacityKg;
    private double currentCatchKg;

    public FishingTrawler(String name, String registrationCode, double lengthMeters, double fuelPercent, double cargoCapacityKg) {
        super(name, registrationCode, lengthMeters, fuelPercent);
        this.cargoCapacityKg = cargoCapacityKg;
        this.currentCatchKg = 0;
    }

    public double getCargoCapacityKg() {
        return cargoCapacityKg;
    }

    public double getCurrentCatchKg() {
        return currentCatchKg;
    }

    public boolean addCatch(double kg) {
        if (kg <= 0) {
            return false;
        }
        if (currentCatchKg + kg > cargoCapacityKg) {
            return false;
        }
        currentCatchKg += kg;
        return true;
    }

    @Override
    public boolean canSail() {
        return currentCatchKg < cargoCapacityKg && hasFuel();
    }

    @Override
    public VesselStatus getStatus() {
        VesselStatus base = super.getStatus();
        if (base == VesselStatus.AT_SEA && currentCatchKg >= 0.9 * cargoCapacityKg) {
            return VesselStatus.DOCKED;
        }
        return base;
    }
}
