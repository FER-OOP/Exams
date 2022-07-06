package hr.fer.oop.zi.zad3;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CPUDatabase {
	
	private int counter = 0;
	private Map<Integer, CPU> cpus = new HashMap<>();

	public CPU createCPU(String name) {
		return cpus.put(counter, new CPU(counter++, name));
	}
	
	public CPU createCPU(String name, double clockspeed, int cores, int cost, boolean hyperthreading) {
		return cpus.put(counter, new CPU(counter++, name,
				clockspeed, cores, cost, hyperthreading));
	}
	
	public CPU createCPU(String name, double clockSpeed, int cores, int cost) {
		return createCPU(name, clockSpeed, cores, cost, false);
	}
	
	public CPU getCPU(int id) {
		return cpus.get(id);
	}
	
	public CPU removeCPU(int id) {
		return cpus.remove(id);
	}
	
	public Collection<CPU> getRanking(Comparator<? super CPU> comparator) {
		return cpus.values().stream().sorted(comparator).toList();
	}
}
