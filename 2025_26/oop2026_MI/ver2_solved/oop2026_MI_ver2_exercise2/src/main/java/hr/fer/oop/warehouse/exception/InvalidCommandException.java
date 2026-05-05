package hr.fer.oop.warehouse.exception;

public class InvalidCommandException extends RobotException {

  private final String command;

  public InvalidCommandException(String command) {
    super("Invalid command: " + command);
    this.command = command;
  }

  public String getCommand() {
    return command;
  }

}
