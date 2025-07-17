package hr.fer.oop;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

//it is forbidden to change the next line of code!!!

public class MyPriorityQueue<E> extends TreeMap<E, Integer> implements PriorityQueue<E> {

    //It is forbidden to have attributes in this class!!!
    
    /**
     * Constructs an empty collection, sorted according to the natural ordering
     * of its elements.
     */
    public MyPriorityQueue() {
        //TODO
    }

    /**
     * Constructs a new, empty collection, sorted according to the specified
     * comparator.
     *
     * @param comparator the comparator that will be used to order this
     * collection. If {@code null}, the {@linkplain Comparable natural
     *        ordering} of the elements will be used.
     */
    public MyPriorityQueue(Comparator<? super E> comparator) {
        //TODO
    }

    @Override
    public final void add(E e) {
       //TODO
    }

    @Override
    public int size() {
        //TODO
        return 0;
    }

    @Override
    public E poll() {
        //TODO
        return null;        
    }

    @Override
    public Iterator<E> iterator() {
        //TODO
        return null;
    }
}