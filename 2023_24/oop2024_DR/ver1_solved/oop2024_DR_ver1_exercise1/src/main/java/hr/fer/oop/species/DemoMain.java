package hr.fer.oop.species;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class DemoMain {

	public static void main(String[] args) throws IOException {
		Path path = Path.of("src", "main", "resources", "vrste.txt");		
		try(InputStream stream = Files.newInputStream(path)) {
			Map<String, Set<String>> data = DataLoader.loadTaxa(stream);
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

}
