/*
 * Copyright 2022 Krešimir Pripužić
 */
package hr.fer.oop.bag;

import java.util.Collection;

/**
 * A bag represents a group of objects, known as its elements. The bag can have
 * duplicates and null values, and is unordered.
 *
 * @param <T> The type of elements in this bag.
 */
public interface Bag<T> {

    /**
     * Adds the specified element (including null) to this bag.
     *
     * @param e element to be added to this bag
     */
    public void add(T e);

    /**
     * Removes a single instance of the specified element from this bag if it is
     * present.
     *
     * @param e element to be removed from this bag, if present
     */
    public void remove(T e);

    /**
     * Returns the number of elements in this bag.
     *
     * @return the number of elements in this bag
     */
    public int size();

    /**
     * Returns the number of elements in this bag equal to the specified object.
     *
     * @param o the object whose frequency is to be determined
     * @return the number of elements in this bag equal to {@code o}
     */
    public int frequency(Object o);

    /**
     * Returns a collection containing all the elements from this bag in any order
     *
     * @return a collection containing all of the elements in this bag
     */
    public abstract Collection<T> toCollection();
}
