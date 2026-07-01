package hr.fer.oop;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieLambdas {

    /**
     * Filters the collection by the given predicate, then sorts it
     * with the given comparator and returns the top five results as a new collection.
     */
        
    public static Collection<MovieRecord> filterAndSortMovies(
	        Collection<MovieRecord> movies,
	        Predicate<MovieRecord> predicate,
	        Comparator<MovieRecord> comparator) {
	    return movies.stream()
	            .filter(predicate)
	            .sorted(comparator)
	            .limit(5)
	            .collect(Collectors.toList());
	}

    /**
     * Returns a stream of movies that were watched in the current calendar year.
     */
    public static Stream<MovieRecord> moviesThisYear(Stream<MovieRecord> movies) {
	    return movies.filter(m -> m.getWatchDate().getYear() == LocalDate.now().getYear());
	            
	}
  
    /**
     * Returns the directors with each of their movies listed on a separate line.
     */
    public static Stream<String> directorMovieTitles(Collection<MovieRecord> movies) {
        return movies.stream()
                .map(MovieRecord::getDirector)
                .distinct()
                .flatMap(director -> movies.stream()
                        .filter(m -> m.getDirector().equals(director))
                        .map(m -> director + ": " + m.getTitle()));
    }
    
    /**
     * Returns the top 3 directors ranked by average rating.
     */
    public static Stream<String> topThreeDirectors(Collection<MovieRecord> movies) {
        return movies.stream()
                .map(MovieRecord::getDirector)
                .distinct()
                .sorted(Comparator.comparingDouble(
                        (String director) -> movies.stream()
                                .filter(m -> m.getDirector().equals(director))
                                .mapToDouble(MovieRecord::getRating)
                                .average()
                                .getAsDouble())
                        .reversed())
                .limit(3);
    }

}