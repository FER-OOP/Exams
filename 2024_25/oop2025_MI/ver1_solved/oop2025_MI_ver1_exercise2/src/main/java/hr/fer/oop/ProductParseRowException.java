package hr.fer.oop;

public class ProductParseRowException extends ProductParseException {

  private int row;

  public ProductParseRowException(int row) {
    this.row = row;
  }

  public ProductParseRowException(int row, String message) {
    super(message);
    this.row = row;
  }

  public int getRow() {
    return row;
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();
    return message != null ? message + " in row " + row: "exception in row " + row;
  }

}
