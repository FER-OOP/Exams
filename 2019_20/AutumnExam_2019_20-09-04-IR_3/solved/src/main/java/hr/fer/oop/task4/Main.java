package hr.fer.oop.task4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Main extends JFrame {

	public Main() {
		setSize(200, 100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			Main window = new Main();
			window.setLocation(20, 20);
			window.setVisible(true);

			List<String> slowList = new SlowArrayList<>();
			slowList.add("You say you");
			slowList.add("wander your own land");

			String delimiter = " ";
			//implement chunksProcessor and onDone
			Consumer<List<String>> chunksProcessor = (strings) -> {
				for (String s : strings) {
					System.out.println("Found: " + s);
				}
			};
			Consumer<Integer> onDone = (result) -> {
				System.out.println("Total: "+result);
			};

			StringWorker worker = new StringWorker(slowList, delimiter, chunksProcessor, onDone);
			worker.execute();
		});
	}

	// SIMULATOR:

	static class SlowArrayList<E> extends ArrayList<E> {

		static final int SLOW_TIME = 2000;

		@Override
		public E get(int index) {
			slowMotion();
			return super.get(index);
		}

		private void slowMotion() {
			try {
				Thread.sleep(SLOW_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		@Override
		public Iterator<E> iterator() {
			slowMotion();

			Iterator<E> normalIterator = super.iterator();

			return new SlowIterator(normalIterator);
		}

		private class SlowIterator implements Iterator<E> {

			private Iterator<E> normalIterator;

			public SlowIterator(Iterator<E> normalIterator) {
				this.normalIterator = normalIterator;
			}

			@Override
			public boolean hasNext() {
				slowMotion();
				return normalIterator.hasNext();
			}

			@Override
			public E next() {
				slowMotion();
				return normalIterator.next();
			}

		}
	}

}
