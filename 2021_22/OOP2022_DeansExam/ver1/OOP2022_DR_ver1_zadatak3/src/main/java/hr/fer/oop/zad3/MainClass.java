package hr.fer.oop.zad3;

import java.util.List;
import java.util.stream.Stream;

public class MainClass {

	// Ova klasa nije važna za rješenje zadataka
	// Samo prikazuje primjer poziva pojedinih metoda
	public static void main(String[] args) {
		List<Sequence> seqList = Sequence.loadFromFile("src/main/resources/reads_small.fastq");

		System.out.println("Sequences:\n");
		System.out.println(seqList);
		
		System.out.println("\nMax seq length:" + SequenceStats.maxSeqLength(seqList));
		
		System.out.println("\nSequence names:\n");
		List<String> seqnames = SequenceStats.seqNames(seqList);
		seqnames.stream().forEach(System.out::println);
		
		System.out.println("\nAvg Sequence GC content:" + SequenceStats.avgGCContent(seqList.stream()));
		
		System.out.println("\nUsable sequences:\n");
		Stream<Sequence> usable = SequenceStats.usableSequences(seqList, 0.5);
		usable.forEach(System.out::println);
		
		System.out.println("\nGC content:\n");
		seqList.stream().map((s) -> s.getGCContent()).forEach(System.out::println);
	}

}
