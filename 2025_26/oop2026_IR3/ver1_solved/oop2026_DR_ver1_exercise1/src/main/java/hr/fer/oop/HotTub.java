package hr.fer.oop;

public class HotTub extends WaterFacility implements HeatedFacility {

    private boolean heatingOn;

    public HotTub(String name, double waterTemperature, int capacity) {
        super(name, waterTemperature, capacity);
        this.heatingOn = false;
    }

    @Override
    public void turnHeatingOn() {
        heatingOn = true;
    }

    @Override
    public void turnHeatingOff() {
        heatingOn = false;
    }

    @Override
    public boolean isHeatingOn() {
        return heatingOn;
    }


    public void heatWater(double amount) {
        if (heatingOn) {
            setWaterTemperature(getWaterTemperature() + amount);
        }
    }
}