/*package hr.fer.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // To correctly find the project dir
        String startdir = System.getProperty("project.dir");
        if (startdir == null) {
            startdir = System.getProperty("user.dir");
        }
        Path path = Path.of(startdir, "src", "main", "resources", "data");

        SecretFileVisitor visitor = new SecretFileVisitor("kljuc");

        try {
            Files.walkFileTree(path, visitor);

            int secretFileCount = visitor.getSecretFileCount();
            System.out.println("Total secret files found: " + secretFileCount);

            if (secretFileCount > 0) {
                System.out.println("Secret key found in file(s):");

                for (Path filePath : visitor.getFoundFiles()) {
                    System.out.println("Absolute path: " + filePath.toAbsolutePath());
                    System.out.println("----------------------------------------");
                }
            } else {
                System.out.println("Secret key not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

*/