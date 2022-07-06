package hr.fer.oop.bag;

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
    public boolean equals(Object obj) {
        //TODO
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
        //TODO
    }
}
