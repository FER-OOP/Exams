package hr.fer.oop.t3;

import java.util.List;

import hr.fer.oop.t3.items.Milk;

public class MilkBox extends Box<Milk>   {
	
	private Milk first;
	public MilkBox(Milk first) {
		super(List.of(first));
		this.first = first;
	}
	
	public boolean add(Milk milk) {
		if (milk.getType() != first.getType()) {
			return false;
		}
		else {
			this.content.add(milk);
			return true;
		}
	}
}
