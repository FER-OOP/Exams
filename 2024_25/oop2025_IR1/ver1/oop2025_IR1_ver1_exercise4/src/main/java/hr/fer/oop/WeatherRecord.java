package hr.fer.oop;

import java.time.LocalDate;
import java.util.Comparator;

public class WeatherRecord {
    private String city;
    private LocalDate date;
    private double minTemperature;
    private double maxTemperature;
    private int dailyRainfall;
    
    public static final Comparator<WeatherRecord> BY_MIN_TEMP = null; //TODO
    public static final Comparator<WeatherRecord> BY_MAX_TEMP = null; //TODO
    public static final Comparator<WeatherRecord> BY_DAILY_RAIN = null; //TODO

    public WeatherRecord(String city, LocalDate date, double minTemperature, double maxTemperature, int dailyRainfall) {
        this.city = city;
        this.date = date;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.dailyRainfall = dailyRainfall;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public int getDailyRainfall() {
        return dailyRainfall;
    }

    @Override
    public int hashCode() {
        //TODO
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        //TODO
        return false;
    } 

    @Override
    public String toString() {
        return "(" + city + ", " + date + ", " + minTemperature + ", " + maxTemperature + ", " + dailyRainfall + ')';
    }        
}
