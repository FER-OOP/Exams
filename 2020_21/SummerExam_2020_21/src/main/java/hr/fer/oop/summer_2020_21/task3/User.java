package hr.fer.oop.summer_2020_21.task3;

public class User {

	private int userId, hoursActive, transactionsCount, currentSaldo;
	private String username, password, email;
	
	
	public User(int userId, String username, String password,
			String email, int hoursActive, int transactionsCount, int currentSaldo) {
		super();
		this.userId = userId;
		this.hoursActive = hoursActive;
		this.transactionsCount = transactionsCount;
		this.currentSaldo = currentSaldo;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHoursActive() {
		return hoursActive;
	}
	public void setHoursActive(int hoursActive) {
		this.hoursActive = hoursActive;
	}
	public int getTransactionsCount() {
		return transactionsCount;
	}
	public void setTransactionsCount(int transactionsCount) {
		this.transactionsCount = transactionsCount;
	}
	public int getCurrentSaldo() {
		return currentSaldo;
	}
	public void setCurrentSaldo(int currentSaldo) {
		this.currentSaldo = currentSaldo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

