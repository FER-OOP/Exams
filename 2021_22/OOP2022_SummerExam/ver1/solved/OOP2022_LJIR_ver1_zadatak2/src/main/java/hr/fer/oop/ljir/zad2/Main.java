package hr.fer.oop.ljir.zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FootballPlayer player1 = new FootballPlayer("Luka","Modric", 90, 80, 100);
        FootballPlayer player2 = new FootballPlayer("Ivan", "Modric", 90, 80, 100);
        FootballPlayer player3 = new FootballPlayer("Stipe", "Modric", 60, 60, 60);
        FootballPlayer player4 = new FootballPlayer("Luka", "Modric", 30, 30, 30);

        System.out.println(player1);

        System.out.println(player1.equals(player4));
        System.out.println(player1.hashCode() == player4.hashCode());

        List<FootballPlayer> playerList = new ArrayList<FootballPlayer>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);

        System.out.println("Before sorting: " + playerList);

        PlayerComparator playerComparator = new PlayerComparator();
        Collections.sort(playerList, playerComparator);

        System.out.println("After sorting: " + playerList);
    }
}
