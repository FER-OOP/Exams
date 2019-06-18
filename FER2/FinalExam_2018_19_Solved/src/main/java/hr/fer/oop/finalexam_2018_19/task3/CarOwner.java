package hr.fer.oop.finalexam_2018_19.task3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class CarOwner implements Runnable {

	private BlockingQueue<String> carQueue;
	private BlockingQueue<String> workshopStatusQueue;
	private String carName;

	public CarOwner(BlockingQueue<String> carQueue, BlockingQueue<String> workshopStatusQueue, String carName) {
		this.carQueue = carQueue;
		this.workshopStatusQueue = workshopStatusQueue;
		this.carName = carName;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((int) (Math.random() * 12000));
			System.out.println(Thread.currentThread().getName() + "'s " + carName + " needs fixing!");
			// ako je autoradiona zatvorena, vrati se kuci
			if (CarWorkshopManager.WORKSHOP_CLOSED.equals(workshopStatusQueue.peek())) {
				// ili
				// if (CarWorkshopManager.WORKSHOP_CLOSED
				// .equals(workshopStatusQueue.element())) {

				System.out.println(Thread.currentThread().getName() + " is too late, the workshop is closed.");
			}
			// ako cekas u redu "sat" vremena (1000 ms), vrati se kuci
			else if (!carQueue.offer(carName, 1000, TimeUnit.MILLISECONDS)) {
				System.out
						.println(Thread.currentThread().getName() + " is tired of waiting, he'll come back tomorrow.");
			}
		} catch (InterruptedException e) {
		}
	}
}