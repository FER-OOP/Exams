package hr.fer.oop.zi.z1;

import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<PovertyDatum> dataset=PovertyLoader.load("src/main/resources/OECD_poverty_mini.csv");
        PovertyStats analyst = new PovertyStats(dataset);

        System.out.println(dataset.size());

        System.out.println("the worst instance: " + analyst.theWorst());

        for (String country : analyst.topImproving(2))
        {
            System.out.println("improving: " + country);
        }

        for (String country : analyst.topWorsening(4))
        {
            System.out.println("worsening: " + country);
        }

    }

}
