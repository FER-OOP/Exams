package hr.fer.oop;

public abstract class WaterFacility extends WellnessFacility {

    private double waterTemperature;
    private int capacity;

    public WaterFacility(String name, double waterTemperature, int capacity) {
        super(name);
        this.waterTemperature = waterTemperature;
        this.capacity = capacity;
    }

    public double getWaterTemperature() {
        return waterTemperature;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setWaterTemperature(double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }
}