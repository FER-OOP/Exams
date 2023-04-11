package red;

public interface Queue<E> {
	default boolean isEmpty() {
		return size() == 0;
	}
	int size();
	E take();
	Queue<E> add(E elem);
}
