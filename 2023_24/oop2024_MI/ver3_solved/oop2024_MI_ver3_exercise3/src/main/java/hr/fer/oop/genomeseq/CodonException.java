package hr.fer.oop.genomeseq;

@SuppressWarnings("serial")
public class CodonException extends SequenceException {
	private String codon;
	
	public CodonException(String codon) {
		super("Unknown codon value: " + codon);
		this.codon = codon;
	}
	
	public String getCodon() {
		return codon;
	}

}
