package hr.fer.oop.genomeseq;

public class MainClass4 {

	public static void main(String[] args) {
		
		DNASequence s1 = new DNASequence("seq1", "ACGTGCTGA");
		DNASequence s2 = new DNASequence("seq2", "AGGGTGGA");
		
		RNASequence s3 = new RNASequence("seq3", "GGTTGTGTCCTGCGCTA");
		RNASequence s4 = new RNASequence("seq4", "GAGAT");
		
		MySeqList<Sequence> l1 = new MySeqList<>();	
		MySeqList<DNASequence> l2 = new MySeqList<>();
		MySeqList<RNASequence> l3 = new MySeqList<>();
		
		l2.add(s1);
		l2.add(s2);
		l3.add(s3);
		l3.add(s4);
		
		l1.addall(l2);
		l1.addall(l3);
		
		for (int i=0; i<l1.size(); i++) {
			Sequence s = l1.get(i);
			System.out.println(s);
		}
		
		Sequence seq = null;
		if (seq == null) System.out.println("NULL!");
	}
}
