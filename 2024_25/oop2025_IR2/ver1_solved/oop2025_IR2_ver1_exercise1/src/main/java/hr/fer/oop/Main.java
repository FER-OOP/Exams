package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        // Create a MediaCollection instance
        MediaCollection collection = new MediaCollection();
        
		// Adding books to the collection
        Book book1 = new Book("B-001", "The Hobbit", "In a hole in the ground there lived a hobbit.");
        Book book2 = new Book("B-002", "A Brief History of Time", "Popular-science book.");
        collection.addItem(book1);
        collection.addItem(book2);
        
        // Adding DVDs to the collection
        DVD dvd1 = new DVD("D-001", "The Lord of the Rings: The Fellowship of the Ring", 178);
        DVD dvd2 = new DVD("D-002", "The Lord of the Rings: The Two Towers", 179);
        collection.addItem(dvd1);
        collection.addItem(dvd2);
        
        // Adding magazines to the collection
        Magazine magazine1 = new Magazine("M-001", "National Geographic - May 2024", "A Journey to Mars.");
        collection.addItem(magazine1);
        
        // Adding a DVD supplement to the magazine
        DVD supplement = new DVD("S-001", "Documentary: Volcanoes", 55);
        collection.addItem(new Magazine("M-002", "PC Gamer - June 2025", "Exclusive previews, reviews of latest hardware for gaming.", supplement));

        // Print the descriptions of all items in the collection
        System.out.println("Description of all items in the collection:");
        collection.printAllDescriptions();

        // Retrieving and printing only the books
        System.out.println("\nOnly books in the collection:");        
        for (Book b : collection.getItemsOfTheSameTypeAsObject(book1)) { // Using book1 as a type reference
            System.out.println(b.getDescription());
        }

        // Retrieving and printing only the magazines
        System.out.println("\nOnly magazines in the collection:");
        for (Magazine m : collection.getItemsOfTheSameTypeAsObject(magazine1)) { // Using magazine1 as a type reference
            System.out.println(m.getDescription());
        }
    }
}
