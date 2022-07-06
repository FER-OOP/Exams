package hr.fer.oop.zi.zad3;

import java.util.Collection;

public class Main {

	public static void main(String[] args) {
		CPUDatabase db = new CPUDatabase();
		db.createCPU("Intel Core i5-12600K", 3.7, 10, 2500, true);
		db.createCPU("AMD Ryzen 5 5600X", 3.7, 6, 1500, false);
		db.createCPU("Intel Core i7-11700K", 3.6, 8, 3000, true);
		db.createCPU("AMD Ryzen 7 3700X", 3.6, 8, 2200, false);
		Collection<CPU> cpusBySpeed = 
				db.getRanking(CPURanking.byPotentialSpeed());
		cpusBySpeed.forEach(System.out::println);
		
		System.out.println();
		
		Collection<CPU> cpusByCostEfficiency = 
				db.getRanking(CPURanking.byCostEfficiency());
		cpusByCostEfficiency.forEach(System.out::println);
		
		System.out.println();

		Collection<CPU> cpusByAffordabilityAndCostEff = 
				db.getRanking(CPURanking.byAffordabilityAndEfficiency(2400));
		cpusByAffordabilityAndCostEff.forEach(System.out::println);
	}

}
