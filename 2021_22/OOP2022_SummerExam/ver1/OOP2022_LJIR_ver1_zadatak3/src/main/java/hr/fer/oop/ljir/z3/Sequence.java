package hr.fer.oop.ljir.z3;

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

	public double avgSeqQuality()  {
		// TODO: ovdje nadopunite metodu avgSeqQuality
	}
	
	public static List<Sequence> loadFromFile(String path) {
		// TODO: ovdje nadopunite metodu loadFromFile
	}
	
}
