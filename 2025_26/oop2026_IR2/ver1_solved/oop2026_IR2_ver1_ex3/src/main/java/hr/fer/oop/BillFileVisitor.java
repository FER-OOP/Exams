package hr.fer.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BillFileVisitor extends SimpleFileVisitor<Path> {

    private final Map<String, List<String>> bills;

    public BillFileVisitor() {
        bills = new TreeMap<>();
    }

    public Map<String, List<String>> getBills() {
        return bills;
    }

    @Override
    public FileVisitResult visitFile(
            Path file,
            BasicFileAttributes attrs) throws IOException {
    	
        String fileName = file.getFileName().toString();

        if (fileName.contains("bill")) {
            String personName =
                    file.getParent().getFileName().toString();
            
    		InputStream istream = Files.newInputStream(file);
			BufferedReader buff = new BufferedReader(new InputStreamReader(istream));
				
			String firstLine = buff.readLine();
	        buff.close();

            List<String> personBills = bills.get(personName);

            if (personBills == null) {
                personBills = new ArrayList<>();
                bills.put(personName, personBills);
            }

            personBills.add(firstLine);
        }

        return FileVisitResult.CONTINUE;
    }
}