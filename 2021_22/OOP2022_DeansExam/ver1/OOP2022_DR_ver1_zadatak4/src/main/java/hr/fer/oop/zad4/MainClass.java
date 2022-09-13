package hr.fer.oop.zad4;

import javax.swing.SwingUtilities;

public class MainClass {

	public static void main(String[] args) throws Exception {
		MultipleChoiceQuestion q 
		= new MultipleChoiceQuestion("Question 1"
				   , "Which three numbers represent a Pythagorean triple?\n"
                   + "(Can represents the sides of a right angle triangle)"
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
