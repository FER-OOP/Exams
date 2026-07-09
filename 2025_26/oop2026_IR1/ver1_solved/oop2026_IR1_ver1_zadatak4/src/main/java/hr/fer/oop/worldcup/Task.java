package hr.fer.oop.worldcup;

import java.util.Map;
import java.util.stream.Stream;

public class Task {

    public static Stream<TeamInfo> successfulTeams(
            Map<String, Map<String, Integer>> teams,
            int minNoOfScorers,
            int minGoals) {

        return teams.entrySet()
                .stream()
                .filter(teamEntry ->
                        teamEntry.getValue()
                                .values()
                                .stream()
                                .filter(goals -> goals >= minGoals)
                                .count() >= minNoOfScorers
                )
                .map(entry -> new TeamInfo(
                        entry.getKey(),
                        entry.getValue().size()
                ));
    }

    public static Stream<TeamInfo> byScorersAndName(Stream<TeamInfo> teams) {
        return teams.sorted((a, b) -> {
            int r = Integer.compare(
                    b.noOfScorers(),
                    a.noOfScorers()
            );

            if (r == 0) {
                r = a.name().compareTo(b.name());
            }

            return r;
        });
    }
}