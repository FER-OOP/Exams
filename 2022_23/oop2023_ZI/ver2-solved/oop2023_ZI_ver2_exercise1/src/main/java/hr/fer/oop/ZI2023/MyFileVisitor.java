package hr.fer.oop.ZI2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private String fileName;
    private String folderName;
    private String firstLine;

    public MyFileVisitor(String fileName) {
        super();
        this.fileName = fileName;
    }

    public String getFirstLine() throws IOException {
        if (firstLine == null) {
            throw new IOException("File " + fileName + " does not exist!");
        }
        return firstLine;
    }

    public String getFolderName() throws IOException {
        if (firstLine == null) {
            throw new IOException("File " + fileName + " does not exist!");
        }
        return folderName;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().equals(this.fileName)) {
            this.folderName = file.getParent().toAbsolutePath().toString();

            try (BufferedReader BufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file)))) {
                firstLine = BufferedReader.readLine();
            }
            return FileVisitResult.TERMINATE;
        } else {
            return super.visitFile(file, attrs);
        }
    }

}
