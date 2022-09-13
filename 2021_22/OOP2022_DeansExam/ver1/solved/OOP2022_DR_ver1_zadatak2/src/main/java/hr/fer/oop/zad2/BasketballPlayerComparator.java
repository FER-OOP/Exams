package hr.fer.oop.zad2;

import java.util.Comparator;

public class BasketballPlayerComparator implements Comparator<BasketballPlayer> {
    @Override
    public int compare(BasketballPlayer player1, BasketballPlayer player2) {
        int result = Integer.compare(player1.getPosition(), player2.getPosition());

        if (result != 0) {
            return result;
        }

        result = Double.compare(player1.getPointsAvg(), player2.getPointsAvg());
        if (result != 0)
            return result;

        result = Double.compare(player1.getAssistsAvg(), player2.getAssistsAvg());
        if (result != 0)
            return result;

        return Double.compare(player1.getReboundsAvg(), player2.getReboundsAvg());
    }
}
