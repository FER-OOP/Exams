package hr.fer.oop;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Please note the dataset is artificial, i.e., does not represent the real population.");

		String dataset = String.join("\n", 
				"Person_name ### Disability #% --",
				"Pero ### VISUAL #33.45 --", 
				"Marijeta ### Visual #10.22 --", 
				"Ana ### intellectual #15.78 --", 
				"Marko ### PHYSICAL #20.55 --",
				"Jasmina ### intellectual #5.67fgdgh56zzh --", // wrong
				"Sasha ### VISUAL #12.89 --", 
				"Luka ### HEARING #8.75", // wrong
				"Petra ### ", // wrong
				"Ivan ### PHYSICAL 18.92 --", // wrong
				"Marta ### VISUAL #28.14", // wrong
				"Elena ------> HEARING #14.67 --", // wrong
				"Nikola ### INTTTTTTTELEKETET #9.81 --", // wrong
				"Davor ### pHySiCAL #30.20 --", 
				"Katarina ### viSUAL #3.99 --");

		DisabilityDatasetManager manager = new Solution();
		int no = manager.processDataset(dataset);
		System.out.printf("Number of failed lines: %d \n", no);

		System.out.println("Share for physical disability: " + manager.share(Disability.PHYSICAL));
		System.out.println("Share for intellectual disability: " + manager.share(Disability.INTELLECTUAL));
		System.out.println("Share for visual disability: " + manager.share(Disability.VISUAL));

		// uncomment this to throw an exception:
		// manager.maxRating(Disability.INTELLECTUAL);

	}

}
