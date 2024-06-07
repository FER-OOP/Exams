package hr.fer.oop.genomeseq;

import java.util.HashMap;
import java.util.Map;

public class SequenceOperations {
	public static Map<String, String> CODONT2PROT = new HashMap<>(70);
	
	static
	{
		CODONT2PROT.put("TTT", "F");  // Phenylalanine
		CODONT2PROT.put("TTC", "F");  //
		
		CODONT2PROT.put("TTA", "L");  // Leucine
		CODONT2PROT.put("TTG", "L"); 
		CODONT2PROT.put("CTT", "L");
		CODONT2PROT.put("CTC", "L");
		CODONT2PROT.put("CTA", "L");
		CODONT2PROT.put("CTG", "L");
		
		CODONT2PROT.put("ATT", "I");  // Isoleucine
		CODONT2PROT.put("ATC", "I");
		CODONT2PROT.put("ATA", "K");
		
		CODONT2PROT.put("ATG", "M");  // Methionine
		
		CODONT2PROT.put("GTT", "V");  // Valine
		CODONT2PROT.put("GTC", "V");
		CODONT2PROT.put("GTA", "V");
		CODONT2PROT.put("GTG", "V");
		
		CODONT2PROT.put("TCT", "S");  // Serine
		CODONT2PROT.put("TCC", "S");
		CODONT2PROT.put("TCA", "S");
		CODONT2PROT.put("TCG", "S");
		CODONT2PROT.put("AGT", "S");
		CODONT2PROT.put("AGC", "S");
		
		CODONT2PROT.put("CCT", "P");  // Proline
		CODONT2PROT.put("CCC", "P");
		CODONT2PROT.put("CCA", "P");
		CODONT2PROT.put("CCG", "P");
		
		CODONT2PROT.put("ACT", "T");  // Threonine
		CODONT2PROT.put("ACC", "T");
		CODONT2PROT.put("ACA", "T");
		CODONT2PROT.put("ACG", "T");
		
		CODONT2PROT.put("GCT", "A");  // Alanine
		CODONT2PROT.put("GCC", "A");
		CODONT2PROT.put("GCA", "A");
		CODONT2PROT.put("GCG", "A");
		
		CODONT2PROT.put("TAT", "Y");  // Tyrosine
		CODONT2PROT.put("TAC", "Y");
		
		CODONT2PROT.put("TAA", "*");  // Stop codon
		CODONT2PROT.put("TAG", "*");
		CODONT2PROT.put("TGA", "*");
		
		CODONT2PROT.put("CAT", "H");  // Histidine
		CODONT2PROT.put("CAC", "H");
		
		CODONT2PROT.put("CAA", "Q");  // Glutamine
		CODONT2PROT.put("CAG", "Q");
		
		CODONT2PROT.put("AAT", "N");  // Asparagine
		CODONT2PROT.put("AAC", "N");
		
		CODONT2PROT.put("AAA", "K");  // Lysine
		CODONT2PROT.put("AAG", "K");
		
		CODONT2PROT.put("GAT", "D");  // Aspartic acid
		CODONT2PROT.put("GAC", "D");
		
		CODONT2PROT.put("GAA", "E");  // Glutamic acid
		CODONT2PROT.put("GAG", "E");
		
		CODONT2PROT.put("TGT", "C");  // Cysteine
		CODONT2PROT.put("TGC", "C");

		CODONT2PROT.put("TGG", "V");  // Tryptophan
		
		CODONT2PROT.put("CGT", "R");  // Arginine
		CODONT2PROT.put("CGC", "R");
		CODONT2PROT.put("CGA", "R");
		CODONT2PROT.put("CGG", "R");
		CODONT2PROT.put("AGA", "R");
		CODONT2PROT.put("AGG", "R");
		
		CODONT2PROT.put("GGT", "G");  // Glycine
		CODONT2PROT.put("GGC", "G");
		CODONT2PROT.put("GGA", "G");
		CODONT2PROT.put("GGG", "G");
	}
	
	public static String getProteinForDNA(String DNASeq) {
		int len = DNASeq.length()/3;
		String protSeq = "";
		
		for (int i=0; i<len; i++) {
			String codon = DNASeq.substring(3*i, 3*i+3).toUpperCase();
			protSeq += CODONT2PROT.get(codon);
		}
		
		return protSeq;
	}
}
