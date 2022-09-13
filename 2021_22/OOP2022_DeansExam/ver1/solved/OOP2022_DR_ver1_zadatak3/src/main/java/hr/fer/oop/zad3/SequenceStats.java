package hr.fer.oop.zad3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceStats {
	public static int maxSeqLength(List<Sequence> seqList) {
		return seqList.stream()
				.mapToInt((s) -> s.getSequence().length())
				.max()
				.getAsInt();
	}
	
	public static List<String> seqNames(List<Sequence> seqList) {
		return seqList.stream()
				.map((s) -> s.getName())
				.collect(Collectors.toList());
	}
	
	public static double avgGCContent(Stream<Sequence> seqList) {
		return seqList
				.mapToDouble((s) -> s.getGCContent())
				.average()
				.getAsDouble();
	}
	
	// Sequences with GC content above given threshold
	public static Stream<Sequence> usableSequences(List<Sequence> seqList, double thGC) {
		return seqList.stream()
				.filter((s) -> s.getGCContent() > thGC)
				.map((s) -> new Sequence(s.getName(), s.getSequence(), ""));
	}
}
