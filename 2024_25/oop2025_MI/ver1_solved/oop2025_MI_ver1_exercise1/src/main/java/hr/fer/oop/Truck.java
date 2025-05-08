package hr.fer.oop;

public class Truck extends AbstractVehicle {

  private double weight;
  private double loadCapacity;
  private Car[] cars = new Car[6];

  public Truck(String type, String carBrand, double weight, double loadCapacity) {
    super(type, carBrand);
    this.weight = weight;
    this.loadCapacity = loadCapacity;
  }

  @Override
  public double getWeight() {
    double totalWeight = weight;
    for (Car car : cars) {
      if (car != null) {
        totalWeight += car.getWeight();
      }
    }
    return totalWeight;
  }

  public boolean add(Car car) {
    if (car == null) {
      return false;
    }
    double carWeight = 0;
    for (int i = 0; i < cars.length; i++) {
      if (cars[i] == null) {
        if (carWeight + car.getWeight() > loadCapacity) {
          return false;
        }
        cars[i] = car;
        return true;
      } else {
        carWeight += cars[i].getWeight();
      }
    }
    return false;
  }

  protected Car[] getCars() {
    Car[] newArray = new Car[cars.length];
    for (int i = 0; i < cars.length; i++) {
      newArray[i] = cars[i];
    }
    return newArray;
  }

}
