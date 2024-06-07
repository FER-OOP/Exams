package hr.fer.oop.genomeseq;

public class Translate {
	public static String translate(String RNAseq) {
		
		if (RNAseq.length() % 3 != 0) throw new SequenceLengthException("Incorrect sequence length!");
		
		int len = RNAseq.length()/3;
		String protSeq = "";
		
		for (int i=0; i<len; i++) {
			String codon = RNAseq.substring(3*i, 3*i+3).toUpperCase();
			String AA = SequenceOperations.getAAForCodon(codon);
			if (AA == null) throw new CodonException(codon);
			protSeq += AA;
		}
		
		return protSeq;
	}
}
