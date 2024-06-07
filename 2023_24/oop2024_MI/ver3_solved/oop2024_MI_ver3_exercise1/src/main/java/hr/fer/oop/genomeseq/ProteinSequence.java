package hr.fer.oop.genomeseq;

public class ProteinSequence extends Sequence {
	private String function;
	
	public ProteinSequence(String name, String sequence, String function) {
		super(name, sequence);
		this.function = function;
	}

	@Override
	public SequenceType getSeqType() {
		return SequenceType.PROTEIN;
	}
	
	public String toString() {
		String str = super.toString();
		
		return "(Protein sequence) " + this.function + '\n' + str;
	}

	public String getFunction() {
		return function;
	}

}
