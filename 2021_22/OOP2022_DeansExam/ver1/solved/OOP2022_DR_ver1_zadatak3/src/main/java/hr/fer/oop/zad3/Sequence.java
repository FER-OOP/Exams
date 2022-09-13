package hr.fer.oop.zad3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sequence {

	private String name;
	private String sequence;
	private String quality;

	public Sequence(String name, String sequence, String quality) {
		super();
		this.name = name;
		this.sequence = sequence;
		this.quality = quality;
	}

	public String getName() {
		return name;
	}

	public String getSequence() {
		return sequence;
	}

	public String getQuality() {
		return quality;
	}
	
	public String toString() {
		return "---SEQUENCE---\n"
			 + "Name: " + this.name + "\n"
			 + "Seq : " + this.sequence + "\n"
			 + "Qual: " + this.quality + "\n";
	}

	public boolean equals(Object other) {
		if (! (other instanceof Sequence)) return false;
		Sequence otherSeq = (Sequence)other;
		
		if (!this.name.equals(otherSeq.getName())) return false;
		if (!this.sequence.equals(otherSeq.getSequence())) return false;
		if (!this.quality.equals(otherSeq.getQuality())) return false;
		return true;
	}

	public double getGCContent() {
		int seqlen = this.sequence.length();
		int numGC = 0;
		for (int i=0; i<this.sequence.length(); i++) {
			char c = this.sequence.charAt(i);
			if (c == 'G' || c == 'g' || c == 'C' || c == 'c') numGC++;
		}
		
		return (double)numGC/seqlen;
	}
	
	public static List<Sequence> loadFromFile(String path) {
		List<Sequence> seqList = new ArrayList<>();
		String line1, line2, line3, line4;
		
		try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            while ((line1 = br.readLine()) != null) {
            	line2 = br.readLine();
            	line3 = br.readLine();
            	line4 = br.readLine();
            	
            	line1 = line1.substring(1);
            	Sequence seq = new Sequence(line1, line2, line4);
            	seqList.add(seq);
            }
		}
        catch(IOException ioe) {
            ioe.printStackTrace();
        }

		return seqList;
	}
	
}
