package hr.fer.oop.midterm_2017_18.task3;


public class Bulb extends RemoteAbs {

    private Color color;

    public Bulb(String ID, boolean isPoweredOn, Color color, boolean isRemoteSessionActive) {
        super(ID, isPoweredOn, isRemoteSessionActive);
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
