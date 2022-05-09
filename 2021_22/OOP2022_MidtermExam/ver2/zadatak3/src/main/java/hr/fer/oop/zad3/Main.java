package hr.fer.oop.zad3;

public class Main {

  public static void main(String[] args) {
    PaintingPrinter paintings = new PaintingPrinter();
    paintings.addLast(new Painting("Pablo Picasso", "drawing", "Two reading cats"));
    paintings.addLast(new Painting("Edo Murtic", "mosaic", "Seferov family tomb"));
    paintings.addLast(new Painting("Vlaho Bukovac", "painting", "Hrvatski narodni preporod"));
    System.out.println(paintings.print());

    NameablePrinter<ArtPhotography> nameables = new NameablePrinter<>();
    nameables.addLast(new ArtPhotography("Damir Hoyka", "Nikon", "portrait", "Matrina Zubcic"));
    nameables.addLast(new ArtPhotography("Toso Dabac", "Flexaret", "people", "Prosjakinja s djetetom"));
    System.out.println(nameables.print());
    
    NameablePrinter<Painting> printer = new NameablePrinter<>(); // OK
    //NameablePrinter<Photography> printer = new NameablePrinter<>(); // greška kod prevođenja
    //NameablePrinter<Artwork> printer = new NameablePrinter<>(); // greška kod prevođenja
  }

}
