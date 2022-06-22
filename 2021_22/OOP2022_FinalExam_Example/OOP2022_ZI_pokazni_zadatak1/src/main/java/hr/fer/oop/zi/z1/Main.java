package hr.fer.oop.zi.z1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main implements Runnable {
  public static void main(String[] args) {
    new Main().run();
  }

  @Override
  public void run() {
    try {
      Path path = Path.of("src", "main", "resources");
      List<Bill> bills = loadBills(path);
      printBills(bills);
    } catch (IOException e) {
      System.out.println("Can not load bills!");
    }
  }

  protected void printBills(List<Bill> bills) {
    System.out.println(bills.stream()
        .map(b-> b.toString().indent(2).stripTrailing())
        .collect(Collectors.joining(",\n","[\n", "\n]")));
  }

  protected List<Bill> loadBills(Path path) throws IOException {
    // TODO dovršiti
  }
}
