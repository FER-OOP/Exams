package hr.fer.oop.worldcup;

import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Map<String, Map<String, Integer>> teams = DataLoader.loadTeams();

        Stream<TeamInfo> successfulTeams =
                Task.successfulTeams(teams, 2, 5);

        successfulTeams.forEach(System.out::println);

     // prints (in any order)
        // TeamInfo[name=Brazil, noOfScorers=4]
        // TeamInfo[name=France, noOfScorers=3]
        // TeamInfo[name=Croatia, noOfScorers=5]

        System.out.println("----------");

        successfulTeams =
                Task.byScorersAndName(
                        Task.successfulTeams(teams, 1, 1)
                );

        successfulTeams.forEach(System.out::println);

        // prints (in exact order)
        //  TeamInfo[name=Argentina, noOfScorers=5]
        //	TeamInfo[name=Croatia, noOfScorers=5]
        //	TeamInfo[name=Brazil, noOfScorers=4]
        //	TeamInfo[name=France, noOfScorers=3]
        //	TeamInfo[name=Netherlands, noOfScorers=3]
        //	TeamInfo[name=Canada, noOfScorers=1]

        System.out.println("----------");

        successfulTeams =
                Task.successfulTeams(teams, 3, 5);

        successfulTeams.forEach(System.out::println);

        // prints nothing
    }
}