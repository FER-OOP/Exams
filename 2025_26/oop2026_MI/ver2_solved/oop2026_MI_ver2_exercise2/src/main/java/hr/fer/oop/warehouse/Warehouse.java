package hr.fer.oop.warehouse;

import java.util.Random;

import hr.fer.oop.warehouse.exception.OutOfBoundsException;

public class Warehouse {

  private static Random RNG = new Random();

  private String name;
  private int width;
  private int height;

  public Warehouse(String name, int width, int height) {
    this.name = name;
    this.width = width;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int scanAt(int x, int y) throws OutOfBoundsException {
    if (x < 0 || x >= width || y < 0 || y >= height) {
      throw new OutOfBoundsException(width, height, x, y);
    }
    return RNG.nextInt(0, width*height);
  }

  public void move(DeployedRobot robot, int moveX, int moveY) throws OutOfBoundsException {
    if (!robot.getWarehouse().equals(this))  {
      throw new IllegalArgumentException();
    }
    int newX = robot.getPosX() + moveX;
    int newY = robot.getPosY() + moveY;
    if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
      throw new OutOfBoundsException(width, height, newX, newY);
    }
    robot.setPosX(newX);
    robot.setPosY(newY);
  }

}
