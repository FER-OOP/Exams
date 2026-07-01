package hr.fer.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) throws Exception {
		 
        String startDir = System.getProperty("project.dir");
        if (startDir == null) {
            startDir = System.getProperty("user.dir");
        }
 
        try {
            Path path = Path.of(startDir, "src", "main", "resources", "music_data.csv");
 
            Collection<MusicRecord> records = new LinkedHashSet<>();
 
            Files.lines(path)
                 .skip(1)                          // skip header
                 .filter(line -> !line.isBlank())
                 .forEach(line -> {
                     String[] parts = line.split(",", -1);
                     if (parts.length < 6) return; // skip malformed rows (e.g. missing genre)
                     String    songName    = parts[0].trim();
                     String    artistName  = parts[1].trim();
                     String    genre       = parts[2].trim();
                     int       duration    = Integer.parseInt(parts[3].trim());
                     int       listens     = Integer.parseInt(parts[4].trim());
                     LocalDate lastPlayed  = LocalDate.parse(parts[5].trim());
                     records.add(new MusicRecord(songName, artistName, genre,
                                                 duration, listens, lastPlayed));
                 });
 
      //  System.out.println("Loaded records: " + records);
 
 
	        // Filtering and sorting the collection and printing out the five most listened pop songs
	        Predicate<MusicRecord> predicate = record -> record.getGenre().equals("Pop");
	
	        System.out.println(
	        	    "\nTop 5 pop songs sorted by listen count: " +
	        	    MusicLambdas.filterAndSortCollection(
	        	        records,
	        	        predicate,
	        	        MusicRecord.BY_LISTENS.reversed()
	        	    )
	        	);
	
	        // Total listening time in minutes across all records
	        System.out.println(
	        	    "\nTotal listening time (minutes): " +
	        	    MusicLambdas.totalListeningTimeMinutes(records.stream())
	        	);
 
            // All songs grouped by genre
            System.out.println("\nSongs by genre:");
            MusicLambdas.songsByGenre(records).forEach(System.out::println);
            
            // Top five artists and their songs by total listen count
            System.out.println("\nTop 5 artists with songs:");
            MusicLambdas.topFiveArtists(records).forEach(System.out::println);
	
	    } catch (IOException ex) {
	        System.out.println("The path does not exist: " + ex);
	    }
	}
}
