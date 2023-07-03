package hr.fer.oop.stats;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambdas {

    public static BiConsumer<Stream<String>, Map<String, Map<String, Double>>> loadFromStream = (lines, map) -> lines.
            map(line -> line.split("\t")).
            forEach(array -> map.compute(array[1], (key, value) -> {

        if (value == null) {
            value = new HashMap<>();
        }

        value.put(array[0], Double.valueOf(array[2]));
        return value;
    }));

    public static BiFunction<Map<String, Map<String, Double>>, String, Entry<String, Double>> getMinForTime = (map, time) -> map.
            get(time).
            entrySet().
            stream().  
            sorted(Comparator.comparing(Entry::getValue)).
            findFirst().get();

    public static BiFunction<Map<String, Map<String, Double>>, String, Collection<Entry<String, Double>>> getValuesForCountry = (map, country) -> map.
            entrySet().
            stream().
            map(entry -> new SimpleEntry<>(entry.getKey(), entry.getValue().get(country))).
            collect(Collectors.toList());
}
