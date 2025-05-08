package hr.fer.oop;

public class ProductTableParser {

  private MyList<Product> products;

  public void parseTable(String[] lines) {
    products = new MyList<>();
    MyList<ProductParseException> exceptions = new MyList<>();

    exceptions = new MyList<>();

    for(int row = 0; row < lines.length; row++) {
      String line = lines[row];
      if(line.startsWith("+")) {
        continue;
      }

      String[] parts = line.split(":");
      if (parts.length < 4) {
        exceptions.addLast(new ProductParseRowException(row + 1, "Invalid number of columns"));
        continue;
      }

      String name = parts[1].trim();
      String category = parts[2].trim();
      Price price;
      try {
        String priceText = parts[3].trim();
        String[] priceParts = priceText.split(" ");
        if(priceParts.length != 2) {
          exceptions.addLast(new ProductParseCellException(row + 1, 3, "Invalid price format (number of parts)"));
          continue;
        }

        price = new Price(
            (int)(Double.parseDouble(priceParts[0].trim()) * 100),
            priceParts[1].trim());
        products.addLast(new Product(name, category, price));
      } catch (NumberFormatException e) {
        exceptions.addLast(new ProductParseCellException(row + 1, 3, "Invalid price format"));
      }
    }

    if(exceptions.size() > 0) {
      ProductParseCollectorException productParseExceptions = new ProductParseCollectorException();
      for(int i = 0; i < exceptions.size(); i++) {
        productParseExceptions.addReason(exceptions.elementAt(i));
      }
      throw productParseExceptions;
    }
  }

  public MyList<Product> getProducts() {
    return products;
  }
}
