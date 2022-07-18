package hr.fer.oop.ljir.zad2;

import java.util.Objects;

public class FootballPlayer {

    private String name;
    private String surname;
    private int shootingSkill;
    private int dribblingSkill;
    private int passingSkill;
    private int overallSkill;

    public FootballPlayer(String name, String surname, int shootingSkill, int dribblingSkill, int passingSkill) {
        this.name = name;
        this.surname = surname;
        this.shootingSkill = shootingSkill;
        this.dribblingSkill = dribblingSkill;
        this.passingSkill = passingSkill;
        overallSkill = (shootingSkill + dribblingSkill + passingSkill) / 3;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getShootingSkill() {
        return shootingSkill;
    }

    public int getDribblingSkill() {
        return dribblingSkill;
    }

    public int getPassingSkill() {
        return passingSkill;
    }

    public int getOverallSkill() {
        return overallSkill;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setShootingSkill(int shootingSkill) {
        this.shootingSkill = shootingSkill;
    }

    public void setDribblingSkill(int dribblingSkill) {
        this.dribblingSkill = dribblingSkill;
    }

    public void setPassingSkill(int passingSkill) {
        this.passingSkill = passingSkill;
    }

    public void setOverallSkill(int overallSkill) {
        this.overallSkill = overallSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayer that = (FootballPlayer) o;
        return name.equals(that.name) && surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return name + " " + surname + " - " + overallSkill;
    }
}
