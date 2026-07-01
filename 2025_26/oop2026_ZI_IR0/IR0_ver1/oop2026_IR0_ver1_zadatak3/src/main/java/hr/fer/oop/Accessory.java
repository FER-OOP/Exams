package hr.fer.oop;

public class Accessory extends Product {
    private final boolean washable;

    public Accessory(String id, String name, double price, boolean washable) {
        super(id, name, price);
        this.washable = washable;
    }

    public boolean isWashable() {
        return washable;
    }

    @Override
    public String toString() {
        return "Accessory{" + super.toString() + ", washable=" + washable + "}";
    }
}