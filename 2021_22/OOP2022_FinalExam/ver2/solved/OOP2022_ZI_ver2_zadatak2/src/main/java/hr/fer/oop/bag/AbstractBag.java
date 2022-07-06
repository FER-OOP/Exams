package hr.fer.oop.bag;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBag<T> implements Bag<T> {

    /**
     * Compares the specified object with this bag for equality. Returns
     * {@code true} if the given object is also a beg and the two begs contain
     * the same elements.
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Bag)) {
            return false;
        }
        try {
            Bag<T> bag = (Bag<T>) other;

            Map<T, Integer> tmpMap = new HashMap<>();
            for (T e : this) {
                tmpMap.compute(e, (key, value) -> value == null ? 1 : value + 1);
            }
            for (T e : bag) {
                tmpMap.compute(e, (key, value) -> value == 1 ? null : value - 1);
            }
            return tmpMap.isEmpty();
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /**
     * Returns the hash code value for this bag. Two bags that contain the same
     * group of elements (irrespective of their order) should return the same
     * hash code.
     *
     * @return the hash code value for this bag
     */
    @Override
    public int hashCode() {
        int h = 0;
        for (T e : this) {
            h += e.hashCode();
        }
        return h;
    }
}
