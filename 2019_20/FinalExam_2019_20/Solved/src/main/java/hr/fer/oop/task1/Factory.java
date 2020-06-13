package hr.fer.oop.task1;

import java.util.HashSet;
import java.util.Set;

public class Factory {

	private Set<Resource> resources = new HashSet<>();	
	private String name;

	public Factory(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void add(Resource resource) {
		resources.add(resource);
	}	
	
	public void remove(Resource resource) {
		resources.remove(resource);
	}
}	
