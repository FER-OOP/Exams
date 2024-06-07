package hr.fer.oop.genomeseq;

public class MainClass3 {

	public static void main(String[] args) {
		
		String seq1 = "ACGTGTACG";				// len 9
		String seq2 = "ACGXGTACG";				// Incorrect nucleotide X
		String seq3 = "ACGTGTAGTACGTGTGTGAACA"; // len 22
		String seq4 = "ACGXGTAGTACGTGTGTGAACA"; // len 22 and incorrect nucleotide X
		
		String seq = seq2;
	
		try {
			String prot1 = Translate.translate(seq);
			System.out.println(prot1);
		}
		catch (SequenceLengthException e) {
			System.out.println("Incorrect sequence length");
		}
		catch (CodonException e) {
			String codon = e.getCodon();
			System.out.println("Incorrect codon: " + codon);
		}
		catch (SequenceException e) {
			System.out.println("Should not happen!");
		}
	}
}
