package hr.fer.oop;

public abstract class Vessel {

    private String name;
    private String registrationCode;
    private double lengthMeters;
    private double fuelPercent;

    public Vessel(String name, String registrationCode, double lengthMeters, double fuelPercent) {
        this.name = name;
        this.registrationCode = registrationCode;
        this.lengthMeters = lengthMeters;
        this.fuelPercent = fuelPercent;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public double getLengthMeters() {
        return lengthMeters;
    }

    public double getFuelPercent() {
        return fuelPercent;
    }

    protected boolean hasFuel() {
        return fuelPercent > 0;
    }

    public VesselStatus getStatus() {
        if (!hasFuel()) {
            return VesselStatus.UNDER_MAINTENANCE;
        } else if (fuelPercent < 15) {
            return VesselStatus.DOCKED;
        } else {
            return VesselStatus.AT_SEA;
        }
    }
}
