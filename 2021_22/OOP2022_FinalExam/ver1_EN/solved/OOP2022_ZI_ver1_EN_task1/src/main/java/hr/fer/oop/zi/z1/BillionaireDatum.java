package hr.fer.oop.zi.z1;

public class BillionaireDatum {

    public BillionaireDatum(Integer rank, String name, Integer age, Integer worth, String country) {
        this.rank = rank;
        this.name = name;
        this.age = age;
        this.worth = worth;
        this.country = country;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorth() {
        return worth;
    }

    public void setWorth(Integer worth) {
        this.worth = worth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private Integer rank;
    private String name;
    private Integer age;
    private Integer worth;
    private String country;

    @Override
    public String toString() {
        return "BillionaireDatum{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", worth=" + worth +
                ", country='" + country + '\'' +
                '}';
    }
}
