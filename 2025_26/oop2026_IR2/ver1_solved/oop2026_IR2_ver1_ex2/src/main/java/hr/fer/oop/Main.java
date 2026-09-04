package hr.fer.oop;

public class Main {
    public static void main(String[] args) {

        String[] lines = {
            "TUNA,42.5,Adriatic Sea",
            "sardine, 3.2 ,Kvarner",
            "MACKEREL,-5,Adriatic Sea",
            "SEABASS,12.0",
            "SHARK,10.0,Adriatic Sea",
            "TUNA,abc,Adriatic Sea"
        };

        CatchLogParser parser = new CatchLogParser(10);
        parser.parseLog(lines);

        System.out.println("Successfully read records: " + parser.getRecordCount());
        System.out.println("Number of errors: " + parser.getErrorCount());
        System.out.println("Total catch weight: " + parser.getTotalWeightKg());

        try {
            CatchLogParser small = new CatchLogParser(1);
            small.parseLog(new String[] {
                "TUNA,10.0,Adriatic Sea",
                "SARDINE,5.0,Kvarner"
            });
        } catch (LogFullException e) {
            System.out.println("Log is full, capacity: " + e.getCapacity());
        }
    }
}
