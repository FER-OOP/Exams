package prvi;

import java.util.HashSet;
import java.util.Set;

public class Chef implements Comparable<Chef>{

	private String firstName;
	private String lastName;
	private Set<SpecialtyDish> dishes;
	
	public Chef(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		dishes = new HashSet<>();
	}
	
	public void addDish(SpecialtyDish dish){
		if(dishes == null){
			dishes = new HashSet<>();
		}
		dishes.add(dish);
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishes == null) ? 0 : dishes.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chef other = (Chef) obj;
		if (dishes == null) {
			if (other.dishes != null)
				return false;
		} else if (!dishes.equals(other.dishes))
			return false;
		return true;
	}



	@Override
	public int compareTo(Chef chef) {
		int r = lastName.compareTo(chef.getLastName());
		if(r != 0)
			return r;
		r = firstName.compareTo(chef.getFirstName());
		return r;
	}	
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
