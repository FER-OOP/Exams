package zad5;

import java.io.IOException;
import java.nio.file.Path;

public class Excel extends UredskiDokument implements Provjerivo {

	private String[][] celije;

	public Excel(Path staza) {
		super(staza);
	}

	@Override
	public void ucitaj() throws IOException {
		//...
	}

	public String getCelija(int redak, int stupac) {
		//...
		return null;
	}
	
	public void setCelija(int redak, int stupac, String tekst) {
		//...
	}
	
	@Override
	public boolean provjeri() {
		// ...
		return false;
	}
}
