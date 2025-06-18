package hr.fer.oop.bank;

public class IBAN {
  private final String accountNumber;

  public IBAN(String accountNumber) {
    if (accountNumber == null || accountNumber.length() != 34) {
      throw new IbanException("IBAN must be exactly 34 characters long.");
    }

    for (char c : accountNumber.toCharArray()) {
      if (!Character.isLetterOrDigit(c)) {
        throw new IbanException("IBAN must contain only letters and digits.");
      }
    }

    this.accountNumber = accountNumber;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}

