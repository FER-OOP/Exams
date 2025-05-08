package hr.fer.oop;

public class Classroom extends AbstractSpace {
  private int numberOfStudents;
  private double area;

  public Classroom(String name, double area, int numberOfStudents) {
    super(name);
    this.area = area;
    this.numberOfStudents = numberOfStudents;
  }

  @Override
  public double getArea() {
    return area;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  @Override
  public String toString() {
    return "Classroom [name=" + getName() + ", location=" + getLocation() + ", area=" + area + ", numberOfStudents=" + numberOfStudents + "]";
  }

}
