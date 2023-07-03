package hr.fer.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RewardsProgram {

    private List<Consumer> consumers = new ArrayList<>();

    public void addConsumer(String firstName, String lastName, int rewardPoints, int membershipYears) {
        consumers.add(new Consumer(firstName, lastName, rewardPoints, membershipYears));
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void removeConsumers(List<String> removalNames) {
        for (Iterator<Consumer> it = consumers.iterator(); it.hasNext();) {
            Consumer consumer = it.next();
            if (consumer instanceof Consumer) {
                Consumer tmpEmployee = (Consumer) consumer;
                if (removalNames.contains(tmpEmployee.getLastName())) {
                    it.remove();
                }
            }
        }
    }
    
    private static final Comparator<Consumer> COMPARATOR = Comparator.comparing(Consumer::getRewardPoints).reversed().
            thenComparing(Comparator.comparing(Consumer::getMembershipYears).reversed()).
            thenComparing(Comparator.comparing(Consumer::getLastName));

    public void rankConsumers() {
        Collections.sort(consumers, COMPARATOR);
        //or like this: consumers.sort(COMPARATOR);
    }
}
