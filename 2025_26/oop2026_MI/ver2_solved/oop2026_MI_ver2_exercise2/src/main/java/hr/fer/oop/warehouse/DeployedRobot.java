package hr.fer.oop.warehouse;

import hr.fer.oop.warehouse.exception.CompositeRobotException;
import hr.fer.oop.warehouse.exception.InvalidCommandException;
import hr.fer.oop.warehouse.exception.OutOfBoundsException;
import hr.fer.oop.warehouse.exception.OutOfEnergyException;
import hr.fer.oop.warehouse.exception.RobotException;

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

  public void executeProgram(String program) throws CompositeRobotException {
    if (program == null || program.isBlank()) {
      throw new IllegalArgumentException("Empty program!");
    }
    String[] lines = program.split(System.lineSeparator());
    RobotException[] errors = new RobotException[lines.length];
    boolean hasErrors = false;
    for (int lineIdx = 0; lineIdx < lines.length; ++lineIdx) {
      String line = lines[lineIdx].trim();
      if (line.isBlank()) {
        continue;
      }
      try {
        executeProgramLine(line);
      } catch (RobotException e) {
        errors[lineIdx] = e;
        hasErrors = true;
      }
    }
    if (hasErrors) {
      throw new CompositeRobotException(errors);
    }
  }

  private void executeProgramLine(String line) throws RobotException {
    String[] args = line.split(" ");
    if (args.length < 1) {
      return;
    }
    String commandName = args[0];
    if ("ROTATE".equals(commandName)) {
      doRotate(args);
    } else if ("MOVE".equals(commandName)) {
      doMove(args);
    } else if ("SCAN".equals(commandName)) {
      doScan(args);
    } else {
      throw new InvalidCommandException(commandName);
    }
  }

  private void doScan(String[] args) throws OutOfBoundsException, OutOfEnergyException {
    int scannedValue = this.warehouse.scanAt(posX, posY);
    if (this.batteryLevel < 1) {
      throw new OutOfEnergyException("SCAN", batteryLevel, 1);
    }
    this.batteryLevel -= 1;
    System.out.println("Robot " + robot.getName() + " at (" + posX + "," + posY
        + ") facing " + this.direction + " in " + warehouse.getName()
        + " scanned: " + scannedValue);
  }

  private void doMove(String[] args) throws RobotException {
    int numSteps = 1;
    if (args.length >= 2) {
      try {
        numSteps = Integer.parseInt(args[1]);
      } catch (NumberFormatException e) {
        throw new InvalidCommandException("MOVE " + args[1]);
      }
    }
    if (batteryLevel < numSteps) {
      throw new OutOfEnergyException("MOVE", batteryLevel, numSteps);
    }
    switch (this.direction) {
      case NORTH:
        this.warehouse.move(this, 0, numSteps);
        break;
      case SOUTH:
        this.warehouse.move(this, 0, -numSteps);
        break;
      case EAST:
        this.warehouse.move(this, numSteps, 0);
        break;
      case WEST:
        this.warehouse.move(this, -numSteps, 0);
        break;
      default:
        throw new IllegalStateException("The direction must be some value of the enum");
    }
    batteryLevel -= numSteps;
  }

  private void doRotate(String[] args) throws RobotException {
    try {
      if (args.length < 2) {
        throw new InvalidCommandException("ROTATE");
      }
      Direction newDirection;
      newDirection = Direction.valueOf(args[1].toUpperCase());
      int cost = rotationCost(direction, newDirection);
      if (batteryLevel < cost) {
        throw new OutOfEnergyException("ROTATE", batteryLevel, cost);
      }
      this.direction = newDirection;
      this.batteryLevel -= cost;
    } catch (IllegalArgumentException e) {
      throw new InvalidCommandException("ROTATE " + args[1]);
    } catch (RobotException e) {
      throw e;
    }
  }

  private int rotationCost(Direction from, Direction to) {
    if (from == to) {
      return 1;
    }
    boolean isOpposite = false;
    switch (from) {
      case EAST:
        isOpposite = to == Direction.WEST;
        break;
      case NORTH:
        isOpposite = to == Direction.SOUTH;
        break;
      case WEST:
        isOpposite = to == Direction.EAST;
        break;
      case SOUTH:
        isOpposite = to == Direction.NORTH;
        break;
      default:
        break;
    }
    return isOpposite ? 3 : 2;
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
