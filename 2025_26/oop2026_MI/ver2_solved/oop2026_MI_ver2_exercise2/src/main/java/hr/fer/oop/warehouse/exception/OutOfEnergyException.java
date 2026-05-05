package hr.fer.oop.warehouse.exception;

public class OutOfEnergyException extends RobotException {

  private final String command;
  private final int batteryLevel;
  private final int requiredEnergy;

  public OutOfEnergyException(String command, int batteryLevel, int requiredEnergy) {
    super("Not enough energy for " + command + ": has " + batteryLevel + ", needs " + requiredEnergy);
    this.command = command;
    this.batteryLevel = batteryLevel;
    this.requiredEnergy = requiredEnergy;
  }

  public String getCommand() {
    return command;
  }

  public int getBatteryLevel() {
    return batteryLevel;
  }

  public int getRequiredEnergy() {
    return requiredEnergy;
  }

}
