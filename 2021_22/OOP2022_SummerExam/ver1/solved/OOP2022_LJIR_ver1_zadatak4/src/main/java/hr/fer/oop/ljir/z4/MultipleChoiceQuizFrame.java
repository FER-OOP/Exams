package hr.fer.oop.ljir.z4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class MultipleChoiceQuizFrame extends JFrame {
	private MultipleChoiceQuestionPanel qpanel;
	private JButton answerBtn;
	private JLabel statusLbl;

	public MultipleChoiceQuizFrame(MultipleChoiceQuestion question) {
		qpanel = new MultipleChoiceQuestionPanel(question);
		this.getContentPane().add(qpanel, BorderLayout.CENTER);

		answerBtn = new JButton("Answer!");
		answerBtn.addActionListener((ActionEvent e) -> {
			qpanel.setSelectedAnswer();
			MultipleChoiceQuestion q = qpanel.getQuestion();
			if (!q.hasAnswer()) {
				statusLbl.setText("Choose an answer!");
			}
			else if (q.isCorrect()) {
				statusLbl.setText("Correct!");
			}
			else {
				statusLbl.setText("Incorrect!");
			}
			this.revalidate();

		});
		statusLbl = new JLabel("  ");
		
		JPanel southPane = new JPanel(new BorderLayout());

		southPane.add(answerBtn, BorderLayout.NORTH);
		southPane.add(statusLbl, BorderLayout.CENTER);
		
		/*
		JPanel southPane = new JPanel(new GridLayout(0, 1));

		southPane.add(answerBtn);
		southPane.add(statusLbl);
		*/

		this.add(southPane, BorderLayout.SOUTH);

		setSize(400, 250);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Multiple Choice Quiz");
	}
	
	public static class MultipleChoiceQuestionPanel extends JPanel {
		private MultipleChoiceQuestion question;
		private JLabel questionTitle = new JLabel("Question title", SwingConstants.CENTER);
		private JTextArea questionText  = new JTextArea("Question text", 10, 20);

		private JToggleButton c1Btn = new JToggleButton("Choice 1");
		private JToggleButton c2Btn = new JToggleButton("Choice 2");
		private JToggleButton c3Btn = new JToggleButton("Choice 3");

		private ButtonGroup choiceBtnGroup = new ButtonGroup();

		public MultipleChoiceQuestionPanel(MultipleChoiceQuestion question) {
			this.setLayout(new BorderLayout());

			add(questionTitle, BorderLayout.NORTH);
			add(questionText, BorderLayout.CENTER);

			choiceBtnGroup.add(c1Btn);
			choiceBtnGroup.add(c2Btn);
			choiceBtnGroup.add(c3Btn);

			JPanel choicePane = new JPanel(new GridLayout(1, 0));

			choicePane.add(c1Btn);
			choicePane.add(c2Btn);
			choicePane.add(c3Btn);

			add(choicePane, BorderLayout.SOUTH);

			setQuestion(question);
		}

		private void setQuestion(MultipleChoiceQuestion question) {
			this.question = question;
			questionTitle.setText(question.getQuestionTitle());
			questionText.setText(question.getQuestionText());
			c1Btn.setText(question.getChoice1());
			c2Btn.setText(question.getChoice2());
			c3Btn.setText(question.getChoice3());

			this.revalidate();
			this.setVisible(true);
		}

		public MultipleChoiceQuestion getQuestion() {
			return question;
		}

		public void setSelectedAnswer() {
			if (c1Btn.isSelected()) question.setAnswer(0);
			if (c2Btn.isSelected()) question.setAnswer(1);
			if (c3Btn.isSelected()) question.setAnswer(2);
		}
	}
}
