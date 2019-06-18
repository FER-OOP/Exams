package hr.fer.oop.midterm_2018_19.task5;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[] { -5, 0, 2, 10, 6};
		try {
			for(int i=0; i<arr.length; i++) {				
				try (C c2 = new C(arr[arr.length - i])) {
					C c1 = new C(arr[i]);
					try(C c3 = c2.m(c1)) {                
		                System.out.format("i=%d val=%d%n", i, c3.val());
		            }  					
		            finally {
		                System.out.println("inner finally");
		            }    
				}	
				catch(IndexOutOfBoundsException e) {
		            System.out.println("ix exc");
		        }	
				catch(NullPointerException e) {
		            System.out.println("null exc");
		        }
				finally {
	                System.out.println("outer finally");
	            } 
			}    
		}
		catch(Exception exc) {
			System.out.println("outer exc");
		}
    }

}
