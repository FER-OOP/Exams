package hr.fer.oop.zad2;
import java.util.Objects;

public class BasketballPlayer {

    private String name;
    private String surname;
    private double pointsAvg;
    private double assistsAvg;
    private double reboundsAvg;
    private int position;

    public BasketballPlayer(String name, String surname, double pointsAvg, double assistsAvg, double reboundsAvg, int position) {
        this.name = name;
        this.surname = surname;
        this.pointsAvg = pointsAvg;
        this.assistsAvg = assistsAvg;
        this.reboundsAvg = reboundsAvg;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getPointsAvg() {
        return pointsAvg;
    }

    public double getAssistsAvg() {
        return assistsAvg;
    }

    public double getReboundsAvg() {
        return reboundsAvg;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketballPlayer that = (BasketballPlayer) o;
        return position == that.position && name.equals(that.name) && surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, position);
    }

    @Override
    public String toString() {
        return name + " " + surname + "(" + position + ")" + " [" + pointsAvg +  ", " + assistsAvg + ", " +  reboundsAvg + "]";
    }
}
