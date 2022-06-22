package hr.fer.oop.zi.z2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main implements Runnable {
  public static void main(String[] args) {
    new Main().run();
  }

  @Override
  public void run() {
    List<Bill> bills = loadBills();
    printList(bills);

    BillStats billStats = new BillStats();
    System.out.println("|| Sorted articles ||");
    printList(billStats.getArticlesSortedByQuantityAndDiscount(bills.get(0)));

    System.out.println("|| Bill sum ||");
    System.out.println(billStats.getBillSums(bills.stream()));

    System.out.println("|| 2 most expensive articles ||");
    printStream(billStats.getMostExpensiveArticles(bills.get(1), 2));
  }

  protected <E> void printList(List<E> list) {
    printStream(list.stream());
  }

  protected <E> void printStream(Stream<E> stream) {
    System.out.println(stream
      .map(b -> b.toString().indent(2).stripTrailing())
      .collect(Collectors.joining(",\n", "[\n", "\n]")));
  }

  protected List<Bill> loadBills() {
    List<Bill> bills = new ArrayList<>();
    Bill bill = new Bill("1");
    bill.addArticle(new Article("jabuka", 5.0, 0.2, 4));
    bill.addArticle(new Article("kruška", 4.0, 0.0, 3));
    bill.addArticle(new Article("banana", 15.0, 0.0, 7));
    bills.add(bill);

    bill = new Bill("2");
    bill.addArticle(new Article("kokice", 4.0, 0.0, 1));
    bill.addArticle(new Article("jabuka", 7.0, 0.25, 1));
    bill.addArticle(new Article("kruška", 21.0, 0.0, 2));
    bill.addArticle(new Article("banana", 6.0, 0.1, 4));
    bill.addArticle(new Article("sir", 34.0, 0.5, 3));
    bill.addArticle(new Article("govedina", 98.0, 0.1, 7));
    bills.add(bill);

    bill = new Bill("3");
    bill.addArticle(new Article("kruh", 5.0, 0.2, 17));
    bill.addArticle(new Article("salama", 14.0, 0.5, 3));
    bill.addArticle(new Article("keksi", 233.0, 0.1, 7));
    bills.add(bill);

    return bills;
  }
}
