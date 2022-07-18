package hr.fer.oop.ljir.z4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

class MultipleChoiceQuestionPanel extends JPanel {
	private MultipleChoiceQuestion question;
	private JLabel questionTitle = new JLabel("Naslov pitanja", SwingConstants.CENTER);
	private JTextArea questionText  = new JTextArea("Tekst pitanja", 10, 20);

	private JToggleButton c1Btn = new JToggleButton("Ponuđeni odgovor 1");
	private JToggleButton c2Btn = new JToggleButton("Ponuđeni odgovor 2");
	private JToggleButton c3Btn = new JToggleButton("Ponuđeni odgovor 3");
	
	// Add addditional attributes here
	
	public MultipleChoiceQuestionPanel(MultipleChoiceQuestion question) {
		
		// TODO: define position of components in the MultipleChoiceQuestionPanel
		
	}
	
	// TODO: define aditional methods here
	
}

public class MultipleChoiceQuizFrame extends JFrame {
	private MultipleChoiceQuestionPanel qpanel;
	private JButton answerBtn;
	private JLabel statusLbl;

	public MultipleChoiceQuizFrame(MultipleChoiceQuestion question) {
		qpanel = new MultipleChoiceQuestionPanel(question);
		answerBtn = new JButton("Odgovori!");
		
		// TODO: define the look and behavior for the MultipleChoiceQuizFrame

		setSize(400, 250);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    setTitle("Multiple Choice Quiz");
	}
}
