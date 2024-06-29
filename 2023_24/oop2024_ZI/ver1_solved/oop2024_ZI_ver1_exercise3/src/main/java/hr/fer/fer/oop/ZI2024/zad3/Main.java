package hr.fer.oop.ZI2024.zad3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		STEMGames stemGames = new STEMGames();

		stemGames.addStudent("Ana Horvat", 98, 94);
	    stemGames.addStudent("Marko Pehar", 78, 77);
	    stemGames.addStudent("Ivan Kralj", 94, 90);
	    stemGames.addStudent("Lucija Rukavina", 69, 83);
	    stemGames.addStudent("Petar Medak", 92, 75);
	    stemGames.addStudent("Maja Posavec", 84, 86);
	    stemGames.addStudent("Jure Herceg", 80, 87);
	    stemGames.addStudent("Martina Car", 95, 97);
	    stemGames.addStudent("Luka Horvat", 88, 90);
	    stemGames.addStudent("Karla Salamun", 73, 79);
	    stemGames.addStudent("Nina Kolar", 79, 82);
	    stemGames.addStudent("Tomislav Trnski", 90, 89);
	    stemGames.addStudent("Marta Novosel", 77, 81);
	    stemGames.addStudent("Zvonimir Knez", 91, 92);
	    stemGames.addStudent("Ivana Krolo", 79, 94);
	    stemGames.addStudent("Filip Mlinar", 86, 92);

        int highestEng = stemGames.getHighestScoreInEng();
		int highestMath = stemGames.getHighestScoreInMath();
		int highestTotal = stemGames.getHighestScoreInTotal();
		
		System.out.println("Highest score in engineering: " + highestEng);
		System.out.println("Highest score in mathematics: " + highestMath);
		System.out.println("Highest total score : " + highestTotal);
		
		Map<String, List<String>> topStudents = stemGames.getTopStudents();
		
		for (String k : topStudents.keySet()) {
			List<String> v = topStudents.get(k);
			System.out.println(k + ": " + v);
		}
	}
}
