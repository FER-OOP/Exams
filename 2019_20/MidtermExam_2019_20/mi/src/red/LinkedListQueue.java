package red;

import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {

	private Node<E> first;
	private Node<E> last;
	private int count;
	
	public LinkedListQueue() {
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public E take() {
		if(first==null) throw new NoSuchElementException();

		E value = first.value;
		
		first = first.next;
		if(first==null) last = null;
		count--;
		
		return value;
	}

	@Override
	public Queue<E> add(E elem) {
		Node<E> node = new Node<>(elem);
		
		count++;
		
		if(first==null) {
			first = last = node;
			return this;
		}

		last.next = node;
		last = node;
		
		return this;
	}

	private static class Node<T> {
		private Node<T> next;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
}
