package hr.fer.oop.task3;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Iva Topolovac
 */
public class Dog implements Comparable<Dog> {

    private String name;
    private char gender;
    private Date dateOfBirth;
    private Set<Breed> breed;
    private int weight;
    private String owner;
    private Size size;

    public static final Comparator<Dog> BY_BREED_PURITY = new ByBreedPurityComparator();
    public static final Comparator<Dog> BY_WEIGHT = (d1, d2) -> Integer.compare(d1.weight, d2.weight);
    public static final Comparator<Dog> BY_BREED_THEN_WEIGHT = BY_BREED_PURITY.thenComparing(BY_WEIGHT);

    private static class ByBreedPurityComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog dog1, Dog dog2) {
            int c = dog1.breed.size() - dog2.breed.size();
            return c;
        }
    }

    public Dog(String name, char gender, Date dateOfBirth, Set<Breed> breed, int weight, String owner) {        
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.weight = weight;
        this.owner = owner;
        
        if (weight > 10 && weight <= 20) {
            size = Size.SMALL;
        } else if (weight > 10 && weight <= 20) {
            size = Size.MEDIUM;
        } else if (weight > 10 && weight <= 20) {
            size = Size.LARGE;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + Objects.hash(dateOfBirth) + Objects.hash(owner) + Objects.hash(gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Dog)) {
            return false;
        }
        Dog other = (Dog) obj;

        return this.name.equals(other.name) && this.dateOfBirth.equals(other.dateOfBirth) && this.owner.equals(other.owner) && this.gender == other.gender;
    }

    @Override
    public int compareTo(Dog other) {
        int r = this.dateOfBirth.compareTo(other.dateOfBirth);
        if (r != 0) {
            return r;
        } 
        
        r = Integer.compare(this.weight, other.weight);
        if (r != 0) {
            return r;
        } 
        
        //any comparison order between this line is acceptable        
        r = this.name.compareTo(other.name);
        if (r != 0) {
            return r;
        } 
        
        r = Character.compare(this.gender, other.gender);
        if (r != 0) {
            return r;
        } else {
            return this.owner.compareTo(other.owner);
        }        
    }
}

