package hr.fer.oop.t2;

import hr.fer.oop.t2.loaders.DataLoader;
import hr.fer.oop.t2.loaders.FileLoader;
import hr.fer.oop.t2.loaders.HardcodedLoader;
import hr.fer.oop.t2.loaders.NetworkLoader;

public class Main2 {

	public static void main(String[] args) {
		Counter c = new Counter();
		DataLoader loader = new HardcodedLoader();
		c.process(loader);
		System.out.println(c.getWords()); //{brown=1, dog=1, fox=1, jumps=1, lazy=1, over=1, quick=1, the=2}
		System.out.println(c.getExceptionsCount());//0
		
		loader = new FileLoader("data.txt"); 
		c.process(loader);
		System.out.println(c.getWords()); //{brown=2, dog=2, fox=2, jumps=2, lazy=2, over=2, quick=2, the=4}
		System.out.println(c.getExceptionsCount());//0
		
		loader = new FileLoader("no-file.txt");
		c.process(loader);
		System.out.println(c.getWords());//same as before
		System.out.println(c.getExceptionsCount());//1
		
		loader = new FileLoader(".");
		c.process(loader);
		System.out.println(c.getWords());//same as before
		System.out.println(c.getExceptionsCount());//2
		
		loader = new NetworkLoader("https://www.fer.hr/invalidpage");
		c.process(loader);
		System.out.println(c.getWords());//same as before
		System.out.println(c.getExceptionsCount());//3
	}
}
