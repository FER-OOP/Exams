package hr.fer.oop.library;

public class UsageExample {

  public static void main(String[] args) {
    // Create a library with a capacity of 10 resources
    Library library = new Library("Computer Library", 10);

    // Create different types of resources related to the computer domain
    // Add resources to the library
    library.addResource(new PhysicalBook(
        "1", "Clean Code", "Robert C. Martin", 2008, "Shelf A", 464, "First Edition", "Prentice Hall"));
    library.addResource(new EBook(
        "2", "Python for Data Analysis", "Wes McKinney", 2017, "PDF", 5.2, "O'Reilly Media"));
    library.addResource(new DVD(
        "3", "Introduction to Algorithms", "Thomas H. Cormen", 2020, "Shelf B", 180));
    library.addResource(new OnlineArticle(
        "4", "Quantum Computing Explained", "John Doe", 2023, "HTML", 0.8, "https://example.com/quantum-computing"));
    library.addResource(new OnlineArticle(
        "5", "Namespaces in Python", "Leodanis Pozo Ramos", 2025, "HTML", 1.5,
        "https://realpython.com/python-namespace/"));

    // Find a resource by ID
    System.out.println(library.findById("3"));
    System.out.println(library.findById("10"));

    // Search for books with text in the title
    Book[] books = library.findInBookTitle("Python");
    System.out.println("\nBooks containing 'Python' in the title:");
    for (Book book : books) {
      System.out.println("- " + book);
    }

    // Retrieve all resources in the library
    Resource[] allResources = library.getAllResources();
    System.out.println("\nAll resources in the library:");
    for (Resource resource : allResources) {
      System.out.println("- " + resource.getTitle() + " by " + resource.getAuthor());
    }
  }
}
