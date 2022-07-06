package hr.fer.oop.bag;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapBag<T> extends AbstractBag<T> {

    final Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T e) {
        if (e == null) {
            throw new IllegalArgumentException("The element to add cannot be null");
        }
        
        map.compute(e, (key, value) -> value == null ? 1 : value + 1);
    }

    @Override
    public void remove(T e) {
        map.compute(e, (key, value) -> value == null || value == 1 ? null : value - 1);
    }

    @Override
    public Iterator<T> iterator() {
        List<T> list = new LinkedList<>();

        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }

        return list.iterator();
    }

    @Override
    public int frequency(Object o) {
        Integer frequency = map.get(o);
        return frequency == null ? 0 : frequency;
    }

    @Override
    public int size() {
        return map.values().stream().mapToInt(e -> e).sum();
    }
}
