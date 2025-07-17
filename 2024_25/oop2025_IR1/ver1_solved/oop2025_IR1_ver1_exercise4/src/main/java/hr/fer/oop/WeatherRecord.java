package hr.fer.oop;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class WeatherRecord {
    private String city;
    private LocalDate date;
    private double minTemperature;
    private double maxTemperature;
    private int dailyRainfall;
    
    public static final Comparator<WeatherRecord> BY_MIN_TEMP = Comparator.comparing(WeatherRecord::getMinTemperature);
    public static final Comparator<WeatherRecord> BY_MAX_TEMP = Comparator.comparing(WeatherRecord::getMaxTemperature);
    public static final Comparator<WeatherRecord> BY_DAILY_RAIN = Comparator.comparing(WeatherRecord::getDailyRainfall);

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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.city);
        hash = 23 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WeatherRecord other = (WeatherRecord) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    } 

    @Override
    public String toString() {
        return "(" + city + ", " + date + ", " + minTemperature + ", " + maxTemperature + ", " + dailyRainfall + ')';
    }       
}
