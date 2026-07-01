package hr.fer.oop;

import java.util.*;

public class Box<T extends Vinyl> {

    private final List<T> items = new ArrayList<>();

    public void add(T vinyl) {
        items.add(vinyl);
    }

    public List<T> getItems() {
        return items;
    }

    public int size() {
        return items.size();
    }

    public double totalValue() {
        double sum = 0;
        for (T v : items) {
            sum += v.getPrice();
        }
        return sum;
    }
}