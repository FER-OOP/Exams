package hr.fer.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Pair<String,String>, Collection<Pair<Integer, Long>>> map = new HashMap<>();
        //just to correctly find the project dir
        String startDir = System.getProperty("project.dir");
        if (startDir == null) {
            startDir = System.getProperty("user.dir");
        }
        try {
            Path path = Path.of(startDir, "src", "main", "resources", "ACQNAT_small.csv");
            Lambdas.loadFromStream.accept(Files.lines(path), map);
            System.out.println("Loaded map: " + map);
            System.out.println("\nMin Incoming for Australia: " + Lambdas.getMinForIncomingCountry.apply(map, "Australia"));
            System.out.println("\nValues for 2020: " + Lambdas.getValuesForYear.apply(map, 2020));
        } catch (IOException ex) {
            System.out.println("The path does not exist: " + ex);
        }
    }
}