package hr.fer.oop.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        CustomFileVisitor visitor1 = new CustomFileVisitor();
        Files.walkFileTree(Paths.get("."), visitor1);
        System.out.println(visitor1.toString());

        Files.walkFileTree(Paths.get("."), new CustomFileVisitor2());
    }
}
