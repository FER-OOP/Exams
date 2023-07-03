package hr.fer.oop.stats;

import java.util.Collection;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Lambdas {

    public static BiConsumer<Stream<String>, 
            Map<String, Map<String, Double>>> loadFromStream = (lines, map) -> {}; //TODO

    public static BiFunction<Map<String, Map<String, Double>>, 
            String, Entry<String, Double>> getMinForTime = (map, time) -> null; //TODO

    public static BiFunction<Map<String, Map<String, Double>>, 
            String, Collection<Entry<String, Double>>> getValuesForCountry = (map, country) -> null; //TODO
}
