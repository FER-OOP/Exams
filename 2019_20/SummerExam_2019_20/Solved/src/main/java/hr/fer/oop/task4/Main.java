package hr.fer.oop.task4;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> votesMap = Loader.loadData();

        System.out.println("Votes per election unit: " + getVotesPerElectionUnit(votesMap));
        //Votes per election unit: {eu1=1000, eu2=1000}
        System.out.println("Average votes per party: " + getAverageVotesPerParty(votesMap));
        //Average votes per party: {Red=350.0, Yellow=200.0, Blue=250.0, Green=200.0}
    }

    private static Map<String, Long> getVotesPerElectionUnit(Map<String, Map<String, Integer>> votesMap) {
        return votesMap.
                entrySet().
                stream().
                map(votesMapEntry -> new SimpleEntry<>(votesMapEntry.getKey(),
                votesMapEntry.getValue().values().stream().mapToLong(Integer::intValue).sum())).
                collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
    }

    private static Map<String, Double> getAverageVotesPerParty(Map<String, Map<String, Integer>> votesMap) {
        Map<String, List<Integer>> tempMap = new HashMap<>();

        //fill tempMap using merge
        votesMap.
                values().
                stream().flatMap(partyVotesMap -> partyVotesMap.entrySet().stream()).
                forEach(partyVotesPair
                        -> tempMap.merge(partyVotesPair.getKey(), new LinkedList<>(Arrays.asList(partyVotesPair.getValue())),
                        (oldVotesList, passedVotesList) -> {
                            oldVotesList.addAll(passedVotesList);
                            return oldVotesList;
                        }));

        //calculate result using tempMap
        return tempMap.
                entrySet().
                stream().
                map(nameGradeList -> new SimpleEntry<>(nameGradeList.getKey(),
                nameGradeList.getValue().stream().mapToInt(Integer::intValue).average().getAsDouble())).
                collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));

    }
}
