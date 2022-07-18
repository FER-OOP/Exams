package hr.fer.oop.ljir.zad2;

import java.util.Comparator;

public class PlayerComparator implements Comparator<FootballPlayer> {
    @Override
    public int compare(FootballPlayer player1, FootballPlayer player2) {
        int result = Integer.compare(player1.getOverallSkill(), player2.getOverallSkill());
        if (result != 0 ) {
            return result;
        }

        result = player1.getSurname().compareTo(player2.getSurname());

        if (result != 0) {
            return result;
        }

        return player1.getName().compareTo(player1.getSurname());
    }
}
