package hr.fer.oop.task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DiskAnalyzer extends SimpleFileVisitor<Path> {

  private final Map<String, Long> sizesByExtension;
  private static final String skipString = "copy";

  public Map<String, Long> getSizesByExtension() {
    return sizesByExtension;
  }

  public DiskAnalyzer() {
    sizesByExtension = new HashMap<>();
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    if (dir.getFileName().toString().contains(skipString)) {
      return FileVisitResult.SKIP_SUBTREE;
    }
    return super.preVisitDirectory(dir, attrs);
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    if (file.getFileName().toString().contains(skipString)) {
      return FileVisitResult.CONTINUE;
    }
    String filename = file.getFileName().toString();
    String fileExtension = filename.substring(filename.lastIndexOf(".") + 1);
    if (sizesByExtension.containsKey(fileExtension)) {
      sizesByExtension.put(fileExtension, sizesByExtension.get(fileExtension) + attrs.size());
    } else {
      sizesByExtension.put(fileExtension, attrs.size());
    }
    return super.visitFile(file, attrs);
  }

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    long currentDirectoryFilesSize = 0;
    for (File f : Objects.requireNonNull(dir.toFile().listFiles())) {
      if (f.isFile() && !f.getName().contains(skipString)) {
        currentDirectoryFilesSize += f.length();
      }
    }
    System.out.println(dir + " " + currentDirectoryFilesSize);
    return super.postVisitDirectory(dir, exc);
  }
}
