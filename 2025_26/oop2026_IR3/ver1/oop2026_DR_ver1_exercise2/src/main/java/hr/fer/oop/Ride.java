package hr.fer.oop;

public class Ride {

    private String startStation;
    private String endStation;
    private int durationMinutes;

    public Ride(String startStation, String endStation, int durationMinutes) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.durationMinutes = durationMinutes;
    }

    public String getStartStation() {
        return startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return startStation + " -> " + endStation + " (" + durationMinutes + " min)";
    }
}