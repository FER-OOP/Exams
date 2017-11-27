package hr.fer.oop.midterm_2017_18.task5;

public class Main {

	public static void main(String[] args) {
		Person a = null;
		try {
			a = new Person("Ivo", 7, "pangender");
			System.out.println(a.getName());
		} 
		catch (NullPointerException ex) {
			System.out.println("NotInitialized!");
			a = new Person("Mario", 19, "male");
		} 
		catch (NotGenderException ex) {
			System.out.println(ex.getMessage());
			a = new Person("Josip", 7, "male");
		} 
		finally {
			System.out.println(a.getName());
		}
		
		try {
			gamble(a);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("All done!");
	}

	public static void gamble(Person a) {
		if (a.getAge() < 18) {
			throw new IllegalArgumentException("Age must be over 18!");
		} 
		else {
			String s1 = "d2";
			String s2 = "3";
			try {
				Integer i = Integer.parseInt(s1) + Integer.parseInt(s2);
				System.out.println(i);
			} 
			catch (IllegalArgumentException e) {
				System.out.println("Parametri ne valjaju!");
			} 
			catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
				System.out.println("Trace: " + e);
			} 
			finally {
				System.out.println("This method is finished!");
			}
		}
	}

}
