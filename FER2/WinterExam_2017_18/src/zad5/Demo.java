package zad5;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		UredskiDokument[] dokumenti = new UredskiDokument[] { 
			new Excel(Paths.get("tablica.xls")),
			new Word(Paths.get("tekst.doc")), 
			new PowerPoint(Paths.get("prezentacija.ppt")) 
		};
		
		for (UredskiDokument doc : dokumenti) {
			System.out.printf("Učitavam %s.%n", doc.getStaza());
			try {
				doc.ucitaj(); // ucitava dokument; baca iznimku ako ne uspije
			} catch (IOException ex) {
				System.out.printf("Učitavanje nije uspjelo: %s.%n", ex.getMessage());
			}
		}
		
		// -----------------------------------------------------
		
		BooleovaFormula[] formule = new BooleovaFormula[] { 
			new AlgebarskiZapis("A AND B OR NOT C"),
			new SumaMinterma(new String[] { "A", "B", "C" }, new int[] { 1, 2, 5, 7 }) 
		};
		boolean[] vrijednost = new boolean[] { false, false, true };
		for (BooleovaFormula bf : formule) {
			System.out.printf("Funkcija: %s%n", bf);
			System.out.printf("Varijable: %s%n", Arrays.toString(bf.getVarijable()));
			System.out.printf("Vrijednost funkcije za ABC=%s je %b.%n", 
					Arrays.toString(vrijednost),
					bf.vrijednostZa(vrijednost));
		}
	}
}
