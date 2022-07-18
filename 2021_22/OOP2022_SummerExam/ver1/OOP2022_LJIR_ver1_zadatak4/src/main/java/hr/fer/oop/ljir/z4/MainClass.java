package hr.fer.oop.ljir.z4;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

public class MainClass {

	public static void main(String[] args) throws Exception {
		MultipleChoiceQuestion q 
		= new MultipleChoiceQuestion("Pitanje 1"
								   , "Koja tri ponuđena broja predstavljaju Pitagorinu trojku?\n"
				                   + "(Mogu biti strane pravokutnog trokuta)"
								   , "2, 3, 5"
								   , "3, 4, 6"
								   , "4, 5, 7"
								   , 0);		
		
		SwingUtilities.invokeAndWait(() -> {
			MultipleChoiceQuizFrame quizFrame = new MultipleChoiceQuizFrame(q);
			quizFrame.setLocation(20, 20);
			quizFrame.setVisible(true);
		});
	}

}
