package hr.fer.oop.zi.z1;

public class PovertyDatum{

    @Override
    public String toString() {
        return "PovertyDatum{" +
                "location='" + location + '\'' +
                ", year=" + year +
                ", proportion=" + proportion +
                '}';
    }

    public PovertyDatum(PovertyDatum other) {
        this.location=other.location;
        this.year = other.year;
        this.proportion=other.proportion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public PovertyDatum(String location, int year, double proportion) {
        this.location = location;
        this.year = year;
        this.proportion = proportion;
    }

    private String location;
    private int year;
    private double proportion;

}
