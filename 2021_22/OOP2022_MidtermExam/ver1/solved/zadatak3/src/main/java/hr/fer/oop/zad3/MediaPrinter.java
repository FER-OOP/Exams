package hr.fer.oop.zad3;

public class MediaPrinter<E extends Media> extends PrintableList<E>{

  @Override
  public String print() {
    StringBuilder sb = new StringBuilder();
    int size = size();
    for (int i = 0; i < size; i++) {
      Media m = elementAt(i);
      sb.append(String.format("%s is %d seconds long.\n", m.getTitle(), m.getLength()));
    }

    return sb.toString();
  }

}
