package zad5;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class PowerPoint extends UredskiDokument {

	private List<String> stranice;
	
	public PowerPoint(Path staza) {
		super(staza);
	}

	@Override
	public void ucitaj() throws IOException {
		//...
	}
	
	public String dohvatiSlide(int indeks) {
		//...
		return null;
	}
	
	public void zapisiSlide(int indeks, String sadrzaj) {
		//...
	}
	
}
