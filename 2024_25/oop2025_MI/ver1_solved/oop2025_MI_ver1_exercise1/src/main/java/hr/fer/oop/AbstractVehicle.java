package hr.fer.oop;

public abstract class AbstractVehicle implements Vehicle {
    private String type;
    private String carBrand;

    public AbstractVehicle(String type, String carBrand) {
        this.type = type;
        this.carBrand = carBrand;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getCarBrand() {
        return carBrand;
    }

    public abstract double getWeight();
}
