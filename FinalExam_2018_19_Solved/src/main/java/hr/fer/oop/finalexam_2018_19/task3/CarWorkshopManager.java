package hr.fer.oop.finalexam_2018_19.task3;

import java.util.concurrent.BlockingQueue;

public class CarWorkshopManager implements Runnable {

	private BlockingQueue<String> workshopStatusQueue;
	public static final String WORKSHOP_OPEN = "WELCOME!";
	public static final String WORKSHOP_CLOSED = "GO HOME!";

	public CarWorkshopManager(BlockingQueue<String> workshopStatusQueue) {
		this.workshopStatusQueue = workshopStatusQueue;
	}

	@Override
	public void run() {
		try {
			// otvori autoradionu
			workshopStatusQueue.put(WORKSHOP_OPEN);

			System.out.println(Thread.currentThread().getName() + " says: 'Workshop is open!'");
			// ne radi ništa 8 "sati" (8000 ms)
			Thread.sleep(8000);
			// zatvori autoradionu
			workshopStatusQueue.take();

			workshopStatusQueue.put(WORKSHOP_CLOSED);
			System.out.println(
					Thread.currentThread().getName() + " says: 'Workshop is closed for today, come back tomorrow!'");
		} catch (InterruptedException e) {
		}
	}
}