package hr.fer.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		Path folder = Path.of("src/main/resources/");
		MaterialsFileVisitor visitor = new MaterialsFileVisitor();
		
		try {
			Files.walkFileTree(folder, visitor);
		} catch (IOException e) {			
			e.printStackTrace();
		}

		System.out.println("Total material count: " + visitor.getTotalMaterialCount());
		System.out.println("The biggest file: " + visitor.getBiggestFileName());
		System.out.println("PDF count for OOP.zip: " + visitor.getPdfCount("OOP.zip"));
		System.out.println("Size of the uncompressed OOP zip file: " + visitor.getCourseMaterialUncompressedSize("OOP.zip"));
		System.out.println("Size of the compressed OOP zip file: " + visitor.getCourseMaterialCompressedSize("OOP.zip"));
		
	}

}
