package hr.fer.oop.task4;

public class Car {

    private final String manufacturer;
    private final String model;
    private final int manufacturingYear;

    public Car(String manufacturer, String model, int manufacturingYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }
    
    @Override
    public String toString() {
    	return String.format("%s %s %d", manufacturer, model, manufacturingYear);
    }
}
