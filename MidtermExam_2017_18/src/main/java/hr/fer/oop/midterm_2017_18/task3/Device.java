package hr.fer.oop.midterm_2017_18.task3;
public abstract class Device {
    private final String ID;
    private boolean isPoweredOn;

    public Device(String ID, boolean isPoweredOn){
        this.ID = ID;
        this.isPoweredOn = isPoweredOn;
    }

    public void switchPower(){
        this.isPoweredOn = !isPoweredOn;
    }

    public boolean isPoweredOn() {
        return isPoweredOn;
    }
}
