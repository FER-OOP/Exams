package hr.fer.oop.jir2024.zad4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		List<University> unisList = UniversityData.load();
		University uni1 = new University("UNIZG", "Croatia", 1669, 1001, 401);
		University uni2 = new University("OPENUNI", "AUS", 1969, 101 ,701);

		System.out.println("(List):");
		System.out.println(unisList.contains(uni1) ? "true" : "false");	//T
		System.out.println(unisList.contains(uni2) ? "true" : "false");	//F

		System.out.println("\n(HashSet):");
		Set<University> unisSet1 = new HashSet<>(unisList);
		System.out.println(unisSet1.contains(uni1) ? "true" : "false"); //T
		System.out.println(unisSet1.contains(uni2) ? "true" : "false"); //F

		System.out.println("\n(TreeSet):");
		Set<University> unisSet2 = new TreeSet<>(unisList);
		for (University uni : unisSet2) {
			System.out.println(uni);
		}		

	}

}
