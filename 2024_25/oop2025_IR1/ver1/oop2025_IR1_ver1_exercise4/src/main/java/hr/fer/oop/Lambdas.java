package hr.fer.oop;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Lambdas {

    public static BiConsumer<Stream<String>, Map<Integer, Collection<WeatherRecord>>> loadFromStream = (lines, map) -> lines
            .map(line -> line.split(";"))
            .map(array -> new WeatherRecord(array[0], LocalDate.parse(array[1]), Double.parseDouble(array[2]), 
                    Double.parseDouble(array[3]), Integer.parseInt(array[4])))
            .forEach(record -> map.compute(record.getDate().getYear(), 
                    (year, collection) -> collection == null ? new HashSet<>() : collection).add(record));

    
    public static TriFunction<Collection<WeatherRecord>, Predicate<WeatherRecord>, Comparator<WeatherRecord>, Collection<WeatherRecord>> getFilteredAndSortedFromCollection = null; //TODO
    
    public static TriFunction<Map<Integer, Collection<WeatherRecord>>, Predicate<WeatherRecord>, Comparator<WeatherRecord>, Collection<WeatherRecord>> getFilteredAndSortedFromMap = null; //TODO
}
