package hr.fer.oop;

public class Item implements Comparable<Item> {
    private final String name;
    private final int value;
    private final String category;

    public Item(String name, int value, String category) {
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int hashCode() {        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo(Item other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", value=" + value + ", category=" + category + '}';
    }
}
