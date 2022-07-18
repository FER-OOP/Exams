package hr.fer.oop.ljir.zad1;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Festival f1 = new Festival(new String[]{"Aoki", "Artic Monkeys", "Dua Lipa", "Stromae"}, 100, 5, new TicketType[]{TicketType.MULTI_DAY_PASSES, TicketType.MULTI_DAY_PASSES, TicketType.DAILY_TICKET});
        Festival f2 = new Festival(new String[]{ "Nicky Romero", "Alesso", "DJ Snake"}, 75, 3, new TicketType[]{TicketType.VIP, TicketType.VIP});

        System.out.println("Total price: " + f1.calculatePrice());

        System.out.println("CHECK LINEUP: ");
        System.out.println(f1.checkLineup());
        System.out.println(f2.checkLineup());



    }
}

