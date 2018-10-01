package hr.fer.oop.fall_2017_18.task5;

import java.io.Closeable;
import java.io.IOException;

public class C implements Closeable{

    private Integer i = 0;

    public C () {
    }

    public C (Integer i) {
        this.i = i;
        System.out.println("open " + this.i);
    }

    @Override
    public void close() throws IOException {
        System.out.println("close " + this.i);
    }

    public void m(C other){
        System.out.println("m: " + this.i / other.i);
    }  

    public static void main(String[] args) {
        C c12 = new C(12);  
        try (C c6 = new C(6)){            
            try(C c2 = new C(2); C cN = null) {                
                c6.m(c2);                
                cN.m(c2);
            }           
            finally {
                System.out.println("inner finally");
            }         
            
            c12.m(c6);
            c6.m(new C());
        }
        catch(ArithmeticException e) {
            System.out.println("arithemtic exception");
        }
        catch(NullPointerException e) {
            System.out.println("null pointer exception");
        }
        catch(Exception e) {
            System.out.println("exception");
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("end");
    }
}
