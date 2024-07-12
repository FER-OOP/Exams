package hr.fer.oop;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Stream;


public class Lambdas {
    public static BiConsumer<Stream<String>, 
            Map<Pair<String, String>, Collection<Pair<Integer, Long>>>> loadFromStream = (lines, map) -> {}; //TODO


    public static BiFunction<Map<Pair<String, String>, Collection<Pair<Integer, Long>>>, 
            String, Triple<String, Integer, Long>> getMinForIncomingCountry = (map, incomingCountry) -> null; //TODO
            

    public static BiFunction<Map<Pair<String, String>, Collection<Pair<Integer, Long>>>, 
            Integer, Collection<Triple<String, String, Long>>> getValuesForYear = (map, year) -> null; //TODO

}
