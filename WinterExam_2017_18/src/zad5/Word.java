package zad5;

import java.io.IOException;
import java.nio.file.Path;

public class Word extends UredskiDokument {
	
	private String tekst;

	public Word(Path staza) {
		super(staza);
	}
	
	public String getTekst() {
		return tekst;
	}
	
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	@Override
	public void ucitaj() throws IOException {
		// ...
	}
}
