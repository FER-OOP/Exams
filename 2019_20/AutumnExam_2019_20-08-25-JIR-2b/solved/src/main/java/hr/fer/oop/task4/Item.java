package hr.fer.oop.task4;

class Item {
  private String name;
  private Double price;

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return this.name;
  }

  public Double getPrice() {
    return this.price;
  }
}