package hr.fer.oop;

public class Sauna extends WellnessFacility implements HeatedFacility {

    private boolean heatingOn;

    public Sauna(String name) {
        super(name);
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

    @Override
    public void use() {
        if (heatingOn) {
            super.use();
        }
    }
}