package hr.fer.oop;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyPriorityQueue<E> extends TreeMap<E, Integer> implements PriorityQueue<E> {
        
    /**
     * Constructs an empty collection, sorted according to the natural ordering
     * of its elements.
     */
    public MyPriorityQueue() {
        super();
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
        super(comparator);
    }

    @Override
    public final void add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        //super.merge(e, 1, (oldValue, value) -> oldValue + value); - replaces everything below
        Integer value = super.get(e);
        if (value == null) {
            super.put(e, 1);
        } else {
            super.put(e, value + 1);
        }
    }

    @Override
    public int size() {
        //return super.values().stream().mapToInt(i -> i).sum(); - replaces everything below
        int result = 0;
        for (int duplicates : super.values()) {
            result += duplicates;
        }
        return result;
    }

    @Override
    public E poll() {
        if (size() == 0) {
            return null;
        } else {
            E first = super.firstKey();
            //super.compute(first, (key, value) -> value == 1 ? null : value - 1); - replaces everything below
            int value = super.get(first);
            if (value == 1) {
                super.remove(first);
            } else {
                super.put(first, value - 1);
            }
            return first;
        }
    }

    @Override
    public Iterator<E> iterator() {
        /*return super.
                entrySet().
                stream().
                flatMap(entry -> listOfDuplicates(entry.getKey(), entry.getValue()).stream()).
                collect(Collectors.toList()).
                iterator(); - replaces everything below*/
        LinkedList<E> list = new LinkedList<>();
        for (Entry<E, Integer> entry : super.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }
        return list.iterator();
    }

//    private static <T> List<T> listOfDuplicates(T element, int n) {
//        List<T> list = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(element);
//        }
//        return list;
//    }    
}
