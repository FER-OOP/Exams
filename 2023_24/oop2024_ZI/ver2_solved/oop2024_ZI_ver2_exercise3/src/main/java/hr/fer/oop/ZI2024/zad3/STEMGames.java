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

	public int getTopEngStudentCount(int threshold) {
		return (int)students.stream().filter(s -> s.getPointsEng() >= threshold).count();
	}
	
	public int getTopMathStudentCount(int threshold) {
		return (int)students.stream().filter(s -> s.getPointsMath() >= threshold).count();
	}
	
	public int getTopTotalStudentCount(int threshold) {
		return (int)students.stream().filter(s -> s.getTotalPoints() >= threshold).count();
	}
	
	public Map<String, List<String>> getTopStudents() {
		List<String> lmath = new ArrayList<>();
		List<String> leng = new ArrayList<>();
		List<String> ltotal = new ArrayList<>();
		Map<String, List<String>> mbeststudents = new HashMap<>();
		
		for (Student student : students) {
			if (student.getPointsEng() >= 95) leng.add(student.getName());
			if (student.getPointsMath() >= 95) lmath.add(student.getName());
			if (student.getTotalPoints() >= 190) ltotal.add(student.getName());
		}
		
		mbeststudents.put("math", lmath);
		mbeststudents.put("eng", leng);
		mbeststudents.put("total", ltotal);
		
		return mbeststudents;
	}
}
