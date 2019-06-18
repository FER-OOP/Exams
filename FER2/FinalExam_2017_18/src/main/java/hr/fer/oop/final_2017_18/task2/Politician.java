package hr.fer.oop.final_2017_18.task2;

public class Politician implements Comparable<Politician> {

    private String oib;
    private String firstname;
    private String surname;
    private String party;

    public Politician(String oib, String firstname, String surname, String party) {
        this.oib = oib;
        this.firstname = firstname;
        this.surname = surname;
        this.party = party;
    }

    @Override
    public int hashCode() {
        return ((this.oib == null) ? 0 : this.oib.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Politician) {
            Politician other = (Politician) obj;
            return ((this.oib == null) ? false : this.oib.compareTo(other.oib) == 0);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Politician other) {
        int r = this.getParty().compareTo(other.getParty());
        if (r != 0) {
            return r;
        }
        return this.getOib().compareTo(other.getOib());
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "Politician{" + "oib=" + oib + ", firstname=" + firstname + ", surname=" + surname + ", party=" + party + '}';
    }

}
