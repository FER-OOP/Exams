package hr.fer.oop.task4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        RentACarShop rentACarShop = new RentACarShop();
        Client client = new Client("a", "a", 1, format.parse("01-06-2020"));
        Seller seller1 = new Seller("b", "b", 2, format.parse("01-01-2010"));
        Seller seller2 = new Seller("c", "c", 3, format.parse("01-01-2015"));
        Car car = new Car("vw", "polo", 2016);
        RentACarTransaction t1 = new RentACarTransaction(client, seller1, car, format.parse("01-06-2020"), format.parse("30-06-2020"));
        t1.setDateOfReturn(format.parse("12-06-2020"));
        t1.setReturned(true);
        rentACarShop.addTransaction(t1);
        RentACarTransaction t2 = new RentACarTransaction(client, seller2, car, format.parse("01-06-2020"), format.parse("10-06-2020"));
        t2.setDateOfReturn(format.parse("12-06-2020"));
        t2.setReturned(true);
        rentACarShop.addTransaction(t2);


        //skup svih automobila koji su ikad bili posudjeni
        Set<Car> rentedCars = rentACarShop.getAllTransactions().stream()
                						  .map(t->t.getCar())
                						  .collect(Collectors.toSet());
        System.out.println(rentedCars);

        //skup svih automobila koji su ikad bili posudjeni, a koji su noviji od 2015
        Set<Car> rentedNewerCars = rentACarShop.getAllTransactions().stream()
                							   .map(t->t.getCar())
                							   .filter(c->c.getManufacturingYear() > 2015)
                							   .collect(Collectors.toSet());
        System.out.println(rentedNewerCars);

        //skup svih klijenata koji imaju barem jedan nevraceni auto
        Set<Client> clientsWithUnreturnedCars = rentACarShop.getAllTransactions().stream()
                											.filter(t->!t.isReturned())
                											.map(t->t.getClient())
                											.collect(Collectors.toSet());
        System.out.println(clientsWithUnreturnedCars);

        //skup svih klijenata koji su bar jednom prekoračili rok posudbe
        Set<Client> clientsNotRespectingDeadlines = rentACarShop.getAllTransactions().stream()
                												.filter(t->t.getDateOfReturn().after(t.getReturnDeadline()))
                												.map(t->t.getClient())
                												.collect(Collectors.toSet());
        System.out.println(clientsNotRespectingDeadlines);

        //skup svih prodavaca koji su ikad napravili neku transakciju, sortiranih prirodno po datumu zaposlenja
        List<Seller> sortedSellersWhoMadeARental = rentACarShop.getAllTransactions().stream()
                												.map(t->t.getSeller())
                												.sorted((s1, s2) -> s1.getEmploymentDate()
                												.compareTo(s2.getEmploymentDate()))
                												.collect(Collectors.toList());
        System.out.println(sortedSellersWhoMadeARental);
    }
}
