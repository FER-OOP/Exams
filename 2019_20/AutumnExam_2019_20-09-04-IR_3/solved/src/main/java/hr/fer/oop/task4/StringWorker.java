package hr.fer.oop.task4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import javax.swing.SwingWorker;

class StringWorker extends SwingWorker<Integer, String> {

	private final List<String> slowList;
	private final String delimiter;
	private Consumer<List<String>> chunksProcessor;
	private Consumer<Integer> onDone;

	public StringWorker(List<String> slowList, String delimiter, Consumer<List<String>> chunksProcessor,
			Consumer<Integer> onDone) {
		this.slowList = slowList;
		this.delimiter = delimiter;
		this.chunksProcessor = chunksProcessor;
		this.onDone = onDone;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		int count = 0;

		for (String item : slowList) {
			List<String> splitParts = Arrays.asList(item.split(delimiter));
			count += splitParts.size();
			// publish intermediate results:
			for (String splitPart : splitParts) {
				publish(splitPart);
			}
		}

		return count;
	}

	@Override
	protected void process(List<String> chunks) {
		chunksProcessor.accept(chunks);
	}

	@Override
	protected void done() {

		try {
			onDone.accept(get());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}