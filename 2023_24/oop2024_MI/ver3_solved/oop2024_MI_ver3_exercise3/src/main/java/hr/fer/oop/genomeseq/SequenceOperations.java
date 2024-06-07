package hr.fer.oop.genomeseq;

import java.util.HashMap;
import java.util.Map;

public class SequenceOperations {
	public static Map<String, String> CODONT2AA = new HashMap<>(70);
	
	static
	{
		CODONT2AA.put("TTT", "F");  // Phenylalanine
		CODONT2AA.put("TTC", "F");  //
		
		CODONT2AA.put("TTA", "L");  // Leucine
		CODONT2AA.put("TTG", "L"); 
		CODONT2AA.put("CTT", "L");
		CODONT2AA.put("CTC", "L");
		CODONT2AA.put("CTA", "L");
		CODONT2AA.put("CTG", "L");
		
		CODONT2AA.put("ATT", "I");  // Isoleucine
		CODONT2AA.put("ATC", "I");
		CODONT2AA.put("ATA", "K");
		
		CODONT2AA.put("ATG", "M");  // Methionine
		
		CODONT2AA.put("GTT", "V");  // Valine
		CODONT2AA.put("GTC", "V");
		CODONT2AA.put("GTA", "V");
		CODONT2AA.put("GTG", "V");
		
		CODONT2AA.put("TCT", "S");  // Serine
		CODONT2AA.put("TCC", "S");
		CODONT2AA.put("TCA", "S");
		CODONT2AA.put("TCG", "S");
		CODONT2AA.put("AGT", "S");
		CODONT2AA.put("AGC", "S");
		
		CODONT2AA.put("CCT", "P");  // Proline
		CODONT2AA.put("CCC", "P");
		CODONT2AA.put("CCA", "P");
		CODONT2AA.put("CCG", "P");
		
		CODONT2AA.put("ACT", "T");  // Threonine
		CODONT2AA.put("ACC", "T");
		CODONT2AA.put("ACA", "T");
		CODONT2AA.put("ACG", "T");
		
		CODONT2AA.put("GCT", "A");  // Alanine
		CODONT2AA.put("GCC", "A");
		CODONT2AA.put("GCA", "A");
		CODONT2AA.put("GCG", "A");
		
		CODONT2AA.put("TAT", "Y");  // Tyrosine
		CODONT2AA.put("TAC", "Y");
		
		CODONT2AA.put("TAA", "*");  // Stop codon
		CODONT2AA.put("TAG", "*");
		CODONT2AA.put("TGA", "*");
		
		CODONT2AA.put("CAT", "H");  // Histidine
		CODONT2AA.put("CAC", "H");
		
		CODONT2AA.put("CAA", "Q");  // Glutamine
		CODONT2AA.put("CAG", "Q");
		
		CODONT2AA.put("AAT", "N");  // Asparagine
		CODONT2AA.put("AAC", "N");
		
		CODONT2AA.put("AAA", "K");  // Lysine
		CODONT2AA.put("AAG", "K");
		
		CODONT2AA.put("GAT", "D");  // Aspartic acid
		CODONT2AA.put("GAC", "D");
		
		CODONT2AA.put("GAA", "E");  // Glutamic acid
		CODONT2AA.put("GAG", "E");
		
		CODONT2AA.put("TGT", "C");  // Cysteine
		CODONT2AA.put("TGC", "C");

		CODONT2AA.put("TGG", "V");  // Tryptophan
		
		CODONT2AA.put("CGT", "R");  // Arginine
		CODONT2AA.put("CGC", "R");
		CODONT2AA.put("CGA", "R");
		CODONT2AA.put("CGG", "R");
		CODONT2AA.put("AGA", "R");
		CODONT2AA.put("AGG", "R");
		
		CODONT2AA.put("GGT", "G");  // Glycine
		CODONT2AA.put("GGC", "G");
		CODONT2AA.put("GGA", "G");
		CODONT2AA.put("GGG", "G");
	}
	
	public static String getAAForCodon(String codon) {
		return CODONT2AA.get(codon);
	}
	
	
	public static String getProteinForDNA(String DNASeq) {
		int len = DNASeq.length()/3;
		String protSeq = "";
		
		for (int i=0; i<len; i++) {
			String codon = DNASeq.substring(3*i, 3*i+3).toUpperCase();
			protSeq += CODONT2AA.get(codon);
		}
		
		return protSeq;
	}
}
