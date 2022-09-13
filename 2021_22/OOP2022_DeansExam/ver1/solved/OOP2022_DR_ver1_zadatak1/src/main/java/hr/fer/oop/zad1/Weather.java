package hr.fer.oop.zad1;

public abstract class Weather implements Calculation {
    private double[] data;
    private Unit unit;

    public Weather(double[] data, Unit unit) {
        this.data = data;
        this.unit=unit;
    }

    public  double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public abstract boolean avgAboveThold(double thold);
}
