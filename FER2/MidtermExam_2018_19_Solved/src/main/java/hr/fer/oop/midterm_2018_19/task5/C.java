package hr.fer.oop.midterm_2018_19.task5;


public class C implements AutoCloseable{

    private int i;
    
    public C (int i) {
        this.i = i;
        System.out.println("C:" + this.i);
    }
    
    public int val() {
    	return i;
    }

    @Override
    public void close() {
        System.out.println("close " + this.i);
    }

    public C m(C other){
        int x = this.i / other.i;
        return new C(x);
    }  
   
}
