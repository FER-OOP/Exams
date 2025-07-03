package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        // Create a Library instance
        Library library = new Library();
        
        // Adding books to the library
        Book book1 = new Book("B-001", "The Hobbit", "In a hole in the ground there lived a hobbit.");
        Book book2 = new Book("B-002", "A Brief History of Time", "Popular-science book.");
        
        library.addItem(book1);
        library.addItem(book2);
        
        // Adding DVDs to the library
        DVD dvd1 = new DVD("D-001", "The Lord of the Rings: The Fellowship of the Ring", 178);
        DVD dvd2 = new DVD("D-002", "The Lord of the Rings: The Two Towers", 179);
        
        library.addItem(dvd1);
        library.addItem(dvd2);

        // Print the descriptions of all items in the library
        System.out.println("Description of all items in the library:");
        library.printAllDescriptions();

        // Retrieving and printing only the books
        System.out.println("\nOnly books in the library:");        
        for (Book b : library.getItemsOfTheSameTypeAsObject(book1)) { // Using book1 as a type reference
            System.out.println(b.getDescription());
        }

        // Retrieving and printing only the DVDs
        System.out.println("\nOnly DVDs in the library:");
        for (DVD d : library.getItemsOfTheSameTypeAsObject(dvd1)) { // Using dvd1 as a type reference
            System.out.println(d.getDescription());
        }
    }
}
