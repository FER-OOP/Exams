package hr.fer.oop.zad1;

public class Main {

    public static void main(String[] args) {
        WeatherToday w1 = new WeatherToday(new double[]{77.0, 80.6, 75.20 , 73.4}, Unit.F, 10, 7, 2022,  "05:18", "20:46");
        System.out.println(w1.makeDescription());
        System.out.println(w1.avgAboveThold(24.74));
        WeatherToday w2 = new WeatherToday(new double[]{27,30,35,29,27,28}, Unit.C, 23, 7, 2022, "05:48", "20:31");
        System.out.println(w2.makeDescription());
        System.out.println(w2.avgAboveThold(33));
        WeatherToday w3 = new WeatherToday(new double[]{25.5,24,19,22,23,22.3}, Unit.C, 23, 5, 2022, "05:44", "20:15");
        System.out.println(w3.makeDescription());
        System.out.println(w3.avgAboveThold(22.63));

        WeatherToday test = new WeatherToday(new double[]{77.0, 80.6, 75.20 , 73.4}, Unit.F, 10, 07, 2022,  "13:44", "23:15");
        System.out.println(test.makeDescription());

    }
}
