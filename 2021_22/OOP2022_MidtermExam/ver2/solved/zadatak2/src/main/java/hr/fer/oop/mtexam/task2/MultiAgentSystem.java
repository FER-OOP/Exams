package hr.fer.oop.mtexam.task2;

class MultiAgentSystem {
	private Agent[] agents;
	private static int generatedId;

	public MultiAgentSystem(int numberOfAgents) {
		if (numberOfAgents < 1)
			numberOfAgents = 1;
		agents = new Agent[numberOfAgents];
	}

	public int getNumberOfAgents() {
		return agents.length;
	}

	public Agent[] getAgents() {
		return agents;
	}

	public void addAgent(Agent agent) {
		if (agent.getID() < agents.length)
			this.agents[agent.getID()] = agent;
	}

	public void systemInfo() {
		for(Agent agent:agents) {
		    if (agent == null)
		      continue;
		    else
			  System.out.format("%s %s\n", agent.getAgentType(), agent);
		}
	}
	
	public static int generateId() {
		return generatedId++;
	}
}
