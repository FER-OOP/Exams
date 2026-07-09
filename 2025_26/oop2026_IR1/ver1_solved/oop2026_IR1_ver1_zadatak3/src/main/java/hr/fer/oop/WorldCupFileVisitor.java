package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WorldCupFileVisitor extends SimpleFileVisitor<Path> {

    private Set<String> allTeams = new TreeSet<>();
    private Set<String> defeatedTeams = new TreeSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {

        if (!attrs.isRegularFile() ||
                !file.getFileName().toString().endsWith(".txt")) {
            return FileVisitResult.CONTINUE;
        }

        try (Scanner sc = new Scanner(file)) {

            sc.nextLine(); // skip header

            while (sc.hasNextLine()) {
                WorldCupGameInfo game =
                        WorldCupGameInfo.createFromString(sc.nextLine());

                allTeams.add(game.homeTeam);
                allTeams.add(game.awayTeam);

                if (game.homeGoals > game.awayGoals) {
                    defeatedTeams.add(game.awayTeam);
                } else if (game.homeGoals < game.awayGoals) {
                    defeatedTeams.add(game.homeTeam);
                }
            }
        }

        return FileVisitResult.CONTINUE;
    }

    public Set<String> getUnbeatenTeams() {
        Comparator<String> comparator = Comparator
                .comparing(String::length)
                .thenComparing(Comparator.naturalOrder());

        Set<String> unbeatenTeams = new TreeSet<>(comparator);

        for (String team : allTeams) {
            if (!defeatedTeams.contains(team)) {
                unbeatenTeams.add(team);
            }
        }

        return unbeatenTeams;
    }
}