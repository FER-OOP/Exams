package hr.fer.oop.midterm_2017_18.task3;
public class Fridge extends RemoteAbs {
    private double temperature;

    public Fridge(String ID, boolean isPoweredOn, double temperature, boolean isRemoteSessionActive) {
        super(ID, isPoweredOn, isRemoteSessionActive);
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
