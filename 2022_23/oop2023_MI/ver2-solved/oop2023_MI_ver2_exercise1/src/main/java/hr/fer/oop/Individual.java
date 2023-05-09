package hr.fer.oop;


public class Individual extends User implements Account{
	private String address;
	private final int limit;
    
	public Individual(String name, String password, int balance, String address, int limit) {
		super(name, password, balance);
		
		this.address = address;
		this.limit = limit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLimit() {
		return limit;
	}
	
	 @Override
	    public void performTransaction(int amount) {
		 int absAmount = Math.abs(amount);
		 if(absAmount>limit) return;
		 
		 // positive cash flow?
		 if(amount>0) balance+=amount;
		 else {
			 // check if we have enough money
			 if(balance>0 && balance>=amount) {
				 balance+=amount;
			 }
		 }

	    }
	 @Override
	   public void changePassword(String newPassword) {
		 if(newPassword.length() >=6)
		 	this.password = newPassword;
	    }
	     
}
