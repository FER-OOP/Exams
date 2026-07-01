package hr.fer.oop;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicLambdas {
	
	 /**
     * Filters a collection by the given predicate, then sorts it with
     * the given comparator. Returns the top five songs from the resulting collection.
     */
	public static Collection<MusicRecord> filterAndSortCollection(
	        Collection<MusicRecord> records,
	        Predicate<MusicRecord> predicate,
	        Comparator<MusicRecord> comparator) {
	    return records.stream()
	            .filter(predicate)
	            .sorted(comparator)
	            .limit(5)
	            .collect(Collectors.toList());
	}
 
    /**
     * Returns the total listening time in minutes across all records.
     * Total listening time per song = durationSeconds * listenCount.
     */
	public static long totalListeningTimeMinutes(Stream<MusicRecord> records) {
	    return records
	            .mapToLong(r -> (long) r.getDurationSeconds() * r.getListenCount())
	            .sum()/60;
	}
	
	/**
     * Returns a stream of the genres sorted and all of the artists in the genre.
     */
	 public static Stream<String> songsByGenre(Collection<MusicRecord> records) {
	        return records.stream()
	                .map(MusicRecord::getGenre)
	                .distinct()
	                .sorted()
	                .flatMap(genre -> records.stream()
	                        .filter(r -> r.getGenre().equals(genre))
	                        .map(r -> genre + ": " + r.getSongName()));
	    }
	 
	 /**
     * Returns the names of the top 5 artists ranked by total listen count
     * (sum of listenCount across all their songs), descending.
     */
	public static Stream<String> topFiveArtists(Collection<MusicRecord> records) {
        return records.stream()
                .map(MusicRecord::getArtistName)
                .distinct()
                .sorted(Comparator.comparingInt(
                        (String artist) -> records.stream()
                                .filter(r -> r.getArtistName().equals(artist))
                                .mapToInt(MusicRecord::getListenCount)
                                .sum())
                        .reversed())
                .limit(5);
    }
	
}
