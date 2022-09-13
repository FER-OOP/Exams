package hr.fer.oop.zad1;
public class WeatherToday extends Weather implements WeatherTodayImpl{

    private int day;
    private int month;
    private int year;
    private String sunrise;
    private String sunset;

    public WeatherToday(double[] data, Unit unit, int day, int month, int year, String sunrise, String sunset) {
        super(data, unit);
        this.day=day;
        this.month=month;
        this.year=year;
        this.sunrise=sunrise;
        this.sunset=sunset;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public static double getTempInCelsius(double fahrenheit) {
        return (( 5 *(fahrenheit - 32.0)) / 9.0);
    }

    @Override
    public String daylight() {
        String[] p1 = sunset.split(":");
        String[] p2 = sunrise.split(":");
        int duration = (Integer.parseInt(p1[0]) * 60 + Integer.parseInt(p1[1])) - (Integer.parseInt(p2[0]) * 60 + Integer.parseInt(p2[1]));
        int hours = duration / 60;
        int minutes = duration % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public String dateFormat() {
        return String.format("%04d-%02d-%02d",  year, month, day);
    }


    @Override
    public String makeDescription() {
        double avg = 0;
        if (getUnit().equals(Unit.F)){
            avg = getTempInCelsius(Calculation.calculateAverage(getData()));
        }
        else avg = Calculation.calculateAverage(getData());
        return "WeatherToday [day=" + dateFormat() + ", daylightHours=" + daylight()  + ", average=" +  String.format("%.2f", avg) + "]";
    }

    @Override
    public boolean avgAboveThold(double thold) {
        if(getUnit().equals(Unit.F)) {
            double c = getTempInCelsius(Calculation.calculateAverage(getData()));
            if(c >= thold) return true;
            else return false;
        }
        else if(Calculation.calculateAverage(getData()) >= thold) return true;
        else return false;
    }
}

