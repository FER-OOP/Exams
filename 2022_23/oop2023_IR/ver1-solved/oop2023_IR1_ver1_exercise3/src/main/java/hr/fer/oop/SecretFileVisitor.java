package hr.fer.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SecretFileVisitor implements FileVisitor<Path> {
    private String decryptionKey;
    private int secretFileCount;
    private List<Path> foundFiles;


    public SecretFileVisitor(String decryptionKey) {
        this.decryptionKey = decryptionKey;
        this.secretFileCount = 0;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
        String decryptedText = decryptText(file);

            if (decryptedText.contains(decryptionKey)) {
                    secretFileCount++;
                    foundFiles.add(file);
                }
            }
            return FileVisitResult.CONTINUE;
        }


    public String decryptText(Path file) throws IOException {
        StringBuilder decryptedText = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                decryptedText.append(decrypt(line)).append("\n");
            }
        }
        return decryptedText.toString();
    }

    private String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder(encryptedText);
        return decryptedText.reverse().toString();
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }


    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Failed to visit file: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public int getSecretFileCount() {
        return secretFileCount;
    }
}
