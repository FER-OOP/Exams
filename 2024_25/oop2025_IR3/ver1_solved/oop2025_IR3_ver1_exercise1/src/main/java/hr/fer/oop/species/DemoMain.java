package hr.fer.oop.species;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class DemoMain {

	public static void main(String[] args) throws IOException {
		Path path = Path.of("src", "main", "resources", "taxa.txt");
		Map<String, Set<String>> data;
		try(InputStream stream = Files.newInputStream(path)) {
			data = DataLoader.loadTaxa(stream);								
		}
		// printData(data); //uncomment if you want to see the content of the map
		
		int speciesCount = Task.count(data.values().stream());
		System.out.println("Number of species: " + speciesCount); // 4328
		
		Stream<Pair<String, Integer>> genera = Task.genera(data.entrySet().stream());
		genera.forEach(p -> System.out.println(p.first() + ":" + p.second()));
		//prints
		//Abies:1
		//Abutilon:1
		//Acalypha:3
		//...
		
		Stream<String> species = Task.species(data.entrySet().stream()); //it should be list of all species		
		System.out.println(species.toList()); //[Abies alba, Abutilon theophrasti, Acalypha australis, Acalypha rhomboidea, ...			
	}

	private static void printData(Map<String, Set<String>> data) {
		for(var entry : data.entrySet()) {
			System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
		}
		// first few lines printed...
		// Abies : [alba]
		// Abutilon : [theophrasti]
		// Acalypha : [australis, rhomboidea, virginica]
		// Acanthus : [balcanicus, mollis, spinosissimus]
		// Acer : [campestre, monspessulanum, negundo, obtusatum, opalus, platanoides, pseudoplatanus, saccharinum, tataricum]
		// Aceras : [anthropophorum]
		// Achillea : [abrotanoides, ageratum, aspleniifolia, clavennae, coarctata, collina, crithmifolia, distans, ligustica, millefolium, nobilis, odorata, pannonica, pratensis, ptarmica, setacea, tomentosa, virescens]
		// ...		
	}

}
