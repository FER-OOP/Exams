package hr.fer.oop;

public class Main {

  public static void main(String[] args) {
    // Create a Car instance
    Car car1 = new Car("Sedan", "BMW", 1500);
    Car car2 = new Car("SUV", "Audi", 1800);

    // Print car details
    System.out.println("Car 1: " + car1.getType() + ", " + car1.getCarBrand() + ", Weight: " + car1.getWeight());
    System.out.println("Car 2: " + car2.getType() + ", " + car2.getCarBrand() + ", Weight: " + car2.getWeight());

    // Create a CarDrivingTruck instance
    Truck truck = new Truck("Truck", "Mercedes", 3000, 5000);

    // Add cars to the truck
    System.out.println("Adding car1 to truck: " + truck.add(car1));
    System.out.println("Adding car2 to truck: " + truck.add(car2));

    // Print the total weight of the truck
    System.out.println("Total truck weight: " + truck.getWeight());

    // Create a GreenCar instance
    GreenCar greenCar = new GreenCar("Hatchback", "Tesla", 1200, EnergySource.ELECTRICITY);

    // Print GreenCar details
    System.out.println("GreenCar: " + greenCar.getType() + ", " + greenCar.getCarBrand() + ", Weight: " + greenCar.getWeight() + ", Energy Source: " + greenCar.getEnergySource());

    // Create a GreenCarDrivingTruck instance
    GreenTruck greenTruck = new GreenTruck("GreenTruck", "Volvo", 4000, 6000, EnergySource.BIOFUEL);

    // Add cars to the green truck
    System.out.println("Adding greenCar to greenTruck: " + greenTruck.add(greenCar));
    System.out.println("Adding car1 to greenTruck: " + greenTruck.add(car1));
    System.out.println("Adding car2 to greenTruck: " + greenTruck.add(car2));
    System.out.println("Adding Porsche to greenTruck: " + greenTruck.add(
        new Car("Coupe", "Porsche", 1600)));

    // Print the total weight of green cars in the green truck
    System.out.println("Total weight of green cars in greenTruck: " + greenTruck.getWeightOfGreenCars());
  }
}
