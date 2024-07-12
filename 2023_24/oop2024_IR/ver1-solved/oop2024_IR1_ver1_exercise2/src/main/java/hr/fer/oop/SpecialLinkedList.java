package hr.fer.oop;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class SpecialLinkedList<E extends Comparable<E>> extends LinkedList<E> implements SpecialCollection<E> {

    private void checkElement(E element) throws IllegalArgumentException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("This collection does not support null elements");
        }
        if (super.contains(element)) {
            throw new IllegalArgumentException("This collection does not support duplicate elements");
        }
    }

    @Override
    public void add(int index, E element) {
        checkElement(element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E element : c) {
            checkElement(element);
        }
        return super.addAll(index, c);
    }

    @Override
    public boolean add(E e) {
        checkElement(e);
        return super.add(e);
    }

    @Override
    public void addLast(E e) {
        checkElement(e);
        super.addLast(e);
    }

    @Override
    public void addFirst(E e) {
        checkElement(e);
        super.addFirst(e);
    }

    @Override
    public SpecialCollection<E> getSorted() {
        SpecialLinkedList<E> sortedCollection = new SpecialLinkedList<>();
        sortedCollection.addAll(this);
        Collections.sort(sortedCollection);
        return sortedCollection;
    }
}
