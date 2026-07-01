package hr.fer.oop;

public class Carpet extends Product {
    private final String material;
    private final double area;

    public Carpet(String id, String name, double price, String material, double area) {
        super(id, name, price);
        this.material = material;
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Carpet{" + super.toString() + ", material=" + material + ", area=" + area + "}";
    }
}