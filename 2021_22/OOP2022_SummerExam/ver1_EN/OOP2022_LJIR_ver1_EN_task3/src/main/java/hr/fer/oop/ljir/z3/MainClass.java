package hr.fer.oop.ljir.z3;

import java.util.List;
import java.util.stream.Stream;

public class MainClass {

	public static void main(String[] args) {
		List<Sequence> seqList = Sequence.loadFromFile("src/main/resources/reads_small.fastq");

		System.out.println("Sequences:\n");
		System.out.println(seqList);
		
		System.out.println("\nTotal seq length:" + SequenceStats.totalSeqLength(seqList));
		
		System.out.println("\nSequence names:\n");
		List<String> seqnames = SequenceStats.seqNames(seqList.stream());
		seqnames.stream().forEach(System.out::println);
		
		System.out.println("\nAvg Sequence quality:" + SequenceStats.avgQuality(seqList));
		
		System.out.println("\nUsable sequences:\n");
		Stream<Sequence> usable = SequenceStats.usableSequences(seqList, 60.0);
		usable.forEach(System.out::println);
	}
}
