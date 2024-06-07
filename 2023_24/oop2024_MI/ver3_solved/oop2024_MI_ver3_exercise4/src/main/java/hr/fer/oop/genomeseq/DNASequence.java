package hr.fer.oop.genomeseq;

public class DNASequence extends Sequence {

	public DNASequence(String name, String sequence) {
		super(name, sequence);
	}
	
	public String toString() {
		return "DNA sequence: " + getName();
	}
	
}
