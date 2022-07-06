package hr.fer.oop.zi.zad3;

import java.util.Comparator;

public class CPURanking {
	
	private CPURanking() { }
	
	public static Comparator<CPU> hasHyperthreadingFirst() {
		return (c1, c2) -> {
			if(c1.hasHyperthreading() == c2.hasHyperthreading()) {
				return 0;
			} else if (c1.hasHyperthreading()) {
				return -1;
			} else {
				return 1;
			}
		};
	}
	
	public static Comparator<CPU> withinBudgetFirst(int budget) {
		return (c1, c2) -> {
			if(c1.getCost() <= budget && c2.getCost() <= budget) {
				return 0;
			} else if(c1.getCost() <= budget) {
				return -1;
			} else {
				return 1;
			}
		};
	}
	
	public static Comparator<CPU> byPotentialSpeed() {
		return Comparator.comparingDouble(CPU::getClockSpeed)
				.reversed()
				.thenComparing(
						Comparator.comparingInt(CPU::getCores)
						.reversed())
				.thenComparing(hasHyperthreadingFirst());
	}
	
	private static double calculateEfficiency(CPU cpu) {
		double clockSpeed = cpu.getClockSpeed();
		double potential = clockSpeed * cpu.getCores();
		if (cpu.hasHyperthreading()) {
			potential *= 1.2;
		}
		
		return cpu.getCost() / potential;
	}
	
	public static Comparator<CPU> byCostEfficiency() {
		return Comparator.comparingDouble(CPURanking::calculateEfficiency);
	}	
	
	public static Comparator<CPU> byAffordabilityAndEfficiency(int budget) {
		return withinBudgetFirst(budget)
				.thenComparing(byCostEfficiency())
				.thenComparing(byPotentialSpeed())
				.thenComparing(CPU::getName);
	}
}
