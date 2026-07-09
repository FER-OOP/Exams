package hr.fer.oop;

public class WorldCupGameInfo {

    public String group;
    public String date;
    public String homeTeam;
    public String awayTeam;
    public int homeGoals;
    public int awayGoals;
    public String stadium;

    public WorldCupGameInfo(String group, String date, String homeTeam,
                            int homeGoals, int awayGoals,
                            String awayTeam, String stadium) {
        this.group = group;
        this.date = date;
        this.homeTeam = homeTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
    }

    public static WorldCupGameInfo createFromString(String line) {
        String[] parts = line.split("\t");

        String group = parts[0];
        String date = parts[1];
        String homeTeam = parts[2];

        String[] scoreParts = parts[3].split("-");
        int homeGoals = Integer.parseInt(scoreParts[0]);
        int awayGoals = Integer.parseInt(scoreParts[1]);

        String awayTeam = parts[4];
        String stadium = parts[5];

        return new WorldCupGameInfo(group, date, homeTeam,
                homeGoals, awayGoals, awayTeam, stadium);
    }

    @Override
    public String toString() {
        return group + " " + homeTeam + " " + homeGoals + "-"
                + awayGoals + " " + awayTeam + " (" + stadium + ")";
    }
}