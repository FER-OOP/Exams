package hr.fer.oop.finalexam_2018_19.task2;

import java.util.ArrayList;
import java.util.List;

public class DBLoader {
	static List<Student> loadStudents(){
		List <Student> indexList = new ArrayList<>();
		indexList.add(new Student("369090", "Ivo", "Ivić", 4.5));
		indexList.add(new Student("367366", "Ante", "Jurić", 2.54));
		indexList.add(new Student("364545", "Jura", "Jurin", 3.7));
		indexList.add(new Student("363636", "Pero", "Perić", 3.51));
		return indexList;
	}
}

