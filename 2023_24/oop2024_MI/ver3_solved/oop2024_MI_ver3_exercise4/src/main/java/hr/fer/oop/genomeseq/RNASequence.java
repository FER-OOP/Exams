package hr.fer.oop.genomeseq;

import java.util.HashMap;
import java.util.Map;

public class RNASequence extends Sequence {

	public RNASequence(String name, String sequence) {
		super(name, sequence);
	}
	
	
	public String toString() {
		return "RNA sequence: " + getName();
	}

}
