package hr.fer.oop;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Ride> rides = List.of(
                new Ride("MLADOST", "TRŽNICA JARUN", 12),
                new Ride("MLADOST", "TRŽNICA JARUN", 14),
                new Ride("MLADOST", "TRŽNICA JARUN", 11),

                new Ride("AUTOBUSNI KOLODVOR",
                        "TRG KRALJA TOMISLAVA", 9),
                new Ride("AUTOBUSNI KOLODVOR",
                        "TRG KRALJA TOMISLAVA", 10),

                new Ride("NACIONALNA I SVEUČILIŠNA KNJIŽNICA",
                        "AUTOBUSNI KOLODVOR", 8),
                new Ride("NACIONALNA I SVEUČILIŠNA KNJIŽNICA",
                        "AUTOBUSNI KOLODVOR", 7),

                new Ride("TRŽNICA JARUN", "MLADOST", 13),

                new Ride("TRG KRALJA TOMISLAVA",
                        "S.D. STJEPAN RADIĆ", 24)
        );

        // 1.  Filtering rides by destination
        System.out.println("Rides to TRŽNICA JARUN:");

        Task.getRidesToStation(rides.stream(), "TRŽNICA JARUN")
                .forEach(System.out::println);


        // 2. Frequent start stations
        List<Ride> ridesForFrequentStations = List.of(
                new Ride("MLADOST", "TRŽNICA JARUN", 12),
                new Ride("MLADOST", "CENTAR", 15),
                new Ride("MLADOST", "AUTOBUSNI KOLODVOR", 5),

                new Ride("TRŽNICA JARUN", "MLADOST", 20),
                new Ride("TRŽNICA JARUN", "CENTAR", 25),

                new Ride("AUTOBUSNI KOLODVOR", "CENTAR", 7),
                new Ride("AUTOBUSNI KOLODVOR", "MLADOST", 8)
        );

        System.out.println();
        System.out.println("Frequent stations:");

        Task.frequentStations(ridesForFrequentStations.stream(), 2, 10).forEach(System.out::println);


        // 3. Three most frequent routes
        System.out.println();
        System.out.println("Top 3 routes:");

        Task.getTop3Routes(rides.stream()).forEach(System.out::println);
    }
}