package hr.fer.oop;

public class ParseResultRowException extends ParseResultException {
  private int row;

  public ParseResultRowException(int row) {
    this.row = row;
  }

  public ParseResultRowException(int row, String message) {
    super(message);
    this.row = row;
  }

  public int getRow() {
    return row;
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();
    return message != null ? message + " in row " + row : "exception in row " + row;
  }
}
