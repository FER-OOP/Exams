package hr.fer.oop.bank;

public class BankAccount {
  private final IBAN iban;
  private final MyList<Transaction> transactions;

  public BankAccount(IBAN iban) {
    if (iban == null) {
      throw new BankAccountException("IBAN must not be null.");
    }
    this.iban = iban;
    this.transactions = new MyList<>();
  }

  public IBAN getIban() {
    return iban;
  }

  public void addTransaction(Transaction transaction) {
    if (transaction == null) {
      throw new BankAccountException("Transaction must not be null.");
    }

    // Check if the transaction is related to this account
    if (!iban.equals(transaction.getSourceAccount()) && !iban.equals(transaction.getDestinationAccount())) {
      throw new BankAccountException("Transaction must involve this account's IBAN.");
    }

    transactions.addLast(transaction);
  }

  public MyList<Transaction> getTransactions() {
    return transactions.getCopy();
  }

  public int getBalanceInHundredths() {
    int balance = 0;
    for (int i = 0; i < transactions.size(); i++) {
      Transaction transaction = transactions.elementAt(i);
      if (transaction.getType() == TransactionType.DEPOSIT) {
        balance += transaction.getAmountInHundredths();
      } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
        balance -= transaction.getAmountInHundredths();
      } else if (transaction.getType() == TransactionType.TRANSFER) {
        if (iban.equals(transaction.getSourceAccount())) {
          balance -= transaction.getAmountInHundredths();
        } else if (iban.equals(transaction.getDestinationAccount())) {
          balance += transaction.getAmountInHundredths();
        }
      }
    }
    return balance;
  }

  public void deposit(int amountInHundredths) {
    Transaction transaction = new Transaction(amountInHundredths, TransactionType.DEPOSIT, null, iban);
    addTransaction(transaction);
  }

  public void withdraw(int amountInHundredths) {
    if (amountInHundredths > getBalanceInHundredths()) {
      throw new BankAccountException("Insufficient funds for withdrawal.");
    }

    Transaction transaction = new Transaction(amountInHundredths, TransactionType.WITHDRAWAL, iban, null);
    addTransaction(transaction);
  }

  public void transferTo(int amountInHundredths, BankAccount destination) {
    if(destination == null) {
      throw new BankAccountException("Destination account must not be null.");
    }

    if (amountInHundredths > getBalanceInHundredths()) {
      throw new BankAccountException("Insufficient funds for transfer.");
    }

    Transaction transaction = new Transaction(amountInHundredths, TransactionType.TRANSFER, iban, destination.getIban());
    addTransaction(transaction);
    destination.addTransaction(transaction);
  }

}
