package hr.fer.oop.task4;

import java.util.LinkedHashMap;
import java.util.Map;

class Store {
  private String name;
  private Map<Item, Integer> items;

  public Store(String name) {
    this.name = name;
    this.items = new LinkedHashMap<>();
  }

  public void addItem(Item item, int quantity) {
    this.items.put(item, quantity);
  }

  public String getName() {
    return this.name;
  }

  public Map<Item, Integer> getItems() {
    return this.items;
  }
}