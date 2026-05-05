package hr.fer.oop;

import hr.fer.oop.warehouse.DeployedRobot;
import hr.fer.oop.warehouse.Robot;
import hr.fer.oop.warehouse.Warehouse;
import hr.fer.oop.warehouse.exception.CompositeRobotException;
import hr.fer.oop.warehouse.exception.RobotException;

public class Main {

  private static String getExampleRobotProgram() {
    return """
        MOVE 3
        ROTATE EAST
        MOVE 3
        ROTATE SOUTH
        MOVE 2
        SCAN
        """;
  }

  private static String getProgramWithErrors() {
    return """
        MOVE 3

        ROTATE RIGHT
        LAUNCH
        MOVE 10
        SCAN
        """;
  }

  public static void main(String[] args) {
    Robot roby = new Robot("Roby", 100);
    Warehouse warehouseB = new Warehouse("B", 50, 50);
    DeployedRobot deployedRoby = roby.deployAt(warehouseB);
    // String program = getProgramWithErrors();
    String program = getExampleRobotProgram();
    try {
      deployedRoby.executeProgram(program);
    } catch (CompositeRobotException e) {
      System.out.println("Program finished with errors:");
      RobotException[] errors = e.getErrors();
      for (int i = 0; i < errors.length; i++) {
        if (errors[i] != null) {
          System.out.println("  Line " + (i + 1) + ": " + errors[i]);
        }
      }
    }
  }
}
