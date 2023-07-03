package hr.fer.oop.stats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Map<String, Collection<Entry<Integer, Long>>> map = new HashMap<>();
        
        //just to correctly find the project dir
        String startDir = System.getProperty("project.dir");
        if (startDir == null) {
            startDir = System.getProperty("user.dir");
        }

        try {
            Path path = Path.of(startDir, "src", "main", "resources", "MSUBS_small.csv");
            Lambdas.loadFromStream.accept(Files.lines(path), map);
            System.out.println("Loaded map: " + map);
            System.out.println("Min for Belgium: " + Lambdas.getMinForCountry.apply(map, "Belgium"));
            System.out.println("Values for 2017: " + Lambdas.getValuesForYear.apply(map, 2017));
        } catch (IOException ex) {
            System.out.println("The path does not exist: " + ex);
        }
    }
}
