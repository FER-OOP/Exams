package hr.fer.oop.zad3;

public class NameablePrinter<E extends Artwork & Nameable> extends MyList<E> implements Printable {

  @Override
  public String print() {
    StringBuilder sb = new StringBuilder();
    int size = size();
    for (int i = 0; i < size; i++) {
      Nameable n = elementAt(i);
      Artwork a = elementAt(i);

      sb.append(String.format("%s: %s\n", a.getAuthor(), n.getName()));
    }

    return sb.toString();
  }

}
