package hr.fer.oop;

import java.util.Iterator;

/**
 * A collection of ordered elements which allows duplicates, but does not permit
 * null elements. The elements are ordered using their
 * {@linkplain Comparable natural  * ordering}, or by a {@link Comparator}
 * provided at set creation * time, depending on which constructor is used.
 *
 * @param <E> the type of elements maintained by this collection
 */
public interface PriorityQueue<E> extends Iterable<E> {

    /**
     * Inserts the specified element into this collection.
     *
     * @param e the element to add
     *
     * @throws NullPointerException if the specified element is null.
     */
    void add(E e);

    /**
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    int size();

    /**
     * Retrieves and removes the first element of this collection, or returns
     * {@code null} if this collection is empty.
     *
     * @return the first element in this collection, or {@code null} if this
     * queue is collection
     */
    E poll();

    /**
     * Returns an iterator over the elements in this set in ascending order.
     *
     * @return an iterator over the elements in this set in ascending order
     */
    @Override
    Iterator<E> iterator();
}
