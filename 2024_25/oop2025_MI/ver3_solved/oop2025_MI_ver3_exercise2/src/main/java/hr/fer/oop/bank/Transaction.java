package hr.fer.oop.bank;

public class Transaction {
  private final int amountInHundredths; // Amount in hundredths
  private final TransactionType type;
  private final IBAN sourceAccount;
  private final IBAN destinationAccount;

  public Transaction(int amountInHundredths, TransactionType type,
                     IBAN sourceAccount, IBAN destinationAccount) {

    if (amountInHundredths <= 0) {
      throw new TransactionException("Amount must be greater than zero.");
    }

    if (type == null) {
      throw new TransactionException("Transaction type must not be null.");
    }

    if (sourceAccount == null && destinationAccount == null) {
      throw new TransactionException("At least one account (source or destination) must not be null.");
    }

    if (sourceAccount != null && destinationAccount != null && sourceAccount.equals(destinationAccount)) {
      throw new TransactionException("Source and destination accounts must not be the same.");
    }

    // Validate sourceAccount
    if ((type == TransactionType.WITHDRAWAL || type == TransactionType.TRANSFER)
        && sourceAccount == null) {
        throw new TransactionException("Source account must not be null for withdrawals or transfers.");
    }

    // Validate destinationAccount
    if ((type == TransactionType.DEPOSIT || type == TransactionType.TRANSFER)
        && destinationAccount == null) {
        throw new TransactionException("Destination account must not be null for deposits or transfers.");
    }

    this.amountInHundredths = amountInHundredths;
    this.type = type;
    this.sourceAccount = sourceAccount;
    this.destinationAccount = destinationAccount;
  }

  public int getAmountInHundredths() {
    return amountInHundredths;
  }

  public TransactionType getType() {
    return type;
  }

  public IBAN getSourceAccount() {
    return sourceAccount;
  }

  public IBAN getDestinationAccount() {
    return destinationAccount;
  }

}
