package hr.fer.oop.stack;

public class Stack<T> {

	private final Object[] stack;
	private int numberOfElements = 0;

	public Stack(int capacity) {
		this.stack = new Object[capacity];
	}

	public void push(T value) throws CapacityException {
		if (numberOfElements >= stack.length) {
			throw new CapacityException(stack.length);
		}
		this.stack[numberOfElements++] = value;
	}

	@SuppressWarnings("unchecked")
	public T pop() throws EmptyException {
		if (numberOfElements <= 0) {
			throw new EmptyException();
		}
		return (T) this.stack[--numberOfElements];
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("SL Program Stack:");
		if (numberOfElements == 0) {
			sb.append(" empty!");
		} else {
			for (int i = 0; i < numberOfElements; ++i) {
				sb.append(System.lineSeparator());
				sb.append("    ");
				sb.append(stack[i]);
			}
		}
		return sb.toString();
	}

}
