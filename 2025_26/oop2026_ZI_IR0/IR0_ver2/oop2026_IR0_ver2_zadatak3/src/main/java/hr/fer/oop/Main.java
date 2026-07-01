package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Box<Vinyl> rockBox = new Box<>();
        Box<Vinyl> jazzBox = new Box<>();

        try {
        	storage.addBox("rock", rockBox);
            storage.addBox("jazz", jazzBox);
            storage.addBox("jazz", jazzBox);	// ERROR (already exists Key)
        } catch (StorageException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        try {
        	storage.store("rock", new Album("Beatles", "Abbey Road", 25.0, 17));
            storage.store("rock", new Single("Beatles", "Hey Jude", 10.0, "Revolution"));
            storage.store("jazz", new Album("Miles Davis", "Kind of Blue", 30.0, 5));
            storage.store("jazz", new Album("John Coltrane", "A Love Supreme", 28.0, 4));
            storage.store("pop", new Single("ABBA", "Waterloo", 5.0, "Watch Out")); // ERROR (NOT found Key)
        } catch (StorageException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Most expensive box: " + storage.getMostExpensiveBoxName()); 

        System.out.println("\n--- The Beatles vinyls ---");
        for (Vinyl v : storage.findByArtist("Beatles")) {
            System.out.println(v);
        }

        System.out.println("\n--- All vinyl titles alphabetically ---");
        for (String v : storage.getAllVinylTitlesAlphabetically()) {
            System.out.println(v);
        }
    }
}