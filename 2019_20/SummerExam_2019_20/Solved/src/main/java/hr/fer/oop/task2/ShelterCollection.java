package hr.fer.oop.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ShelterCollection<T extends Animal> implements Iterable<T> {

    Map<String, List<T>> shelterCollection = new TreeMap<>();

    public void add(T t) {
        List<T> animalList = shelterCollection.get(t.getType());
        if (animalList == null) {
            animalList = new ArrayList<>();
        }

        if (!animalList.contains(t)) {
            animalList.add(t);
        }
        shelterCollection.put(t.getType(), animalList);
    }

    public void add(T... elements) {
        for (T t : elements) {
            add(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private List<Iterator<T>> lists;
        int current = -1;

        private MyIterator() {
            lists = new ArrayList<>(shelterCollection.size());
            for (List<T> list : shelterCollection.values()) {
                lists.add(list.iterator());
            }
        }

        @Override
        public boolean hasNext() {
            for (Iterator<T> it : lists) {
                if (it.hasNext()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T result;
                while (true) {
                    current = (current + 1) % lists.size();
                    if (lists.get(current).hasNext()) {
                        result = lists.get(current).next();
                        break;
                    }
                }
                return result;
            } else {
                throw new NoSuchElementException();
            }
        }

    }
}
