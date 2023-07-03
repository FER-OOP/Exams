package hr.fer.oop;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
	
		RewardsProgram program = new RewardsProgram();
		program.addConsumer("Ana", "Horvat", 90, 5);
		program.addConsumer("Ivan", "Car", 63, 4);
		program.addConsumer("Ema", "Kolar", 27, 3);
		program.addConsumer("Luka", "Medak", 45, 2);
		program.addConsumer("Petra", "Herceg", 72, 3);
		program.addConsumer("Fran", "Pehar", 45, 4);
		program.addConsumer("Lea", "Kralj", 63, 4);	
		program.addConsumer("Jakov", "Vincek", 53, 3);	
		program.addConsumer("Nika", "Novosel", 81, 2);	
		program.addConsumer("Lovre", "Razum", 9, 1);	
		program.addConsumer("Lana", "Kos", 45, 3);	
		program.addConsumer("Borna", "Rukavina", 63, 4);	
		program.addConsumer("Nina", "Posavec", 45, 3);	
		program.addConsumer("Filip", "Krolo", 72, 2);	
		program.addConsumer("Matea", "Poljak", 18, 1);	
		program.addConsumer("Marko", "Vitez", 63, 5);	
			 
		program.removeConsumers(List.of("Poljak", "Novosel", "Herceg")); 
		program.rankConsumers();
   
        System.out.println("Final ranking list: ");
        for (Consumer consumer : program.getConsumers()) {
            System.out.println(consumer.toString());
        }
    }
        
}