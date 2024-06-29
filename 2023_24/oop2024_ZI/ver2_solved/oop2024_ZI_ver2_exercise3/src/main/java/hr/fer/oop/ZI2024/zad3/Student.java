package hr.fer.oop.ZI2024.zad3;

import java.util.Objects;

public class Student {
    private String name;
    private int pointsEng;
    private int pointsMath;

    public Student(String name, int pointsEng, int pointsMath) {
        this.name = name;
        this.pointsEng = pointsEng;
        this.pointsMath = pointsMath;
    }

	public String getName() {
		return name;
	}
			    
	public int getPointsEng() {
		return pointsEng;
	}
	
	public int getPointsMath() {
		return pointsMath;
	}
	
	public int getTotalPoints() {
        return pointsEng + pointsMath;
    }
		
    @Override
    public String toString() {
    	return String.format("Name: %s \tEng: %d\tMath: %d\tTotal: %d", name, pointsEng, pointsMath, getTotalPoints());
    }
}
