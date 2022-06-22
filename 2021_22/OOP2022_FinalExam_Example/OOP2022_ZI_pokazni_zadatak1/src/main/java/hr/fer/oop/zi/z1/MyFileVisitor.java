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

  // TODO dovršiti

  protected Bill loadBill(Path path) throws IOException {
    // TODO dovršiti
  }

  protected Article parseArticle(String line) {
    // TODO dovršiti
  }

  public List<Bill> getBills() {
    return bills;
  }

}
