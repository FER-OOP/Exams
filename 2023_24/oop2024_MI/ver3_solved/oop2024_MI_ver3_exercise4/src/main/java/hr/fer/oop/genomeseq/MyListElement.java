package hr.fer.oop.genomeseq;

public class MyListElement <T> {
	public T element;
	public MyListElement<T> next;
	
	public MyListElement(T element) {
		this.element = element;
		this.next = null;
	}
}
