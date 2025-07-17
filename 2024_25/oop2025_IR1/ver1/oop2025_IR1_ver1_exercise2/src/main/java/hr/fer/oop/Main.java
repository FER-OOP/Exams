package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pc = new MyPriorityQueue<>();
        
        System.out.println(pc.size()); //prints 0
        pc.add(7);
        pc.add(7);
        pc.add(2);
        pc.add(2);
        System.out.println(pc.size()); //prints 4
        System.out.println(pc.poll()); //prints 2
        System.out.println(pc.size()); //prints 3
        pc.add(1);
        System.out.println(pc.size()); //prints 4
        System.out.println(pc.poll()); //prints 1
        //pc.add(null); //throws NullPointerException        
        pc.add(8);
        
        //prints 2 7 7 8
        for (int n:pc) {
            System.out.print(n + " ");
        }  
        System.out.println();
        
        //prints {2=1, 7=2, 8=1}
        System.out.println(pc);
    }
}
