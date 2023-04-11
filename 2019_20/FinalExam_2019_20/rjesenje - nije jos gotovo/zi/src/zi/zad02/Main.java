package zi.zad02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import zi.ScientificPaper;

public class Main {

	public static void main(String[] args) {
		
		Comparator<ScientificPaper> c1 = null;
		
		List<ScientificPaper> papers = new ArrayList<ScientificPaper>();

		Optional<Integer> godina = papers.stream().map(p->p.getYear()).min(Integer::compareTo);
		if(godina.isPresent()) {
			System.out.println("Najranija godina je: " + godina.get());
		}
		
		List<ScientificPaper> envPapers = papers.stream().filter(p->p.getTitle().contains("environmental")).sorted(c1).collect(Collectors.toList());
		
		
		papers.stream().flatMap(p->p.getKeywords().stream()).distinct().sorted().forEach(System.out::println);
	}
}
