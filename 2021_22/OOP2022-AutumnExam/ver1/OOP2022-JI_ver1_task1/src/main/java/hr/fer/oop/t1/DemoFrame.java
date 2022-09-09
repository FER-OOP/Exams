package hr.fer.oop.t1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoFrame extends JFrame {
	private JLabel generatingLabel;
	private JLabel clickedNumberLabel;
	//TO DO: Add if needed
	
	public DemoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(10, 10, 500, 200); // location and size
	    
	    generatingLabel = new JLabel("Press a button on the left to generate buttons in the middle", JLabel.CENTER);
	    clickedNumberLabel = new JLabel("This label should display number of the clicked button from the middle", JLabel.CENTER);
	   
	    //TO DO: continue
	}
}
