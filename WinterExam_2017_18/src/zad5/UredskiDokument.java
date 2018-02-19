package zad5;

import java.io.IOException;
import java.nio.file.Path;

public abstract class UredskiDokument {

	private Path staza;

	public UredskiDokument(Path staza) {
		super();
		this.staza = staza;
	}
	
	public Path getStaza() {
		return staza;
	}
	
	public abstract void ucitaj() throws IOException;
	
}
