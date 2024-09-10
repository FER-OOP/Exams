package hr.fer.oop.generics;

public class LettersAndNumber<T extends Number> extends Pair<String, T> implements Comparable<LettersAndNumber<T>> {

	public LettersAndNumber(String first, T second) {
		super(first, second);		
	}
	
	@Override
	public String toString() {
		return getFirst() + "-" + getSecond();
	}

	@Override
	public int compareTo(LettersAndNumber<T> other) {
		int r = this.getFirst().compareTo(other.getFirst());
		if (r == 0)
			r = Double.compare(this.getSecond().doubleValue(), other.getSecond().doubleValue());
		return r;
	}
}
