package hr.fer.oop;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
	
	public static List<Ride> getRidesToStation(Stream<Ride> rides, String station) {
	    return rides
	            .filter(r -> r.getEndStation().equals(station))
	            .sorted(Comparator.comparingInt(Ride::getDurationMinutes))
	            .toList();
	}
	
	
	public static Stream<String> frequentStations(Stream<Ride> rides,int minRides,int minDuration) {

		return rides
	            .filter(ride -> ride.getDurationMinutes() >= minDuration)
	            .collect(Collectors.groupingBy(
	                    Ride::getStartStation,
	                    Collectors.counting()))
	            .entrySet()
	            .stream()
	            .filter(entry -> entry.getValue() >= minRides)
	            .map(Map.Entry::getKey);
	}
	
	public static Stream<String> getTop3Routes(Stream<Ride> rides) {
	    return rides
	            .collect(Collectors.groupingBy(
	                    r -> r.getStartStation() + " -> " + r.getEndStation(),
	                    Collectors.counting()
	            ))
	            .entrySet()
	            .stream()
	            .sorted(Map.Entry.<String, Long>comparingByValue()
	                         .reversed()
	                         .thenComparing(Map.Entry.comparingByKey())
	            )
	            .limit(3)
	            .map(Map.Entry::getKey);    
	}
}