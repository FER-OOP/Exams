package hr.fer.oop.zi.z1;

import java.util.*;
import java.util.stream.Collectors;

public class BillionaireStats {

    public static int countCountry(List<BillionaireDatum> dst, String country)
    { return (int)dst.stream().filter(t-> t.getCountry().equals(country)).count();}

    public static int countAgeRange(List<BillionaireDatum> dst, int lower, int upper)
    { return (int) dst.stream().filter(t-> t.getAge()!=null && t.getAge()>=lower && t.getAge()<=upper).count();}

    public static Map<Integer, Long> makeHistogram(List<BillionaireDatum> dst, int binWidth) {
        int min = dst.stream().min(Comparator.comparing(BillionaireDatum::getWorth)).map(t -> t.getWorth()).get();

        return dst.stream().collect(Collectors.groupingBy(t -> min + (t.getWorth() - min) / binWidth * binWidth, TreeMap::new, Collectors.counting()));
    }

}
