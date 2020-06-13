package hr.fer.oop.task4;

public class Person {

    private final String name;
    private final String surname;
    private final double id;

    public Person(String name, String surname, double id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getId() {
        return id;
    }
    
    @Override
    public String toString() {
    	return String.format("%s %s", name, surname);
    }
}
