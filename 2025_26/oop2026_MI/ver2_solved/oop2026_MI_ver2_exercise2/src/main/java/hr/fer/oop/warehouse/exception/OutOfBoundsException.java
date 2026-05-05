package hr.fer.oop.warehouse.exception;

public class OutOfBoundsException extends RobotException {

  private final int width;
  private final int height;
  private final int newX;
  private final int newY;

  public OutOfBoundsException(int width, int height, int newX, int newY) {
    super("Position (" + newX + "," + newY + ") is out of bounds for warehouse " + width + "x" + height);
    this.width = width;
    this.height = height;
    this.newX = newX;
    this.newY = newY;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getNewX() {
    return newX;
  }

  public int getNewY() {
    return newY;
  }

}
