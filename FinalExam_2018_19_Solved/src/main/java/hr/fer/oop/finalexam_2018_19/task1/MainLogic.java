package hr.fer.oop.finalexam_2018_19.task1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainLogic {	

	public static void main(String[] args) {
		
		List<Car> listOfCars = new LinkedList<Car>();
		
		String filename = "data/Archive.zip";
		
		//otvaranje .zip datoteke
		try(ZipFile zip = new ZipFile(filename)){
			Enumeration<? extends ZipEntry> entries = zip.entries();
			//iteriranje elementima u zip datoteci i pronalazak tekstualnih datoteka
			while(entries.hasMoreElements()){
				ZipEntry entry = entries.nextElement();
				if (entry.getName().toLowerCase().endsWith(".txt")){  

					//stvaranje InputStream-a nad tekstualnom datotekom
					try (InputStream stream = zip.getInputStream(entry)){
						
						BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(stream), "UTF-8"));
						
						//stvaranje instanci klase Car
						while(true) {
							String line = br.readLine();							
							if (line == null || line.trim().isEmpty()) break;
							String [] parts = line.split(";");
							Car car = new Car(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]), Double.parseDouble(parts[6]));
							listOfCars.add(car);
						}
					}
					catch (IOException e) {
					}
				}
			}
		} catch (IOException e) {			
		}			
		
		try {
			Writer bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("data/izvjestaj.txt")),"UTF-8"));
		
			
			List<String> manufacturers = new LinkedList<>();
			listOfCars.stream()
					  .map(k ->k.getManufacturer())
					  .distinct()
					  .forEach(s -> manufacturers.add(s));					  
		
			for (String s : manufacturers) {
				long count = listOfCars.stream().filter(a -> a.getManufacturer().equals(s)).count();

				bw.write(s + " : " +Long.toString(count) + "\n");
			}
		
			bw.write(Double.toString(listOfCars.stream().filter(k -> k.getYearOfManufacture()<2015).mapToDouble(k->k.getGasConsumption()).average().getAsDouble()));

			bw.close();
		} catch (IOException e) {
		} 
	}
}
