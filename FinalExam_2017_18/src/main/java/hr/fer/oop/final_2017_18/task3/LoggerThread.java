package hr.fer.oop.final_2017_18.task3;

import java.util.concurrent.BlockingQueue;

public class LoggerThread extends Logger implements Runnable {

	BlockingQueue<String> q;
	public static String STOPPING_SEQUENCE = "GIDDYDOWN!";

	public LoggerThread(BlockingQueue<String> queue, String loggerName) {
		super(loggerName);
		this.q = queue;
		new Thread(() -> {
			while (true) {
				try {
					this.flush();
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}).start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				String entry = q.take();
				if (STOPPING_SEQUENCE.equals(entry)) {
					flush();
					break;
				}
				log(entry);
			} 
			catch (InterruptedException e) {
			}
		}
	}
}