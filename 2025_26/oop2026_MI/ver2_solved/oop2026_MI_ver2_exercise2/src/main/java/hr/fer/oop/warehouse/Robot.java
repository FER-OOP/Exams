package hr.fer.oop.warehouse;

public class Robot {

  private final String name;
  private int batteryCapacity;

  public Robot(String name, int batteryCapacity) {
    this.name = name;
    this.batteryCapacity = batteryCapacity;
  }

  public String getName() {
    return name;
  }

  public int getBatteryCapacity() {
    return batteryCapacity;
  }

  public void setBatteryCapacity(int batteryCapacity) {
    this.batteryCapacity = batteryCapacity;
  }

  public DeployedRobot deployAt(Warehouse warehouse, int startX, int startY, Direction startDirection) {
    if (warehouse == null) {
      throw new IllegalArgumentException("Warehouse cannot be null");
    }
    return new DeployedRobot(warehouse, this, startX, startY, startDirection);
  }

  public DeployedRobot deployAt(Warehouse warehouse, int startX, int startY) {
    return this.deployAt(warehouse, startX, startY, Direction.NORTH);
  }

  public DeployedRobot deployAt(Warehouse warehouse) {
    return this.deployAt(warehouse, 0, 0);
  }

}
