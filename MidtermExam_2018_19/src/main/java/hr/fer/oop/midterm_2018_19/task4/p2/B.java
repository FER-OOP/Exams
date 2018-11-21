package hr.fer.oop.midterm_2018_19.task4.p2;

import hr.fer.oop.midterm_2018_19.task4.p1.A;

public class B extends A {
	private int z;
	public B(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	@Override
	public String values() {		
		return super.values() + " Z = " + z;
	}
		
}
