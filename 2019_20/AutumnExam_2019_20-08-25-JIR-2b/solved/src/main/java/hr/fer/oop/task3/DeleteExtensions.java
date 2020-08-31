package hr.fer.oop.task3;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;

public class DeleteExtensions extends SimpleFileVisitor<Path> {
  private Collection<String> ext;
  private String skip;

  private long deletedSize = 0;
  private long deletedFiles = 0;
  private long deletedDirs = 0;

  public void printStats() {
    System.out.println("Deleted " + deletedFiles + " files, total size " + deletedSize + ".");
    System.out.println("Deleted " + deletedDirs + " directories.");
  }

  public DeleteExtensions(Collection<String> ext, String skip) {
    this.ext = ext;
    this.skip = skip;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {

    if (dir.getFileName().toString().contains(skip))
        return SKIP_SUBTREE;
    return CONTINUE;

  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

    if (ext.stream().anyMatch(x -> file.getFileName().toString().endsWith(x))) {
      try {
        deletedSize += Files.size(file);
        Files.delete(file);
        deletedFiles++;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return CONTINUE;

  }

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

    if (!Files.list(dir).findAny().isPresent()) {
      try {
        Files.delete(dir);
        deletedDirs++;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return CONTINUE;
  }
}
