package hr.fer.oop;

public class IndustrialTrawler extends FishingTrawler {

    private int crewSize;

    public IndustrialTrawler(String name, String registrationCode, double lengthMeters, double fuelPercent, double cargoCapacityKg, int crewSize) {
        super(name, registrationCode, lengthMeters, fuelPercent, cargoCapacityKg);
        this.crewSize = crewSize;
    }

    public int getCrewSize() {
        return crewSize;
    }

    @Override
    public boolean canSail() {
        return super.canSail() && crewSize >= 3;
    }

    @Override
    public VesselStatus getStatus() {
        if (crewSize < 3) {
            return VesselStatus.UNDER_MAINTENANCE;
        }
        return super.getStatus();
    }
}
