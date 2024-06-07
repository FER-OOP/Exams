package hr.fer.oop.genomeseq;

public class NucleotideSequence extends Sequence {

	public NucleotideSequence(String name, String sequence) {
		super(name, sequence);
	}

	@Override
	public SequenceType getSeqType() {
		return SequenceType.DNA;
	}

	public String toString()  {
		String str = super.toString();
		
		return "(Nulceotide sequence)\n" + str;
	}
	
}
