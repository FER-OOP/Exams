package hr.fer.oop.mtexam.task2;

public class Main {
	public static void main(String[] args) {
		MultiAgentSystem mas = new MultiAgentSystem(4);
		mas.addAgent(new MobileAgent("Speedy", MultiAgentSystem.generateId()));
		mas.addAgent(new MobileAgent("Agile", MultiAgentSystem.generateId()));
		mas.addAgent(new IntelligentAgent("Brainy", MultiAgentSystem.generateId(), IntelligentAgentType.REASONER));
		mas.addAgent(new IntelligentAgent("Smart", MultiAgentSystem.generateId(), IntelligentAgentType.LEARNER));
		mas.printSystemInfo();

		System.out.println("---");
		System.out.println(new MobileAgent("Fast", MultiAgentSystem.generateId()));
		System.out.println(new IntelligentAgent("Clever", MultiAgentSystem.generateId(), IntelligentAgentType.REASONER));
	}
}
