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
		JPanel southPane = new JPanel(new GridLayout(0, 1));

		this.getContentPane().add(qpanel, BorderLayout.CENTER);

		answerBtn.addActionListener((ActionEvent e) -> {
			if (qpanel.c1Btn.isSelected()) question.setAnswer(0);
			if (qpanel.c2Btn.isSelected()) question.setAnswer(1);
			if (qpanel.c3Btn.isSelected()) question.setAnswer(2);
			if (!question.hasAnswer()) {
				statusLbl.setText("Choose an answer!");
			}
			else if (question.isCorrect()) {
				statusLbl.setText("Correct!");
			}
			else {
				statusLbl.setText("Incorrect!");
			}
			this.revalidate();

		});

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

		private ButtonGroup choiceBtnGroup = new ButtonGroup();

		public MultipleChoiceQuestionPanel(MultipleChoiceQuestion question) {
			this.setLayout(new BorderLayout());
			add(questionTitle, BorderLayout.NORTH);
			JPanel centerPane = new JPanel(new GridLayout(0, 1));
			JPanel choicePane = new JPanel(new GridLayout(0, 1));
			
			choiceBtnGroup.add(c1Btn);
			choiceBtnGroup.add(c2Btn);
			choiceBtnGroup.add(c3Btn);

			choicePane.add(c1Btn);
			choicePane.add(c2Btn);
			choicePane.add(c3Btn);

			centerPane.add(questionText);
			centerPane.add(choicePane);
			add(centerPane, BorderLayout.CENTER);

			setQuestion(question);
		}

		private void setQuestion(MultipleChoiceQuestion question) {
			questionTitle.setText(question.getQuestionTitle());
			questionText.setText(question.getQuestionText());
			c1Btn.setText(question.getChoice1());
			c2Btn.setText(question.getChoice2());
			c3Btn.setText(question.getChoice3());

			this.revalidate();
			this.setVisible(true);
		}		

	}
}
