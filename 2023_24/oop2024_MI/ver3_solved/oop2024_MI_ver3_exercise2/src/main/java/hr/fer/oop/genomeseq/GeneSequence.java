package hr.fer.oop.genomeseq;

public class GeneSequence extends Sequence implements CodingSequence{
	private int location;
	private String genomeName;	

	public GeneSequence(String name, String sequence) {
		this(name, sequence, "", -1);
	}
	
	public GeneSequence(String name, String sequence, String genomename, int location) {
		super(name, sequence);
		this.location = location;
		this.genomeName = genomename;
	}
	
	public String getProteinSequence() {
		return SequenceOperations.getProteinForDNA(this.getSeq());
	}

}
