package hr.fer.oop.zi.z2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BillStats {
  public List<Article> getArticlesSortedByQuantityAndDiscount(Bill bill) {
    return bill.getArticles().stream()
      .sorted(Comparator.comparing(Article::getQuantity).reversed()
        .thenComparing(Comparator.comparing(Article::getDiscount)))
      .collect(Collectors.toList());
  }

  public List<Double> getBillSums(Stream<Bill> billsStream) {
    return billsStream
      .map(bill -> bill.getArticles().stream()
        .mapToDouble(article -> (article.getBasePrice() * (1 - article.getDiscount()) * article.getQuantity()))
        .sum())
      .collect(Collectors.toList());
  }

  public Double getTotalBillDiscount(Bill bill) {
    return bill.getArticles().stream()
      .mapToDouble(Article::totalDiscount)
      .sum();
  }

  public Stream<Article> getMostExpensiveArticles(Bill bill, int noOfArticles) {
    return bill.getArticles().stream()
        .filter(a -> a.discountedPrice() < 10)
        .sorted((a1, a2) -> Double.compare(a2.discountedPrice(), a1.discountedPrice()))
        .limit(noOfArticles);
  }
}
