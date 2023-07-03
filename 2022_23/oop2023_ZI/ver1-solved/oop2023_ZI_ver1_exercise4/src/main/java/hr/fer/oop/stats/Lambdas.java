package hr.fer.oop.stats;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambdas {

    public static BiConsumer<Stream<String>, Map<String, Collection<Entry<Integer, Long>>>> loadFromStream = (lines, map) -> lines.
            map(line -> line.split(",")).
            forEach(array -> map.compute(array[0], (key, value) -> {

        if (value == null) {
            value = new LinkedList<>();
        }

        value.add(new SimpleEntry<>(Integer.valueOf(array[1]), Long.valueOf(array[2])));
        return value;
    }));

    public static BiFunction<Map<String, Collection<Entry<Integer, Long>>>, String, Entry<Integer, Long>> getMinForCountry = (map, country) -> map.
            get(country).
            stream().
            sorted(Comparator.comparing(Entry::getValue)).
            findFirst().get();

//    public static BiFunction<Map<String, Collection<Entry<Integer, Long>>>, Integer, Collection<Entry<String, Long>>> getValuesForYear = (map, year) -> map.
//            entrySet().
//            stream().
//            map(mapEntry -> new SimpleEntry<>(mapEntry.getKey(),
//            mapEntry.getValue().stream().filter(collectionEntry -> collectionEntry.getKey().equals(year)).findFirst().get().getValue())).
//            collect(Collectors.toList());
    public static BiFunction<Map<String, Collection<Entry<Integer, Long>>>, Integer, Collection<Entry<String, Long>>> getValuesForYear = (map, year) -> map.
            entrySet().
            stream().
            map(mapEntry -> {               
                for (Entry<Integer, Long> collectionEntry: mapEntry.getValue()) {
                    if (collectionEntry.getKey().equals(year)) {
                        return new SimpleEntry<>(mapEntry.getKey(), collectionEntry.getValue());
                    }
                }
                return null; //will not happen
            }).
            collect(Collectors.toList());
}
