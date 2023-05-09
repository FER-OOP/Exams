package hr.fer.oop;


public abstract class User {
	protected String name;
	protected String password;
	protected int balance;
	
	public User(String name, String password, int balance) {
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public abstract void changePassword(String newPassword);
	
	
}
