package hr.fer.oop;

import java.util.Arrays;

public class Floor extends AbstractSpace {
  private Space[] spaces;
  private int numberOfSpaces;

  public Floor(String name, String location) {
    super(name);
    spaces = new Space[10];
    numberOfSpaces = 0;
    setLocation(location);
  }

  @Override
  public double getArea() {
    double totalArea = 0;
    for (Space space : spaces) {
      if (space != null) {
        totalArea += space.getArea();
      }
    }
    return totalArea;
  }

  public Space[] getSpaces() {
    return Arrays.copyOf(spaces, numberOfSpaces);
  }

  public boolean addSpace(Space space) {
    if (numberOfSpaces < spaces.length) {
      if(space instanceof Floor)
        return false;

      if(space instanceof AbstractSpace as)
        as.setLocation(getLocation());

      spaces[numberOfSpaces] = space;
      numberOfSpaces++;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "Floor [name=" + getName() + ", location=" + getLocation() + ", area=" + getArea() + "]";
  }
}
