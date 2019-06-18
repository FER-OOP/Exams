package hr.fer.oop.final_2017_18.task3;

import java.time.Instant;

public class Logger {  
	  /* Note: StringBuilder is not thread-safe! */
	  private StringBuilder sb = new StringBuilder();
	  private Instant lastChange = Instant.now();
	  /* creates a file with name in it's filename */
	  public Logger(String name) {/* ... */}
	  public void log(String entry) {
	    lastChange = Instant.now();
	    sb.append(lastChange.toString())
	      .append(":")
	      .append(entry)
	      .append(System.lineSeparator());
	  }
	  /* flushes the entries into a file */
	  public void flush() { 
		  System.out.println("Flushed... " + sb.toString());
		  sb.setLength(0);
	  }
}
