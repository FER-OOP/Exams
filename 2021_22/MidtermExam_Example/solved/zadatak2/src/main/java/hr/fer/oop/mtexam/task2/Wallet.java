package hr.fer.oop.mtexam.task2;

class Wallet {
	private Token[] tokens;

	public Wallet(int count) {
		if (count < 1)
			count = 1;
		this.tokens = new Token[count];
	}

	public int getCount() {
		return tokens.length;
	}

	public Token[] getTokens() {
		return tokens;
	}

	public void setToken(Token token, int index) {
		if (index < tokens.length && index >= 0)
			this.tokens[index] = token;
	}

	public void checkWallet() {
		double euros = 0;
		for(Token token:tokens) {
		    if(token == null)
		      continue;
			if (token instanceof Exchangable) {
				Exchangable exchangable = (Exchangable) token;
				euros = token.getAmount() * exchangable.getExchangeRate();
				System.out.format("%s equals %.4f EUR, token type: %s\n", token, euros, token.getTokenType());
			}
			else
				System.out.format("%s, token type: %s\n", token, token.getTokenType());
		}
	}
}
