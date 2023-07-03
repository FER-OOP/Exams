package hr.fer.oop;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
	
		InnovationCompetition competition = new InnovationCompetition();
		competition.addEmployee("Ana", "Horvat", 10, 5);
		competition.addEmployee("Ivan", "Car", 7, 4);
		competition.addEmployee("Ema", "Kolar", 3, 3);
		competition.addEmployee("Luka", "Medak", 5, 2);
		competition.addEmployee("Petra", "Herceg", 8, 3);
		competition.addEmployee("Fran", "Pehar", 5, 4);
		competition.addEmployee("Lea", "Kralj", 7, 4);
		competition.addEmployee("Jakov", "Vincek", 6, 3);
		competition.addEmployee("Nika", "Novosel", 9, 2);
		competition.addEmployee("Lovre", "Razum", 1, 1);
		competition.addEmployee("Lana", "Kos", 5, 3);
		competition.addEmployee("Borna", "Rukavina", 7, 4);
		competition.addEmployee("Nina", "Posavec", 5, 3);
		competition.addEmployee("Filip", "Krolo", 8, 2);
		competition.addEmployee("Matea", "Poljak", 2, 1);
		competition.addEmployee("Marko", "Vitez", 7, 5);
		
        competition.removeEmployees(List.of("Poljak", "Novosel", "Herceg"));
        competition.rankEmployees();
   
        System.out.println("Final ranking list: ");
        for (Employee employee : competition.getEmployees()) {
            System.out.println(employee.toString());
        }
    }

}