package hr.fer.oop;

public class Car extends AbstractVehicle {

  private double weight;

  public Car(String type, String carBrand, double weight) {
    super(type, carBrand);
    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }
}
