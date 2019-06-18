package hr.fer.oop.midtermexam2019.task3;

public class BoxOfRecords<T extends Record> extends BoxOfMemorabilia<T> {
	
	public int totalDuration() {
		int totalDuration = 0;
		for (Record record: getItems()) {
			totalDuration += record.getDuration();
		}
		return totalDuration;
	}
	
}