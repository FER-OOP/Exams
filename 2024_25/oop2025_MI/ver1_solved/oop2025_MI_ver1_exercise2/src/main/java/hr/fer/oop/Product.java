package hr.fer.oop;

public class Product {
  private final String name, category;
  private final Price price;

  public Product(String name, String category, Price price) {
    this.name = name;
    this.category = category;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public Price getPrice() {
    return price;
  }

}
