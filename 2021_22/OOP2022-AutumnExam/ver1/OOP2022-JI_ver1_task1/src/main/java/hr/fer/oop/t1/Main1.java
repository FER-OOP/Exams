package hr.fer.oop.t1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main1 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
		      JFrame frame = new DemoFrame();		     
		      frame.setVisible(true);
		    });
	}
}
