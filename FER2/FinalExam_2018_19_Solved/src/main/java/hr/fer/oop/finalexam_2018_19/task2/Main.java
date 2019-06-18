package hr.fer.oop.finalexam_2018_19.task2;

import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Main {
	public static void printStudents(Iterable<Student> students, Predicate<Student> predicate) {
		for (Student s : students) {
			if (predicate.test(s)) {
				System.out.println(s.toString());
			}
		}
	}

	public static void printPair(Student first, Student last) {
		System.out.format("First and last student: %n\t%s%n\t%s%n", first, last);
	}

	// TO DO
	public static void firstAndLastStudent(Iterable<Student> students, Comparator<Student> comparator,
			BiConsumer<Student, Student> action) {
		SortedSet<Student> stSet = new TreeSet<>(comparator);
		for (Student s : students)
			stSet.add(s);
		action.accept(stSet.first(), stSet.last());
	}

	public static void main(String[] args) {
		List<Student> dataset = DBLoader.loadStudents();
		// TO DO
		printStudents(dataset, new Predicate<Student>() {
			@Override
			public boolean test(Student i) {
				return i.getAvgGrade() > 3.5 ? true : false;
			}
		});
		// TO DO
		firstAndLastStudent(dataset, Student.AVG_GRADE, Main::printPair);
		// TO DO
		BiConsumer<Student, Student> printGradeDifference = (Student s1, Student s2) -> System.out
				.format("Diff= \t%.2f%n", Math.abs(s1.getAvgGrade() - s2.getAvgGrade()));
		/*
		 * ili BiConsumer<Student, Student> printGradeDifference = new
		 * BiConsumer<Student, Student>() {
		 * 
		 * @Override public void accept(Student s1, Student s2) {
		 * System.out.format("Diff: \t%.2f%n",
		 * Math.abs(s1.getAvgGrade()-s2.getAvgGrade())); } };
		 */
		// TO DO
		firstAndLastStudent(dataset, Student.AVG_GRADE.reversed(), printGradeDifference);
		// firstAndLastStudent(dataset, Student.AVG_GRADE.reversed() ,
		// printGradeDifference.andThen( Main::printPair));

	}

}
