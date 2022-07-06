package hr.fer.oop.zi.z1;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args)
    {
        List<BillionaireDatum> dataset= BillionaireLoader.load("src/main/resources/forbes_2022_top500_mini.tsv");

        System.out.println(dataset.size());

        System.out.println("country count: " + BillionaireStats.countCountry(dataset,"United States"));

        System.out.println("age range count: " + BillionaireStats.countAgeRange(dataset, 27,50));

        for (Map.Entry<Integer,Long> worthBucket : BillionaireStats.makeHistogram(dataset,21000).entrySet())
        {
            System.out.print("("+ worthBucket.getKey() +", "+ worthBucket.getValue()+ ") ");
        }

    }

}
