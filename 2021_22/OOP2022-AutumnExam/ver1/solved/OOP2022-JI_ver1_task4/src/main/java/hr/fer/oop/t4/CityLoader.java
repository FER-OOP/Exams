package hr.fer.oop.t4;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityLoader {

	public static List<City> load(String path){
		
		Path filePath = Path.of(path);
		//Path filePath = Path.of("worldcities.csv");
		
		List<City> list = new ArrayList<>();
		Scanner sc;
		
		try {
			sc = new Scanner(filePath);

			while(sc.hasNext()) {

				String[] line = new String[11];
				line = sc.nextLine().split(",");

				//strip quotes
				for (int i=0; i<line.length; i++)
					line[i] = line[i].replace("\"", "");				
				
				//city type (primary, minor, "")
				CityType ct;
				if (line[8].equals("primary")) ct = CityType.PRIMARY;
				else if (line[8].equals("minor")) ct = CityType.MINOR;
				else ct = CityType.UNKNOWN;
						
				//ima gradova bez podatka o broju stanovnika
				int pop;
				if (line[9].length()>0) pop = Integer.valueOf(line[9]);
				else pop = -1;
									
				//line[7] preskacemo (admin name)
				City c = new City(line[0], line[1], Double.valueOf(line[2]), Double.valueOf(line[3]), 
						          line[4], line[5], line[6], ct, pop, Integer.valueOf(line[10]));
						
				list.add(c);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return list;
	
	}
	
	
}
