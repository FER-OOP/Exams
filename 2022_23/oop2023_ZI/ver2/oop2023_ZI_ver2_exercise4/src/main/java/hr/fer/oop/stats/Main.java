package hr.fer.oop.stats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Double>> map = new TreeMap<>();
        
        //just to correctly find the project dir
        String startDir = System.getProperty("project.dir");
        if (startDir == null) {
            startDir = System.getProperty("user.dir");
        }

        try {
            Path path = Path.of(startDir, "src", "main", "resources", "BSUBS_small.tsv");
            Lambdas.loadFromStream.accept(Files.lines(path), map);
            System.out.println("Loaded map: " + map);
            System.out.println("Min for Q4-2018: " + Lambdas.getMinForTime.apply(map, "Q4-2018"));
            System.out.println("Values for Belgium: " + Lambdas.getValuesForCountry.apply(map, "Belgium"));
        } catch (IOException ex) {
            System.out.println("The path does not exist: " + ex);
        }
    }
}
