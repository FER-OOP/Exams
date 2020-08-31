package hr.fer.oop.task2;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Hotel implements Comparable<Hotel> {

  private long oib;
  private String city;
  private String street;
  private String streetNo;
  private long rooms;
  private double pricePerNight;

  public Hotel(long oib, String city, String street, String streetNo, long rooms, double pricePerNight) {
    this.oib = oib;
    this.city = city;
    this.street = street;
    this.streetNo = streetNo;
    this.rooms = rooms;
    this.pricePerNight = pricePerNight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Hotel hotel = (Hotel) o;
    return oib == hotel.oib &&
        Objects.equals(city, hotel.city) &&
        Objects.equals(street, hotel.street) &&
        Objects.equals(streetNo, hotel.streetNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oib, city, street, streetNo);
  }

  @Override
  public int compareTo(Hotel o) {
    int r = Long.compare(oib, o.oib);
    if (r != 0)
      return r;
    r = city.compareTo(o.city);
    if (r != 0)
      return r;
    r = street.compareTo(o.street);
    if (r != 0)
      return r;
    else
      return streetNo.compareTo(o.streetNo);

  }

  public static final Comparator<Hotel> BY_MAX_REVENUE = new Comparator<Hotel>() {

    @Override
    public int compare(Hotel x, Hotel y) {
      Double xRev = x.rooms * x.pricePerNight;
      Double yRev = y.rooms * y.pricePerNight;
      return xRev.compareTo(yRev);
    }
  };

  public static final Comparator<Hotel> BY_CITY = Comparator.comparing(x -> x.city);



  @Override
  public String toString() {
    return "Hotel [oib=" + oib + ", city=" + city + ", street=" + street + ", streetNo=" + streetNo + ", rooms=" + rooms
        + ", pricePerNight=" + pricePerNight + "]";
  }

  public static void main(String[] args) {
    Set<Hotel> sortedHotels = new TreeSet<>(Hotel.BY_CITY.reversed().thenComparing(Hotel.BY_MAX_REVENUE));

    sortedHotels.add(new Hotel(54265, "Split", "Riječka", "22", 5, 300.0));
    sortedHotels.add(new Hotel(54265, "Split", "Vukovarska", "42", 10, 500.0));
    sortedHotels.add(new Hotel(7657, "Zagreb", "Unska", "3", 1, 800.0));

    sortedHotels.forEach(System.out::println);
  }
}