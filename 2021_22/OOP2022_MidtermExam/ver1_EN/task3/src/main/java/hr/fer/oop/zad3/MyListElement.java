package hr.fer.oop.zad3;

public class MyListElement<E> {
    private E content;
    private MyListElement<E> next;

    public MyListElement(E content) {
        this.content = content;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public MyListElement<E> getNext() {
        return next;
    }

    public void setNext(MyListElement<E> next) {
        this.next = next;
    }
}