package hr.fer.oop.finalexam_2018_19.task2;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	private String jmbag;
	private String firstname;
	private String surname;
	private Double avgGrade;

	public Student(String jmbag, String firstname, String surname, Double avgGrade) {
		this.jmbag = jmbag;
		this.firstname = firstname;
		this.surname = surname;
		this.avgGrade = avgGrade;
	}

	public String getJmbag() {
		return jmbag;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public Double getAvgGrade() {
		return avgGrade;
	}

	@Override
	public String toString() {
		return "Student: " + jmbag + ", " + firstname + " " + surname + ", " + avgGrade;
	}

	// TO DO
	@Override
	public int hashCode() {
		return this.jmbag.hashCode();
	}

	// TO DO
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		return this.jmbag.equals(other.jmbag);
	}

	// TO DO
	@Override
	public int compareTo(Student other) {
		return this.jmbag.compareTo(other.jmbag);
	}

	// TO DO
	public static final Comparator<Student> AVG_GRADE = (s1, s2) -> s1.avgGrade.compareTo(s2.avgGrade);
	public static final Comparator<Student> SURNAME = (s1, s2) -> s1.surname.compareTo(s2.surname);

}