package hr.fer.oop.genomeseq;

public class MySeqListElement <T> {
	public T element;
	public MySeqListElement<T> next;
	
	public MySeqListElement(T element) {
		this.element = element;
		this.next = null;
	}
}
