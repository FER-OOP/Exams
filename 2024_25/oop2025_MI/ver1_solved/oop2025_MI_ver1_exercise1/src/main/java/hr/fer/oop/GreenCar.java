package hr.fer.oop;

public class GreenCar extends Car implements Green {

    private EnergySource energySource;

    public GreenCar(String type, String carBrand, double weight, EnergySource energySource) {
        super(type, carBrand, weight);
        this.energySource = energySource;
    }

    @Override
    public EnergySource getEnergySource() {
        return energySource;
    }

}
