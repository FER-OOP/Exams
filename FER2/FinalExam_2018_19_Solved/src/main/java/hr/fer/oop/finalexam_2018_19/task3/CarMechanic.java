package hr.fer.oop.finalexam_2018_19.task3;

import java.util.concurrent.BlockingQueue;

public class CarMechanic implements Runnable {

	private BlockingQueue<String> carQueue;
	private BlockingQueue<String> workshopStatusQueue;

	public CarMechanic(BlockingQueue<String> carQueue, BlockingQueue<String> workshopStatusQueue) {
		this.carQueue = carQueue;
		this.workshopStatusQueue = workshopStatusQueue;
	}

	@Override
	public void run() {
		try {
			// izvrsavaj dok je autoradiona otvorena
			while (!CarWorkshopManager.WORKSHOP_CLOSED.equals(workshopStatusQueue.peek())) {
				// ili
				// while (!CarWorkshopManager.WORKSHOP_CLOSED
				// .equals(workshopStatusQueue.element())) {
				// popravi automobil koji je na redu
				String carToFix = carQueue.poll();
				if (carToFix != null && !carToFix.isEmpty()) {
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " has fixed " + carToFix + ".");
				}
			}
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " has gone home.");
	}
}