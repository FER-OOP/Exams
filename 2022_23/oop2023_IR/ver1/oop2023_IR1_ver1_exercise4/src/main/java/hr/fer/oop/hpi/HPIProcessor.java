package hr.fer.oop.hpi;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;

public class HPIProcessor {

    public static Function<Stream<String>, Set<HousePriceIndex>> loadFromStream = lines -> null; //TODO

    public static BiFunction<Set<HousePriceIndex>, RegionType, Map<String, Double>> collectionToMap = (set, regionType) -> null; //TODO

    public static BiFunction<Map<String, Double>, String, Collection<Entry<String, Double>>> getValuesForTime = (map, time) -> null; //TODO
}
