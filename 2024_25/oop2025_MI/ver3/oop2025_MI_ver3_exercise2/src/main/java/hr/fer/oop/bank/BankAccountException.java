package hr.fer.oop.bank;

public class BankAccountException extends BankException {

  public BankAccountException(String message, Throwable cause) {
    super(message, cause);
  }

  public BankAccountException(String message) {
    super(message);
  }

}
