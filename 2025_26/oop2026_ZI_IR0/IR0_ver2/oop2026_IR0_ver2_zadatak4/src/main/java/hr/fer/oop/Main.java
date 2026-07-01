package hr.fer.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        String startDir = System.getProperty("project.dir");

        if (startDir == null) {
            startDir = System.getProperty("user.dir");
        }

        try {

            Path path = Path.of(startDir, "src", "main", "resources", "movie_data.csv");

            Collection<MovieRecord> movies = new LinkedHashSet<>();

            Files.lines(path).skip(1).filter(line -> !line.isBlank()).forEach(line -> {

                String[] parts = line.split(",", -1);

                if (parts.length < 8) return;

                String title          = parts[0].trim();
                String director       = parts[1].trim();
                List<String> actors   = List.of(parts[2].split(";"));
                String genre          = parts[3].trim();
                int runtimeMinutes    = Integer.parseInt(parts[4].trim());
                double rating         = Double.parseDouble(parts[5].trim());
                int rewatchCount      = Integer.parseInt(parts[6].trim());
                LocalDate watchDate   = LocalDate.parse(parts[7].trim());

                movies.add(
                    new MovieRecord(
                        title,
                        director,
                        actors,
                        genre,
                        runtimeMinutes,
                        rating,
                        rewatchCount,
                        watchDate
                    )
                );
            });

//            System.out.println(
//                "Loaded movies: " + movies
//            );
            
         // Filtering and sorting the collection
            Predicate<MovieRecord> predicate =
                movie -> movie.getGenre().equals("Sci-Fi");
                
            System.out.println(
	        	    "\nTop 5 Sci-Fi movies sorted by rating: " +
	        	    MovieLambdas.filterAndSortMovies(
	        	        movies,
	        	        predicate,
	        	        MovieRecord.BY_RATING.reversed()
	        	    )
	        	);
            
         // Printing out the movies that were watched this year
            
            System.out.println("\nMovies watched this year:");
            MovieLambdas.moviesThisYear(movies.stream()).forEach(System.out::println);
             
            // All directors with their movie titles
            System.out.println("\nAll directors with their movies:");
            MovieLambdas.directorMovieTitles(movies).forEach(System.out::println);
            
            // Top three directors by average rating
            System.out.println("\nTop 3 directors by average rating:");
            MovieLambdas.topThreeDirectors(movies).forEach(System.out::println);

        } catch (IOException ex) {

            System.out.println(
                "The path does not exist: " + ex
            );
        }
    }
}