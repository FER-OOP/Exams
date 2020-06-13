package hr.fer.oop.task2;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class Vehicle implements Comparable<Vehicle> {
	private final static Comparator<Object> hrcomparator = Collator.getInstance(Locale.forLanguageTag("hr"));
	private final String name;	
	private final int hp;
	private final int weight;	
			
	public Vehicle(int weight, int hp, String name){
		this.name = name;		
		this.weight = weight;
		this.hp = hp;		
	}
	
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	public int getHp() {
		return hp;
	}
		
	@Override
	public String toString() {		
		return String.format("%s %dkg %dKS", getName(), getWeight(),getHp());

	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vehicle) {
			Vehicle other = (Vehicle) obj;
			return name.equals(other.name) && hp == other.hp && weight == other.weight;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, hp, weight);
	}
	
	@Override
	public int compareTo(Vehicle o) {
		int c = hp - o.hp;
		if (c == 0)
			c = weight - o.weight;
		if (c == 0) 
			c = hrcomparator.compare(name, o.name);
		return c;				
	}
	
		
	public static Comparator<Vehicle> BY_NAME = (a, b) -> hrcomparator.compare(a.name, b.name); 
	public static Comparator<Vehicle> BY_HP = Comparator.comparing(Vehicle::getHp); //or (a, b) -> a.hp - b.hp;
	public static Comparator<Vehicle> BY_WEIGHT = (a, b) -> a.weight - b.weight;	
}
