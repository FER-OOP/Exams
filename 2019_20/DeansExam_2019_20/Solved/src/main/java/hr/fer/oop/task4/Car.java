package hr.fer.oop.task4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Car implements Comparable<Car> {
  private String registration;
  private String manufacturer;
  private String model;
  private int engine;
  private String equipment;

  public String getRegistration() {
    return registration;
  }
  /* Getteri i setteri */

  public Car(String t_reg, String t_man, String t_mod, int t_eng, String t_equ) {
    this.registration = t_reg;
    this.manufacturer = t_man;
    this.model = t_mod;
    this.engine = t_eng;
    this.equipment = t_equ;
  }

  public String toString() {
    return "REG:" + registration + ", MAN:" + manufacturer + ", MOD:" + model + ", ENG:" + engine +
        ", EQU:" + equipment;
  }

  /* Implementacija prirodnog poretka */
  @Override
  public int compareTo(Car other) {
    int retval1 = this.manufacturer.compareTo(other.manufacturer);
    if (retval1 != 0) {
      return retval1;
    }
    int retval2 = this.model.compareTo(other.model);
    if (retval2 != 0) {
      return retval2;
    }
    return this.registration.compareTo(other.registration);
  }

  /* Metode potrebne za ispravno korištenje u kolecijama */
  @Override
  public int hashCode() {
    return this.registration.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Car)) {
      return false;
    }
    Car other = (Car) obj;
    return this.registration.equals(other.registration);
  }

  public static Comparator<Car> BY_REG = (c1, c2) -> c1.registration.compareTo(c2.registration);
  public static Comparator<Car> BY_ENG = (c1, c2) -> Integer.compare(c1.engine, c2.engine);


  public static void main(String[] args) {
    Car[] cars = new Car[10];
    /* Punjenje polja elementima */
    cars[0] = new Car("ZG6223DJ", "Toyota", "Yaris", 1500, "None");
    cars[1] = new Car("ZG0001AA", "Citroen", "C4", 1600, "None");
    cars[2] = new Car("ZG0002AB", "Toyota", "Auris", 2000, "None");
    cars[3] = new Car("ZG0003AC", "Toyota", "Yaris", 1300, "None");
    cars[4] = new Car("ZG0004AD", "Toyota", "R4", 2500, "None");
    cars[5] = new Car("ZG0005AE", "Citroen", "C3", 1400, "None");
    cars[6] = new Car("ZG0006AF", "Citroen", "C4", 2000, "None");
    cars[7] = new Car("ZG0007AG", "Volswagen", "Golf", 1800, "None");
    cars[8] = new Car("ZG0008AH", "Volkswagen", "Golf", 2000, "None");
    cars[9] = new Car("ZG0009AI", "Citroen", "C5", 2000, "None");

    Map<String, Car> mCars = new HashMap<String, Car>();
    for (int i = 0; i < cars.length; i++) {
      mCars.put(cars[i].getRegistration(), cars[i]);
    }

    System.out.println("\nMAPA:");
    for (String reg : mCars.keySet()) {
      System.out.println(mCars.get(reg));
    }

    Set<Car> sCars = new TreeSet<Car>();
    for (int i = 0; i < cars.length; i++) {
      sCars.add(cars[i]);
    }

    System.out.println("\nSKUP - prirodni poredak:");
    for (Car car : sCars) {
      System.out.println(car);
    }

    Set<Car> sCars2 = new TreeSet<Car>(BY_REG);
    for (int i = 0; i < cars.length; i++) {
      sCars2.add(cars[i]);
    }

    System.out.println("\nSKUP - po registraciji:");
    for (Car car : sCars2) {
      System.out.println(car);
    }
  }
}
