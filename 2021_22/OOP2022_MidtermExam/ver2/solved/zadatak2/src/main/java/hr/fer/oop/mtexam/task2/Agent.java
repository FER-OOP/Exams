package hr.fer.oop.mtexam.task2;

abstract class Agent {
	private String name;
	private final int ID;

	Agent(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public int getID() {
		return ID;
	}
			
	public abstract String getAgentType();
	
	@Override
	public String toString() {
		return String.format("(name: %s, id: %d)", getName(), getID());
	}	
}
