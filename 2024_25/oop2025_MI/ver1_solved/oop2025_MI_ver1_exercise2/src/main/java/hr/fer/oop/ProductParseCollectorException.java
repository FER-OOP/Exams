package hr.fer.oop;

public class ProductParseCollectorException extends ProductParseException {
  private MyList<ProductParseException> reasons = new MyList<>();

  public ProductParseCollectorException() {
  }

  public ProductParseCollectorException(String message) {
    super(message);
  }

  public void addReason(ProductParseException reason) {
    reasons.addLast(reason);
  }

  public MyList<ProductParseException> getReasons() {
    return reasons;
  }

}
