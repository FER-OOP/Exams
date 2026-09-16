package hr.fer.oop;

import java.nio.file.Path;
import java.util.List;

import hr.fer.oop.picture.OutsidePictureException;
import hr.fer.oop.picture.Picture;
import hr.fer.oop.picture.PictureException;
import hr.fer.oop.picture.PictureReader;
import hr.fer.oop.picture.TruncatedFileException;

public class Main {

  private static final Path FILESET = Path.of("src", "main", "resources", "fileset0");

  public static void main(String[] args) throws PictureException {
    // every .pic file lying directly in the directory, so nothing from broken/
    List<Picture> pictures = PictureReader.readAll(FILESET);

    System.out.println("READ: " + pictures.size());
    for (Picture picture : pictures) {
      System.out.println("SIZE: " + picture.getWidth() + "x" + picture.getHeight());
      System.out.println(picture);
    }

    // the files in broken/ cannot be read, each one for its own reason
    Path broken = FILESET.resolve("broken");
    for (String name : new String[] { "extra.pic", "outside.pic", "short.pic" }) {
      try {
        PictureReader.read(broken.resolve(name));
      } catch (OutsidePictureException failure) {
        System.out.println("OUTSIDE:   " + name + " entry " + failure.getEntry()
            + " reaches row " + failure.getRow() + " column " + failure.getColumn());
      } catch (TruncatedFileException failure) {
        System.out.println("TRUNCATED: " + name + " entry " + failure.getEntry());
      } catch (PictureException failure) {
        System.out.println("REFUSED:   " + name);
      }
    }
  }

}
