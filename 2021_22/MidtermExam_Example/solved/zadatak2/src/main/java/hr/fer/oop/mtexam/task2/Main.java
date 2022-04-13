package hr.fer.oop.mtexam.task2;

public class Main {
	public static void main(String[] args) {
		Wallet wallet = new Wallet(4);
		wallet.setToken(new Cryptocurrency(0.023, CryptocurrencyType.BTC), 0);
		wallet.setToken(new NFT(3, "CryptoKitties"), 1);
		wallet.setToken(new Cryptocurrency(17.5, CryptocurrencyType.ETH), 2);
		wallet.setToken(new NFT(7, "Doodles"), 3);
		wallet.checkWallet();

		System.out.println("---");
		System.out.println(new Cryptocurrency(0.023, CryptocurrencyType.BTC));
		System.out.println(new NFT(3, "CryptoKitties"));
	}
}
