package hr.fer.oop;

import java.util.Objects;

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
        return Objects.hash(this.name, this.value,this.category);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.value != other.value) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.category, other.category);
    }

    @Override
    public int compareTo(Item other) {
        int r = this.name.compareTo(other.name);
        
        if (r != 0)
            return r;
        
        r = Integer.compare(this.value, other.value);
        
        if (r != 0)
            return r;
        
        return this.category.compareTo(other.category);
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", value=" + value + ", category=" + category + '}';
    }
}
