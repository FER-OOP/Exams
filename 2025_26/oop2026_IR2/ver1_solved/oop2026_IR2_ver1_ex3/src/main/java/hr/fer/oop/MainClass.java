package hr.fer.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        String startdir = System.getProperty("project.dir");

        if (startdir == null) {
            startdir = System.getProperty("user.dir");
        }


		Path path = Path.of(startdir, "src", "main", "resources", "data");


        BillFileVisitor visitor = new BillFileVisitor();
        System.out.println(path);
        try {
            Files.walkFileTree(path, visitor);

            for (Map.Entry<String, List<String>> entry
                    : visitor.getBills().entrySet()) {

                System.out.println(entry.getKey() + ":");

                List<String> sortedBills = new ArrayList<>(entry.getValue());
                
                Collections.sort(sortedBills);

                for (String bill : sortedBills) {
                    System.out.println("  " + bill);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}