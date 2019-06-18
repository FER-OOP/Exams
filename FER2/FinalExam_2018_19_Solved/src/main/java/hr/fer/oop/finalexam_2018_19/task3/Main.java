package hr.fer.oop.finalexam_2018_19.task3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	public static void main(String[] args) {

	    BlockingQueue<String> carQueue = new ArrayBlockingQueue<>(1);
	    BlockingQueue<String> workshopStatusQueue = new ArrayBlockingQueue<>(1);

	    CarWorkshopManager manager = new CarWorkshopManager(workshopStatusQueue);
	    CarOwner owner1 = new CarOwner(carQueue, workshopStatusQueue, "Opel Astra");
	    CarOwner owner2 = new CarOwner(carQueue, workshopStatusQueue, "Fiat Punto");
	    CarOwner owner3 = new CarOwner(carQueue, workshopStatusQueue, "Renault Megane");
	    CarOwner owner4 = new CarOwner(carQueue, workshopStatusQueue, "Peugeot 206");
	    CarMechanic mechanic = new CarMechanic(carQueue, workshopStatusQueue);

	    new Thread(manager, "Gazda").start();
	    new Thread(owner1, "Vinko").start();
	    new Thread(owner2, "Filip").start();
	    new Thread(owner3, "Ivan").start();
	    new Thread(owner4, "Zoran").start();
	    new Thread(mechanic, "Mehanicar Marko").start();
	}
}
