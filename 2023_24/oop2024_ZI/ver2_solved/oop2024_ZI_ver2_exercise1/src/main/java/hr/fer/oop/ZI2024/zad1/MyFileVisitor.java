package hr.fer.oop.ZI2024.zad1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor implements FileVisitor<Path> {
	
    private List<Item> items;

    public MyFileVisitor() {
        this.items = new ArrayList<>();
    }
    
	public List<Item> getItems() {
		return items;
	}
	
	public double getTotalPrice() {
		return this.getItems().stream().mapToDouble(Item::getTotalPrice).sum(); // Ukupna suma cijena
	}
	
	public int getTotalQuantity() {
		return this.getItems().stream().mapToInt(Item::getQuantity).sum(); // Ukupna količina artikala
	}

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    	
    	String ext = file.toString().substring(file.toString().lastIndexOf("."));
    	    	    	
		if (ext.equals(".txt")) {
			// System.out.println("Reading file: " + file.toString());
            List<String> lines = Files.readAllLines(file); // Čitanje svih linija iz datoteke
            for (String line : lines) { // Za svaku liniju
                String[] parts = line.split("#"); // Razdvajanje linije na dijelove
                // System.out.println("Reading line: " + line + "|" + parts.length);
                if (parts.length == 3) { // Ako ima tocno 3 dijela
                	try {
                        String name = parts[0];
                        int qt = Integer.parseInt(parts[1]);
                        double price = Double.parseDouble(parts[2]);
                        items.add(new Item(name, qt, price));
                	} catch (NumberFormatException e) {
                		e.printStackTrace(); //System.err.println("Neispravni podaci u datoteci: " + file.toString());
                	}
                }
                else {
                	//System.err.println("Neispravni podaci u datoteci: " + file.toString());
                }
            }
        }   	

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("Greška pri pristupu datoteci: " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
}
