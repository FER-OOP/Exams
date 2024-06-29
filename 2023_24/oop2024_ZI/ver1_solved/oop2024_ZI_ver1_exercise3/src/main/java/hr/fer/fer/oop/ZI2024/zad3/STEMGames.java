package hr.fer.oop.ZI2024.zad3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class STEMGames {

	private List<Student> students = new ArrayList<>();

	public void addStudent(String name, int pointsEng, int pointsMath) {
		students.add(new Student(name, pointsEng, pointsMath));
	}

	public List<Student> getStudents() {
		return students;
	}

	// KK: Može se lako riješiti i bez streamova, ali s više koda
	public int getHighestScoreInEng() {
		return students.stream().mapToInt(s -> s.getPointsEng()).max().getAsInt();
	}
	
	public int getHighestScoreInMath() {
		return students.stream().mapToInt(s -> s.getPointsMath()).max().getAsInt();
	}
	
	public int getHighestScoreInTotal() {
		return students.stream().mapToInt(s -> s.getTotalPoints()).max().getAsInt();
	}
	
	public Map<String, List<String>> getTopStudents() {
		List<String> lmath = new ArrayList<>();
		List<String> leng = new ArrayList<>();
		List<String> ltotal = new ArrayList<>();
		Map<String, List<String>> mbeststudents = new HashMap<>();
		
		int highesteng = getHighestScoreInEng();
		int highestmath = getHighestScoreInMath();
		int highesttotal = getHighestScoreInTotal();
		
		for (Student student : students) {
			if (student.getPointsEng() == highesteng) leng.add(student.getName());
			if (student.getPointsMath() == highestmath) lmath.add(student.getName());
			if (student.getTotalPoints() == highesttotal) ltotal.add(student.getName());
		}
		
		mbeststudents.put("math", lmath);
		mbeststudents.put("eng", leng);
		mbeststudents.put("total", ltotal);
		
		return mbeststudents;
	}
}
