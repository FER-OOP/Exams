package hr.fer.oop;

public class ResearchVessel extends Vessel implements SeaWorthy {

    private boolean calibrationInProgress;

    public ResearchVessel(String name, String registrationCode, double lengthMeters, double fuelPercent, boolean calibrationInProgress) {
        super(name, registrationCode, lengthMeters, fuelPercent);
        this.calibrationInProgress = calibrationInProgress;
    }

    public boolean isCalibrationInProgress() {
        return calibrationInProgress;
    }

    public void startCalibration() {
        calibrationInProgress = true;
    }

    public void stopCalibration() {
        calibrationInProgress = false;
    }

    @Override
    public boolean canSail() {
        return !calibrationInProgress && hasFuel();
    }

    @Override
    public VesselStatus getStatus() {
        if (calibrationInProgress) {
            return VesselStatus.UNDER_MAINTENANCE;
        }
        return super.getStatus();
    }
}
