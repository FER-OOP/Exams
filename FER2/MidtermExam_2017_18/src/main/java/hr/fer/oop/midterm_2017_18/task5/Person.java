package hr.fer.oop.midterm_2017_18.task5;

public class Person {
	private String name;
	private Integer age;
	private String gender;

	public Person(String name, Integer age, String gender) {
		if (gender.equals("male") || gender.equals("female")) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		} else {
			throw new NotGenderException(gender + " is not a gender!");
		}
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
}
