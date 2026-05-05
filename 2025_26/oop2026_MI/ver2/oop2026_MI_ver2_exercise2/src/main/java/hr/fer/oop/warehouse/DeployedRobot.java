package hr.fer.oop.warehouse;

public class DeployedRobot {
  private final Warehouse warehouse;
  private final Robot robot;

  private int posX;
  private int posY;
  private int batteryLevel;
  private Direction direction;

  public DeployedRobot(Warehouse warehouse, Robot robot, int posX,
      int posY, Direction startDirection) {
    this.warehouse = warehouse;
    this.robot = robot;
    this.batteryLevel = robot.getBatteryCapacity();
    this.direction = startDirection;
    this.posX = posX;
    this.posY = posY;
  }

  public void executeProgram(String program) {
    // TODO: Implement the interpreter for the robot commands passed as multi-line
    // string.
  }

  public int getBatteryLevel() {
    return batteryLevel;
  }

  public Warehouse getWarehouse() {
    return warehouse;
  }

  public Direction getCurrentDirection() {
    return direction;
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

}
