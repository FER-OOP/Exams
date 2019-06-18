package hr.fer.oop.fall_2017_18.task4;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import javax.swing.SwingWorker;

public class CounterWorker extends SwingWorker<Integer, String>{
	private String[] cars = {"ST-150-AA", "ZG-1156-GF", "DA-444-Z", "PU-198-ZE", "KA-123-KA",
							 "VU-350-RG", "SB-753-R", "GS-999-AA", "ZD-0055-EE"};
	private Random r = new Random();
	private String detectCar(){
		int i = r.nextInt(cars.length + 1);
		if (i == cars.length)
			return null;
		else
			return cars[i];		
	}
	Consumer<String> consumer;	
	private boolean stopMonitorig;
	
	public void stop(){
		this.stopMonitorig = true;
	}
	public CounterWorker(Consumer<String> consumer){
		this.consumer = consumer;		
	}
	
	@Override
	protected Integer doInBackground()  {
		int counter = 0;
		while(!stopMonitorig){
			try {
				String car = detectCar();
				if (car != null) {
					counter++;
					publish(car);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		return counter;
	}
	
	@Override
	protected void process(List<String> chunks) {
		for(String i : chunks){
			consumer.accept(i);
		}
	}		
}
