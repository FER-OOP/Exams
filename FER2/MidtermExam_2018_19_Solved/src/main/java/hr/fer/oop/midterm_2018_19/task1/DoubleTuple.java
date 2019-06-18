package hr.fer.oop.midterm_2018_19.task1;

public class DoubleTuple extends Tuple<Double> {
	public DoubleTuple(int len) {
		super(len);
	}
	public DoubleTuple(Double...elements) {
		super(elements);
	}
	public DoubleTuple multiplyWith(double scalar){
		for(int i=0; i<this.len(); i++) {
			this.set(i, scalar * this.get(i));
		}
		return this;
	}	
	
	public static Tuple<Double> avg(Tuple<? extends Number> first, Tuple<? extends Number> second) {		
		Tuple<Double> result = new Tuple<>(first.len());
		for(int i=0; i<first.len(); i++) {
			double d = first.get(i).doubleValue() + second.get(i).doubleValue();
			result.set(i, d / 2);
		}
		return result;
	}
}
