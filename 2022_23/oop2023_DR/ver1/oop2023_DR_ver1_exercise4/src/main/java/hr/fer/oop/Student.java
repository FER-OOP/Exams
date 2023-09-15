package hr.fer.oop;

import java.util.Objects;

public class Student {

	private int id;
	private String ime;
	private String prezime;
	
	public Student(int id, String ime, String prezime) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public int hashCode() {
		//return Objects.hash(id, ime, prezime);
		return ime.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id && Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	@Override
	public String toString() {
		return "(" + id + ", " + ime + ", " + prezime + ")";
	}
	
}
