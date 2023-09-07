package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;

public class ToyBox<T extends Toy> {
	
	protected List<T> toys;
	private final int maxWeight;
	private int currWeight = 0; // moze i ne mora ovako
	
	public ToyBox (int maxWeight) {
		this.maxWeight = maxWeight;
		this.toys = new ArrayList<T>();
	}
	
	public void put(T t) {
		if (currWeight+t.getWeight() > maxWeight)
			throw new ToyBoxOperationException("Box is full");
		
		this.toys.add(t);	
		currWeight += t.getWeight();
	}
	
	public T get() {
		if (toys.size()>0) {
			currWeight -= toys.get(0).getWeight();
			return toys.remove(0);
		}
		else {
			throw new ToyBoxOperationException("Box is empty");
		}
	}
	
}
