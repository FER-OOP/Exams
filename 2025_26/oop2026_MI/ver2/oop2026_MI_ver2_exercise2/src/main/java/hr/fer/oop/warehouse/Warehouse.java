package hr.fer.oop.warehouse;

import java.util.Random;

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

  // TODO: Finish this method
  public int scanAt(int x, int y) {
  }

  // TODO: Finish this method
  public void move(DeployedRobot robot, int moveX, int moveY) {
  }

}
