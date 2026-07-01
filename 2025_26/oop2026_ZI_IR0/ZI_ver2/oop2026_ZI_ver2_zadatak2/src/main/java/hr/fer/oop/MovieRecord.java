package hr.fer.oop;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MovieRecord {
	
		private String title;
	    private String director;
	    private List<String> actors;
	    private String genre;
	    private int runtimeMinutes;
	    private double rating;
	    private int rewatchCount;
	    private LocalDate watchDate;
	 
	   
	    public static final Comparator<MovieRecord> BY_RATING = null; //TODO
	 
	    public static final Comparator<MovieRecord> BY_RUNTIME = null; //TODO
	 
	    public static final Comparator<MovieRecord> BY_REWATCH = null; //TODO
	 
	    public MovieRecord(String title, String director, List<String> actors,
	                       String genre, int runtimeMinutes, double rating,
	                       int rewatchCount, LocalDate watchDate) {
	        this.title = title;
	        this.director = director;
	        this.actors = actors;
	        this.genre = genre;
	        this.runtimeMinutes = runtimeMinutes;
	        this.rating = rating;
	        this.rewatchCount = rewatchCount;
	        this.watchDate = watchDate;
	    }
	 
	   
	 
	    public String getTitle() {
			return title;
		}



		public String getDirector() {
			return director;
		}



		public List<String> getActors() {
			return actors;
		}



		public String getGenre() {
			return genre;
		}



		public int getRuntimeMinutes() {
			return runtimeMinutes;
		}



		public double getRating() {
			return rating;
		}



		public int getRewatchCount() {
			return rewatchCount;
		}



		public LocalDate getWatchDate() {
			return watchDate;
		}


	    @Override
	    public String toString() {
	        return "(" + title + ", " + director + ", " + actors + ", " + genre +
	               ", " + runtimeMinutes + ", " + rating + ", " + rewatchCount +
	               ", " + watchDate + ")";
	    }

}
