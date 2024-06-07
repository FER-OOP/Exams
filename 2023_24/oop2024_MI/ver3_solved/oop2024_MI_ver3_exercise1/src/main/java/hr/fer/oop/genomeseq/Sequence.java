package hr.fer.oop.genomeseq;

// Abstract class representing a genome sequence
// It will be specialised downstream 
public abstract class Sequence {
	public static int MAX_CHARS_TO_PRINT=50;
	private String name;
	private String seq;
	
	public Sequence(String name, String sequence) {
		this.name = name;
		this.seq = sequence;
	}
	
	public abstract SequenceType getSeqType();
	
	public String toString() {
		String seqprint = "";
		if (seq.length() > MAX_CHARS_TO_PRINT) 
			seqprint = seq.substring(0, MAX_CHARS_TO_PRINT) + "...";
		else seqprint = seq;
		
		return name + ": " + seqprint;
	}
	
	public String getSeq() {
		return seq;
	}
	public String getName() {
		return name;
	}
}
