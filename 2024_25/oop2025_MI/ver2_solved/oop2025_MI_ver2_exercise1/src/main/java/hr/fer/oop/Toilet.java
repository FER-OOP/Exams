package hr.fer.oop;

public class Toilet extends AbstractSpace implements WaterAvailable {
  private double area;
  private ToiletType type;

  public Toilet(String name, double area, ToiletType type) {
    super(name);
    this.area = area;
    this.type = type;
  }

  @Override
  public double getArea() {
    return area;
  }

  public ToiletType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Toilet [name=" + getName() + ", location=" + getLocation() + ", area=" + area + ", type=" + type + "]";
  }

}
