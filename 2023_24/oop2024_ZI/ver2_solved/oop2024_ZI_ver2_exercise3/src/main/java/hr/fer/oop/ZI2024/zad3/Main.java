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
		
		/*
		// Skriveni podaci za ver2 pitanja, a vidljivi podaci za ver1 pitanja
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
        */
		        
		// Vidljivi podaci za ver2 pitanja, a skriveni podaci za ver1 pitanja
		stemGames.addStudent("Jana Kralj", 93, 98);
	    stemGames.addStudent("Ivan Pehar", 94, 90);
	    stemGames.addStudent("Marko Horvat", 71, 77);
	    stemGames.addStudent("Petar Medak", 92, 75);
	    stemGames.addStudent("Lucija Rukavina", 69, 73);
	    stemGames.addStudent("Jure Posavec", 90, 87);
	    stemGames.addStudent("Maja Herceg", 87, 86);
	    stemGames.addStudent("Luka Car", 85, 90);
	    stemGames.addStudent("Karla Horvat", 95, 96);
	    stemGames.addStudent("Martina Salamun", 69, 82);
	    stemGames.addStudent("Tomislav Kolar", 73, 79);
	    stemGames.addStudent("Nina Trnski", 77, 89);
	    stemGames.addStudent("Zvonimir Novosel", 90, 89);
	    stemGames.addStudent("Marta Knez", 91, 92);
	    stemGames.addStudent("Filip Krolo", 86, 92);
	    stemGames.addStudent("Ivana Mlinar", 99, 74);
	    	   
        int topEngCount = stemGames.getTopEngStudentCount(90); // Ako se stavi treshold 90, onda je rezultat 8 -- bolje za testiranje; ako se stavi treshold 95, onda je rezultat 2
		int topMathCount = stemGames.getTopMathStudentCount(90); // Ako se stavi treshold 90, onda je rezultat 6 -- bolje za testiranje; ako se stavi treshold 95, onda je rezultat 2
		int topTotalCount = stemGames.getTopTotalStudentCount(180); // Ako se stavi treshold 180, onda je rezultat 4; ako se stavi treshold 190, onda je rezultat 2
		
		System.out.println("Number of students with 95 or more in engineering: " + topEngCount);
		System.out.println("Number of students with 95 or more in mathematics: " + topMathCount);
		System.out.println("Number of students with 190 or more in total score : " + topTotalCount);
		
		Map<String, List<String>> topStudents = stemGames.getTopStudents();
		
		for (String k : topStudents.keySet()) {
			List<String> v = topStudents.get(k);
			System.out.println(k + ": " + v);
		}
	}
}
