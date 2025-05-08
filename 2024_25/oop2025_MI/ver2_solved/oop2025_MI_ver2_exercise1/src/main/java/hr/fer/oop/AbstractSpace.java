package hr.fer.oop;

public abstract class AbstractSpace implements Space {
  private String name;
  private String location;

  public AbstractSpace(String name) {
    this.name = name;
  }

  @Override
  public String getLocation() {
    return location;
  }

  protected void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String getName() {
    return name;
  }

}
