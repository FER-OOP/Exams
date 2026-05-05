package hr.fer.oop.warehouse.exception;

public class CompositeRobotException extends RobotException {

  private final RobotException[] errors;

  public CompositeRobotException(RobotException[] errors) {
    super(constructMessage(errors));
    this.errors = errors;
  }

  public RobotException[] getErrors() {
    return errors;
  }

  private static String constructMessage(RobotException[] errors) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < errors.length; i++) {
      RobotException exception = errors[i];
      if (exception == null) {
        continue;
      }
      stringBuilder
        .append("Line ")
        .append(i + 1)
        .append(" threw: ")
        .append(exception.getMessage())
        .append(System.lineSeparator());
    }
    String message = stringBuilder.toString();
    if (message.isEmpty()) {
      return null;
    }
    return message;
  }

}
