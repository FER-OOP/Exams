package hr.fer.oop.final_2017_18.task1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class HandballVisitor extends SimpleFileVisitor<Path>{
	
	private static List<Player> listOfPlayers = new LinkedList<Player>();
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		//ako je tekstualna datoteka...
		if(file.toString().endsWith("txt")){
			String [] parts = file.toString().split("/");
			String teamName = parts[parts.length-1].substring(0, parts[parts.length-1].indexOf("."));
			
			//citaj red po red, stvaraj igrace i stavljaj ih u listu
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
					new BufferedInputStream(
					new FileInputStream(file.toString())),"UTF-8"));
			String line;
			while((line = br.readLine()) != null){
				String [] playerInfo = line.split(";");
				listOfPlayers.add(new Player(playerInfo[0], playerInfo[1], teamName, Integer.parseInt(playerInfo[2]), Integer.parseInt(playerInfo[3]), Integer.parseInt(playerInfo[4])));
			}
			br.close();
		}
		return FileVisitResult.CONTINUE;
	}
	public static void main (String [] args) throws IOException{
		Path rukomet = Paths.get("data/Handball"); // directory where all receipts are stored
		FileVisitor<Path> visitor = new HandballVisitor();
		Files.walkFileTree(rukomet, visitor);
		
		//ispis strijelaca na izlaz
		listOfPlayers.stream()
			.filter(s -> s.getGoals() > 5)
			.sorted((f1, f2) -> Integer.compare(f2.getGoals(), f1.getGoals()))
			.forEach(s -> {
				System.out.println(s.getName()+" "+s.getSurname()+" : "+s.getGoals());
		});
		
		//ispis prosjeka timova
		List<String> teams = new LinkedList<String>();
		listOfPlayers.stream().map(p -> p.getTeam()).distinct().forEach(t -> teams.add(t));
		
		for (String team : teams) {
			double avg = listOfPlayers.stream().filter(d -> d.getTeam().equals(team)).mapToInt(s -> s.getGoals()).average().getAsDouble();
			System.out.println(team +" : "+avg);
		}
	}

}
