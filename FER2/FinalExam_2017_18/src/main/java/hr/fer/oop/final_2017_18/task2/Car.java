package hr.fer.oop.final_2017_18.task2;

import java.util.Comparator;

public class Car implements Comparable<Car> {

    private String manufacturer;
    private String model;
    private String id;
    private float power;
    Politician owner;

    public Car(String manufacturer, String model, String id, float power, Politician owner) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.id = id;
        this.power = power;
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        return ((this.id == null) ? 0 : id.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car other = (Car) obj;
            return (this.id == null) ? false : (this.id.compareTo(other.id) == 0);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Car other) {
        return this.getId().compareTo(other.getId());
    }

    public static final Comparator<Car> BY_MANUFACTURER = (j1, j2) -> j1.getManufacturer().compareTo(j2.getManufacturer());
    public static final Comparator<Car> BY_MODEL = (j1, j2) -> j1.getModel().compareTo(j2.getModel());
    public static final Comparator<Car> BY_ID = (j1, j2) -> j1.getId().compareTo(j2.getId());
    public static final Comparator<Car> BY_POWER = (j1, j2) -> Float.compare(j1.power, j2.power);
    public static final Comparator<Car> BY_OWNER = (j1, j2) -> j1.getOwner().compareTo(j2.getOwner());

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public Politician getOwner() {
        return owner;
    }

    public void setOwner(Politician owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" + "manufacturer=" + manufacturer + ", model=" + model + ", id=" + id + ", power=" + power + ", owner=" + owner + '}';
    }

}
