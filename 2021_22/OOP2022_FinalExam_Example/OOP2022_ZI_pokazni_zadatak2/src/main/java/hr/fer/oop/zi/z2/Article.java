package hr.fer.oop.zi.z2;

public class Article {

  public String name;
  public double basePrice;
  public double discount;
  public int quantity;

  public Article(String name, double basePrice, double discount, int quantity) {
    this.name = name;
    this.basePrice = basePrice;
    this.discount = discount;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(double basePrice) {
    this.basePrice = basePrice;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Article{" +
        "name='" + name + '\'' +
        ", basePrice=" + basePrice +
        ", discount=" + discount +
        ", quantity=" + quantity +
        '}';
  }

}