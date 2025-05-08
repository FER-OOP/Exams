package hr.fer.oop;

public class ClassroomWithWater extends Classroom implements WaterAvailable {

  public ClassroomWithWater(String name, double area, int numberOfStudents) {
    super(name, area, numberOfStudents);
  }

  @Override
  public String toString() {
    return "ClassroomWithWater [name=" + getName() + ", location=" + getLocation() + ", area=" + getArea() + ", numberOfStudents=" + getNumberOfStudents() +  "]";
  }

}
