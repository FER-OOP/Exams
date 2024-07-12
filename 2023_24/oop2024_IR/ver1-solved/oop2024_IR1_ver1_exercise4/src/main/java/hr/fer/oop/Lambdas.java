package hr.fer.oop;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambdas {
    public static BiConsumer<Stream<String>, Map<Pair<String, String>, Collection<Pair<Integer, Long>>>> loadFromStream = (lines, map) -> lines.
            map(line -> line.split(";")).
            forEach(array -> map.compute(new Pair<>(array[0], array[1]), (key, value) -> {

        if (value == null) {
            value = new LinkedList<>();
        }

        value.add(new Pair<>(Integer.valueOf(array[2]), Long.valueOf(array[3])));
        return value;
    }));


    public static BiFunction<Map<Pair<String, String>, Collection<Pair<Integer, Long>>>, String, Triple<String, Integer, Long>> getMinForIncomingCountry = (map, incomingCountry) -> map.
            entrySet().
            stream().
            //filter by country
            filter(entry -> entry.getKey().first().equals(incomingCountry)).
            //get pair with max value from the collection of pairs year-value
            map(entry -> new Pair<>(entry.getKey().second(), entry.getValue().stream().sorted(Comparator.comparing(Pair::second)).findFirst().get())).
            //make a triple from each pair
            map(pair -> new Triple<>(pair.first(), pair.second().first(), pair.second().second())).
            //sort triples by min value 
            sorted(Comparator.comparing(Triple::third)).
            //get triple with min value 
            findFirst().
            //get value from Optional
            get();
            

        public static BiFunction<Map<Pair<String, String>, Collection<Pair<Integer, Long>>>, Integer, Collection<Triple<String, String, Long>>> getValuesForYear = (map, year) -> map.
                entrySet().
                stream().
                //get triple for the given year for each pair of countries
                map(entry -> new Triple<>(entry.getKey().first(), entry.getKey().second(), entry.getValue().stream().filter(pair -> pair.first().intValue() == year).findFirst())).                
                //get triple in the correct format String-String-Long from String-String-Optional
                map(triple -> new Triple<>(triple.first(), triple.second(), triple.third().get().second())).
                //collect all triples to a list
                collect(Collectors.toList());
}
