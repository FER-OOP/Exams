package hr.fer.oop.mtexam.task2;

class Cryptocurrency extends Token implements Exchangable {
	private CryptocurrencyType type;
	private double exchangeRate;
	
	public Cryptocurrency(double amount, CryptocurrencyType type) {
		super(amount, type.name());
		switch (type) {
			case BTC: 
				exchangeRate = 40400 + (int)(Math.random() * 501); // in EUR
				break;
			case ETH: 
				exchangeRate = 2900 + (int)(Math.random() * 101); // in EUR
				break;
		}
		
	}

	public CryptocurrencyType getType() {
		return type;
	}
	
	public void setType(CryptocurrencyType type) {
		this.type = type;
	}	

	@Override
	public String getTokenType() {
		return "Cryptocurrency";
	}
	
	@Override
	public double getExchangeRate() {
		return exchangeRate;
	}

	@Override
	public String toString() {
		return String.format("%.4f %s", getAmount(), getName());
	}	
}
