package hr.fer.oop.hpi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //just to correctly find the project dir
        String startDir = System.getProperty("project.dir");
        if (startDir == null) {
            startDir = System.getProperty("user.dir");
        }

        try {
            Path path = Path.of(startDir, "src", "main", "resources", "HPI-small.hsv");
            Set<HousePriceIndex> set = HPIProcessor.loadFromStream.apply(Files.lines(path));
            System.out.println(set);
            Map<String, Double> map = HPIProcessor.collectionToMap.apply(set, RegionType.COUNTRY);            
            System.out.println("\n" + map);
            Collection<Entry<String, Double>> collection = HPIProcessor.getValuesForTime.apply(map, "Q1-2021");
            System.out.println("\n" + collection);

        } catch (IOException ex) {
            System.out.println("The path does not exist: " + ex);
        }
    }
}
