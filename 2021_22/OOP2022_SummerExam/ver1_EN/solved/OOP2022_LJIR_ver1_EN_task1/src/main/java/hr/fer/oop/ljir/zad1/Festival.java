package hr.fer.oop.ljir.zad1;
import java.util.Arrays;

public class Festival extends MusicEvent{

    private int duration;
    private TicketType[] tickets;

    public Festival(String[] lineup, double price, int duration, TicketType[] tickets) {
        super(lineup, price);
        this.duration = duration;
        this.tickets = tickets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public TicketType[] getTickets() {
        return tickets;
    }

    public void setTickets(TicketType[] tickets) {
        this.tickets = tickets;
    }

    public double calculatePrice() {
        double total = 0.0;
        for (TicketType type : tickets){
            if (type.equals(TicketType.MULTI_DAY_PASSES)) total+= (getPrice()*duration) * 0.8;
            else if (type.equals(TicketType.VIP)) total+= getPrice() * duration * 2;
            else if (type.equals(TicketType.DAILY_TICKET)) total+=getPrice();
        }
        return total;
    }

    @Override
    public String checkLineup() {
        if (getLineup().length < duration)  return "Add artists to lineup.";
        else return "Lineup:" + Arrays.toString(getLineup());
    }
}
