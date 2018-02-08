package hr.fer.oop.final_2017_18.task2;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Program {

    public static void main(String[] args) {
        List<Politician> politicians = DBLoader.loadPoliticians();
        List<Car> cars = DBLoader.loadCars();

        Collections.sort(politicians);
        for (Politician politician : politicians) {
            System.out.println(politician.toString());
        }

        System.out.println();
        Collections.sort(cars);
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
        Set<Car> carsSort = new TreeSet<>(Car.BY_MANUFACTURER.reversed().thenComparing(Car.BY_OWNER));
        carsSort.addAll(cars);

        for (Car element : carsSort) {
            System.out.println(element.toString());
        }
        System.out.println();

    }

}
