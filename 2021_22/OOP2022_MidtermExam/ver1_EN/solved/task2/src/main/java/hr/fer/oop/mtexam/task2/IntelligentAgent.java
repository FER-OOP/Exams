package hr.fer.oop.mtexam.task2;

class IntelligentAgent extends Agent {
	private IntelligentAgentType type;
	
	public IntelligentAgent(String name, int ID, IntelligentAgentType type) {
		super(name, ID);
		this.type = type;
	}

	public IntelligentAgentType getType() {
		return type;
	}
	
	public void setType(IntelligentAgentType type) {
		this.type = type;
	}
	
	@Override
	public String getAgentType() {
		return "intelligent agent";
	}	
}
