package hr.fer.oop.zad3;

public class PaintingPrinter extends MyList<Painting> implements Printable {

  @Override
  public String print() {
    StringBuilder sb = new StringBuilder();
    int size = size();
    for (int i = 0; i < size; i++) {
      Painting p = elementAt(i);
      sb.append(String.format("%s: %s painted by using %s\n", p.getAuthor(), p.getName(), p.getTechnique()));
    }

    return sb.toString();
  }

}
