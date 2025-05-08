package hr.fer.oop;

public class GreenTruck extends Truck implements Green {

    private EnergySource energySource;

    public GreenTruck(String type, String carBrand, double weight, double maxLoad, EnergySource energySource) {
        super(type, carBrand, weight, maxLoad);
        this.energySource = energySource;
    }

    @Override
    public EnergySource getEnergySource() {
        return energySource;
    }

    public double getWeightOfGreenCars() {
        double totalWeight = 0;
        for (Car car : getCars()) {
            if (car instanceof GreenCar) {
                totalWeight += car.getWeight();
            }
        }
        return totalWeight;
    }
}
