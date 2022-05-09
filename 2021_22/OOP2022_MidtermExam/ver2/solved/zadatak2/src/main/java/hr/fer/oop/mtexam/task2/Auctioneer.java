package hr.fer.oop.mtexam.task2;

class Auctioneer extends Agent implements Auctionable {
	private int startingPrice;

	public Auctioneer(String name, int id) {
		super(name, id);
		startAuction();
	}

	public int getStartingPrice() {
		return startingPrice;
	}

	@Override
	public String getAgentType() {
		return "auctioneer";
	}

	@Override
	public void startAuction() {
	    startingPrice = (int) ((Math.random() * 11) + 10);
	}
}
