package hr.fer.oop.mtexam.task2;

public class Main {
	public static void main(String[] args) {
		MultiAgentSystem mas = new MultiAgentSystem(4);
		mas.addAgent(new Auctioneer("Loud", MultiAgentSystem.generateId()));
		mas.addAgent(new Bidder("Wily", MultiAgentSystem.generateId(), BiddingStrategyType.TRUTHFUL));
		mas.addAgent(new Bidder("Crafty", MultiAgentSystem.generateId(), BiddingStrategyType.SPECULATIVE));
		mas.systemInfo();

		System.out.println("---");
		System.out.println(new Auctioneer("Boisterous", MultiAgentSystem.generateId()));
		System.out.println(new Bidder("Wise", MultiAgentSystem.generateId(), BiddingStrategyType.TRUTHFUL));
	}
}
