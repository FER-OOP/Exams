package hr.fer.oop.bank;

public class Main {

  public static void main(String[] args) {
    // Create IBANs
    IBAN iban1 = new IBAN("HR12345678901234567890123456789012");
    IBAN iban2 = new IBAN("HR98765432109876543210987654321098");

    // Create Bank Accounts
    BankAccount account1 = new BankAccount(iban1);
    BankAccount account2 = new BankAccount(iban2);

    // Deposit money into account1
    account1.deposit(10000); // Deposit 100.00 in hundredths
    System.out.println("Account 1 balance after deposit: " + account1.getBalanceInHundredths());

    // Withdraw money from account1
    account1.withdraw(5000); // Withdraw 50.00 in hundredths
    System.out.println("Account 1 balance after withdrawal: " + account1.getBalanceInHundredths());

    // Transfer money from account1 to account2
    account1.transferTo(3000, account2); // Transfer 30.00 in hundredths
    System.out.println("Account 1 balance after transfer: " + account1.getBalanceInHundredths());
    System.out.println("Account 2 balance after receiving transfer: " + account2.getBalanceInHundredths());

    // Print transactions for account1
    System.out.println("\nAccount 1 transactions:");
    MyList<Transaction> transactions = account1.getTransactions();
    for (int i = 0; i < transactions.size(); i++) {
      Transaction transaction = transactions.elementAt(i);
      System.out.println(transaction.getType() + " - " + transaction.getAmountInHundredths());
    }

    // Print transactions for account2
    System.out.println("\nAccount 2 transactions:");
    transactions = account2.getTransactions();
    for (int i = 0; i < transactions.size(); i++) {
      Transaction transaction = transactions.elementAt(i);
      System.out.println(transaction.getType() + " - " + transaction.getAmountInHundredths());
    }

    // Some exceptional cases
    System.out.println("\nTesting exceptional cases:");
    System.out.println("Testing invalid IBAN:");
    try {
      new IBAN("INVALID_IBAN"); // Less than 34 characters
    } catch (IbanException e) {
      System.out.println("Exception: " + e);
    }

    System.out.println("Testing invalid transaction:");
    try {
      new Transaction(
        10000,
        TransactionType.DEPOSIT,
        null,
        null
      );
    } catch (TransactionException e) {
      System.out.println("Exception: " + e);
    }

    System.out.println("Testing withdrawal exceeding balance:");
    try {
      account1.withdraw(20000); // Attempt to withdraw more than the balance
    } catch (BankAccountException e) {
      System.out.println("Exception: " + e);
    }

    System.out.println("Testing transfer exceeding balance:");
    try {
      account1.transferTo(20000, account2); // Attempt to transfer more than the balance
    } catch (BankAccountException e) {
      System.out.println("Exception: " + e);
    }
  }
}
