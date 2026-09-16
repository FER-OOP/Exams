package hr.fer.oop.picture;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PictureReader {

  public static final String EXTENSION = ".pic";

  public static Picture read(Path file) throws PictureException {
    try (InputStream in = new BufferedInputStream(Files.newInputStream(file))) {
      int width = readShort(in, file, 0);
      int height = readShort(in, file, 0);
      char blank = readChar(in, file, 0);
      int count = readShort(in, file, 0);

      Picture picture = new Picture(width, height, blank);
      for (int entry = 1; entry <= count; entry++) {
        picture.add(readSpan(in, picture, file, entry));
      }

      if (in.read() != -1) {
        throw new ExtraDataException(file);
      }

      return picture;
    } catch (IOException failure) {
      throw new PictureIOException(file, failure);
    }
  }

  private static int readByte(InputStream in, Path file, int entry)
      throws IOException, TruncatedFileException {
    int value = in.read();
    if (value == -1) {
      throw new TruncatedFileException(file, entry);
    }
    return value;
  }

  private static char readChar(InputStream in, Path file, int entry)
      throws IOException, TruncatedFileException {
    return (char) readByte(in, file, entry);
  }

  private static int readShort(InputStream in, Path file, int entry)
      throws IOException, TruncatedFileException {
    return (readByte(in, file, entry) << 8) | readByte(in, file, entry);
  }

  private static Span readSpan(InputStream in, Picture picture, Path file, int entry)
      throws IOException, PictureException {
    int row = readShort(in, file, entry);
    int column = readShort(in, file, entry);
    int length = readShort(in, file, entry);
    char character = readChar(in, file, entry);

    checkInside(picture, file, row, column, entry);
    checkInside(picture, file, row, column + length - 1, entry);

    return new Span(row, column, length, character);
  }

  private static void checkInside(Picture picture, Path file, int row, int column, int entry)
      throws OutsidePictureException {
    if (!picture.holds(row, column)) {
      throw new OutsidePictureException(file, row, column, entry);
    }
  }

  public static List<Picture> readAll(Path directory) throws PictureException {
    List<Path> files;
    try (Stream<Path> entries = Files.list(directory)) {
      files = entries
          .filter(file -> file.getFileName().toString().endsWith(EXTENSION))
          .sorted()
          .toList();
    } catch (IOException failure) {
      throw new PictureIOException(directory, failure);
    }

    List<Picture> pictures = new ArrayList<>();
    for (Path file : files) {
      pictures.add(read(file));
    }
    return pictures;
  }

}
