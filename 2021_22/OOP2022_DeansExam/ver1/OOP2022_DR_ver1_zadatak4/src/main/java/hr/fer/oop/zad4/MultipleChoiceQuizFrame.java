package hr.fer.oop.zad4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class MultipleChoiceQuizFrame extends JFrame {
	private MultipleChoiceQuestionPanel qpanel;
	private JButton answerBtn;
	private JLabel statusLbl;

	public MultipleChoiceQuizFrame(MultipleChoiceQuestion question) {
		qpanel = new MultipleChoiceQuestionPanel(question);
		answerBtn = new JButton("Odgovori!");		
		statusLbl = new JLabel("");
		JPanel southPane = new JPanel(/* Definirajte Layout za donji dio Frame-a */);

		
		// TODO: definiranje izgleda i ponašanja klase MultipleChoiceQuizFrame

		
		southPane.add(answerBtn);
		southPane.add(statusLbl);

		this.add(southPane, BorderLayout.SOUTH);

		setSize(400, 250);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    setTitle("Multiple Choice Quiz");
	}
	
	public static class MultipleChoiceQuestionPanel extends JPanel {
		private JLabel questionTitle = new JLabel("Question title", SwingConstants.CENTER);
		private JTextArea questionText  = new JTextArea("Question text", 10, 20);

		private JRadioButton c1Btn = new JRadioButton("Choice 1");
		private JRadioButton c2Btn = new JRadioButton("Choice 2");
		private JRadioButton c3Btn = new JRadioButton("Choice 3");

		// TODO: ovdje možete dodati članske varijable

		public MultipleChoiceQuestionPanel(MultipleChoiceQuestion question) {
			this.setLayout(new BorderLayout());
			add(questionTitle, BorderLayout.NORTH);
			JPanel centerPane = new JPanel(/* Definirajte Layout za centralni dio MultipleChoiceQuestionPanel-a */);
			JPanel choicePane = new JPanel(/* Definirajte Layout za dio prozora s ponuđenim odgovorima */);

			
			// TODO: Ovdje dopunite kod po potrebi
			
			
			centerPane.add(questionText);
			centerPane.add(choicePane);
			add(centerPane, BorderLayout.CENTER);
			
			// TODO: Ovdje dopunite kod po potrebi
		
		}

		// TODO: Ovdje možete dodati dodatne metode

	}
}
