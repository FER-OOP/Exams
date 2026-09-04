package hr.fer.oop;

public class InvalidSpeciesException extends CatchLogException {

    private final String invalidSpecies;

    public InvalidSpeciesException(int row, String invalidSpecies) {
        super(row, "Invalid species '" + invalidSpecies + "' at row " + row);
        this.invalidSpecies = invalidSpecies;
    }

    public String getInvalidSpecies() {
        return invalidSpecies;
    }
}
