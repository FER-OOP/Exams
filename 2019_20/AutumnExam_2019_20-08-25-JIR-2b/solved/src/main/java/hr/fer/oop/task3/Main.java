package hr.fer.oop.task3;

import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class Main {

  public static void main(String[] args) {
      Path root = Path.of("test");
      Collection<String> ext = Arrays.asList(".txt", ".clj", ".java");
      String skip = "skip";

      FileVisitor<Path> visitor = new DeleteExtensions(ext,skip);

      try {
          Files.walkFileTree(root,visitor);
      }
      catch (Exception e) {
          e.printStackTrace();
      }

      ((DeleteExtensions)visitor).printStats();
  }
}
