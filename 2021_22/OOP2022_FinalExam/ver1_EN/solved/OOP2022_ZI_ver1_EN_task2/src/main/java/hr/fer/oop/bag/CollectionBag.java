package hr.fer.oop.bag;

import java.util.Collection;
import java.util.LinkedList;

public class CollectionBag<T> extends AbstractBag<T> {

    final Collection<T> collection = new LinkedList<>();

    @Override
    public void add(T e) {
        collection.add(e);
    }

    @Override
    public void remove(T e) {
        collection.remove(e);
    }

    @Override
    public Collection<T> toCollection() {
        return collection;
    }

    @Override
    public int frequency(Object o) {
        return (int) collection.stream().filter(e -> e == null ? o == null : e.equals(o)).count();
    }

    @Override
    public int size() {
        return collection.size();
    }
}
