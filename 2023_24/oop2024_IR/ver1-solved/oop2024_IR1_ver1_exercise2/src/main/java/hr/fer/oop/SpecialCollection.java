package hr.fer.oop;

import java.util.Collection;

public interface SpecialCollection<E extends Comparable<E>> extends Collection<E> {
    public SpecialCollection<E> getSorted();
}
