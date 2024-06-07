package hr.fer.oop.genomeseq;

// Abstract class representing a genome sequence
// It will be specialised downstream 
public abstract class Sequence {
// public class Sequence {
	private String name;
	private String seq;
	
	public Sequence(String name, String sequence) {
		this.name = name;
		this.seq = sequence;
	}
	
	public String toFASTA() {
		return ">" + name + "\n" + seq + "\n";
	}
	
	public String getSeq() {
		return seq;
	}

	public String getName() {
		return name;
	}
}
