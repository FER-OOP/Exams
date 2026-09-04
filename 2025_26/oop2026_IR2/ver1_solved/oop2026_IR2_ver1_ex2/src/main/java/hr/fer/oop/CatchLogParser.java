package hr.fer.oop;

import java.util.Arrays;

public class CatchLogParser {

    private final CatchRecord[] records;
    private int count;
    private int errorCount;

    public CatchLogParser(int capacity) {
        this.records = new CatchRecord[capacity];
        this.count = 0;
        this.errorCount = 0;
    }

    public void parseLog(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            int row = i + 1;
            try {
                parseRow(lines[i], row);
            } catch (CatchLogException e) {
                errorCount++;
            }
        }
    }

    private void parseRow(String line, int row) throws CatchLogException {
        String[] parts = line.split(",", -1);
        if (parts.length != 3) {
            throw new RowFormatException(row);
        }

        String speciesRaw = parts[0].trim();
        String weightRaw = parts[1].trim();
        String location = parts[2].trim();

        double weightKg;
        try {
            weightKg = Double.parseDouble(weightRaw);
        } catch (NumberFormatException e) {
            throw new RowFormatException(row);
        }

        FishSpecies species;
        try {
            species = FishSpecies.valueOf(speciesRaw.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidSpeciesException(row, speciesRaw);
        }

        if (weightKg <= 0) {
            throw new InvalidWeightException(row, weightKg);
        }

        if (count == records.length) {
            throw new LogFullException(records.length);
        }

        records[count] = new CatchRecord(species, weightKg, location);
        count++;
    }

    public CatchRecord[] getRecords() {
        return Arrays.copyOf(records, count);
    }

    public int getRecordCount() {
        return count;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public double getTotalWeightKg() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += records[i].getWeightKg();
        }
        return total;
    }
}
