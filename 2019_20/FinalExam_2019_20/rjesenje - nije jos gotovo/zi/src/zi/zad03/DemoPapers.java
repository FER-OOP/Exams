package zi.zad03;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import zi.ScientificPaper;

public class DemoPapers {

	public static List<ScientificPaper> create() {
		List<ScientificPaper> list = new ArrayList<>();
		list.add(new ScientificPaper("Paper 1", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_abc.xml")));
		list.add(new ScientificPaper("Paper 2", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_123.xml")));
		list.add(new ScientificPaper("Paper 3", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_dfr.xml")));
		list.add(new ScientificPaper("Paper 4", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_ser.xml")));
		list.add(new ScientificPaper("Paper 5", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_3f4.xml")));
		list.add(new ScientificPaper("Paper 6", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_fff.xml")));
		list.add(new ScientificPaper("Paper 7", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_cre.xml")));
		list.add(new ScientificPaper("Paper 8", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_ble.xml")));
		list.add(new ScientificPaper("Paper 9", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_dbx.xml")));
		list.add(new ScientificPaper("Paper 10", new HashSet<>(), new HashSet<>(), "", "", 2000, Paths.get("/home/pero/paper_ott.xml")));
		return list;
	}

	public static Path convert(ScientificPaper p) {
		String s = p.getPath().getFileName().toString();
		s = s.substring(0, s.length()-3)+".pdf";
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		if(Math.random()<0.3) return null;
		return p.getPath().getParent().resolve(s);
	}
}
