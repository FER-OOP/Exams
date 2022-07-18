package hr.fer.oop.ljir.z3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceStats {
	public static int totalSeqLength(List<Sequence> seqList) {
		return seqList.stream()
				.mapToInt((s) -> s.getSequence().length())
				.sum();
	}
	
	public static List<String> seqNames(Stream<Sequence> seqList) {
		return seqList
				.map((s) -> s.getName())
				.collect(Collectors.toList());
	}
	
	public static double avgQuality(List<Sequence> seqList) {
		return seqList.stream()
				.mapToDouble((s) -> s.avgSeqQuality())
				.average()
				.getAsDouble();
	}
	
	// Sequences with Quality above threshold
	public static Stream<Sequence> usableSequences(List<Sequence> seqList, double thqual) {
		return seqList.stream()
				.filter((s) -> s.avgSeqQuality() > thqual)
				.map((s) -> new Sequence(s.getName(), s.getSequence(), ""));
	}

}
