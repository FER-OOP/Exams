package hr.fer.oop.mtexam.task2;

class Bidder extends Agent {
	private BiddingStrategyType strategyType;
	
	public Bidder(String name, int id, BiddingStrategyType strategyType) {
		super(name, id);
		this.strategyType = strategyType;
	}

	public BiddingStrategyType getStrategyType() {
		return strategyType;
	}
	
	public void setStrategyType(BiddingStrategyType strategyType) {
		this.strategyType = strategyType;
	}
	
	@Override
	public String getAgentType() {
		return "bidder";
	}	
}
