package hr.fer.oop.genomeseq;

public class MyList <T> {
	private MyListElement<T> head;
	private int count;
	
	public MyList() {
		head = null;
		count = 0;
	}
	
	public int size() {
		return count;
	}
	
	public void add(T element) {
		MyListElement<T> newel = new MyListElement<>(element);
		newel.next = head;
		head = newel;
		count++;
	}
	
	public T get(int index) {
		if (index >= count) return null;
		
		MyListElement<T> temp = head;
		for (int i=0; i<index; i++)  temp=temp.next;
		return temp.element;
	}
}
