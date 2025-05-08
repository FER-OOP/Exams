package hr.fer.oop;

public class Price {
  private final int amountInHundredths;
  private final String currency;

  public Price(int amountInHundredths, String currency) {
    this.amountInHundredths = amountInHundredths;
    this.currency = currency;
  }

  public int getAmountInHundredths() {
    return amountInHundredths;
  }

  public String getCurrency() {
    return currency;
  }

}
