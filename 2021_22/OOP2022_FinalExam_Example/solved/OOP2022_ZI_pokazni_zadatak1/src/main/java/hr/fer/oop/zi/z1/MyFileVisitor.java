package hr.fer.oop.zi.z1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
  private List<Bill> bills = new ArrayList<>();

  // TODO dovršiti BEGIN
  @Override
  public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
    Bill bill = loadBill(path);
    if (bill != null) {
      bills.add(bill);
    }
    return FileVisitResult.CONTINUE;
  }
  // TODO dovršiti END

  protected Bill loadBill(Path path) throws IOException {
    // TODO dovršiti BEGIN
    String filename = path.getFileName().toString();
    if (filename.endsWith(".csv")) {
      String id = filename.substring(0, filename.length()-4).split("-")[1];// bill-555.csv
      Bill bill = new Bill(id);
      List<String> lines = Files.readAllLines(path);
      for (String line : lines) {
        Article article = parseArticle(line);
        bill.addArticle(article);
      }
      return bill;
    } else
      return null;
    // TODO dovršiti END
  }

  protected Article parseArticle(String line) {
    // TODO dovršiti BEGIN
    String[] elements = line.split(",");
    Article article = new Article(elements[0], Double.parseDouble(elements[1]), Double.parseDouble(elements[2]),
        Integer.parseInt(elements[3]));
    return article;
    // TODO dovršiti END
  }

  public List<Bill> getBills() {
    return bills;
  }

}
