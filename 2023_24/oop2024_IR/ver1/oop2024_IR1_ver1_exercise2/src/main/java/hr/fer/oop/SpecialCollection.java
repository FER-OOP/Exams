package hr.fer.oop;

import java.util.Collection;

/**
 * An unordered collection of unique elements that cannot be null. Throws a NullPointerException or IllegalArgumentException if an element being added is null or already in the collection, respectively.
 * @param <E> the type of elements in this collection
 */
public interface SpecialCollection<E> extends Collection<E> {
    public SpecialCollection<E> getSorted();
}
