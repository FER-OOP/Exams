package hr.fer.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Collection<WeatherRecord>> map = new HashMap<>();
        //just to correctly find the project dir
        String startDir = System.getProperty("project.dir");
        if (startDir == null) {
            startDir = System.getProperty("user.dir");
        }
        try {
            Path path = Path.of(startDir, "src", "main", "resources", "weather_data_small.csv");
            Lambdas.loadFromStream.accept(Files.lines(path), map);
            System.out.println("The loaded map: " + map);
            System.out.println("The number of unique records: " + map.values().stream().mapToInt(collection -> collection.size()).sum());
            
            //no duplicates
            Lambdas.loadFromStream.accept(Files.lines(path), map);
            System.out.println("The number of unique records: " + map.values().stream().mapToInt(collection -> collection.size()).sum());
            
            Predicate<WeatherRecord> predicate = record -> record.getCity().equals("Zagreb");
            System.out.println("\nThe records for Zagreb in 2023 sorted by max temperature: " + Lambdas.getFilteredAndSortedFromCollection.apply(map.get(Integer.valueOf("2023")), predicate, WeatherRecord.BY_MAX_TEMP));
            
            predicate = record -> record.getCity().equals("Split");
            System.out.println("\nThe records for Split sorted by daily rainfall: " + Lambdas.getFilteredAndSortedFromMap.apply(map, predicate, WeatherRecord.BY_DAILY_RAIN));
        } catch (IOException ex) {
            System.out.println("The path does not exist: " + ex);
        }
    }
}
