package hr.fer.oop.midterm_2017_18.task3;
public class TV extends Device {
    private final int screenSize;

    public TV(String ID, boolean isPoweredOn, int size) {
        super(ID, isPoweredOn);
        this.screenSize = size;
    }
}
