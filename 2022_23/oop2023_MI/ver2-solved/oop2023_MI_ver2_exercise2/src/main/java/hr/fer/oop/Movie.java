package hr.fer.oop;

import java.util.Arrays;


public class Movie implements Art {

	public Movie(String title, Director director, Person[] actors, Rating rating) {
    this.title = title;
    this.director = director;
    this.actors = actors;
    this.rating = rating;
  }
	protected String title;
	protected Director director;
	protected Person[] actors;
	protected Rating rating;

	@Override
  public Person author() {
    return director;
  }

	@Override
  public String toString() {
    return String.format("Movie '%s' by %s rated %s", title, author(), rating);
  }
}
