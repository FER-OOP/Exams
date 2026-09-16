package hr.fer.oop.picture;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

// TODO: Finish this class
public class PictureReader {

  public static final String EXTENSION = ".pic";

  // TODO: Implement this method - one byte, or the file ended too early.
  private static int readByte(InputStream in, Path file, int entry)
      throws IOException, TruncatedFileException {
  }

  /** Two bytes joined into one number, the higher one read first. Already written. */
  private static int readShort(InputStream in, Path file, int entry)
      throws IOException, TruncatedFileException {
    return (readByte(in, file, entry) << 8) | readByte(in, file, entry);
  }

  /** One byte read as a character. Already written. */
  private static char readChar(InputStream in, Path file, int entry)
      throws IOException, TruncatedFileException {
    return (char) readByte(in, file, entry);
  }

  // TODO: read(file) - the one picture a file holds

  // TODO: readAll(directory) - every .pic file directly inside a directory

}
