package hr.fer.oop.task2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class QuadraticEquationCalculator extends JFrame {
  private final int COEFF = 3;
  private final String PREFIX = "Result: ";
  private JPanel coeffPanel, buttonPanel;
  private JLabel resultLabel = new JLabel(PREFIX, JLabel.LEFT);
  private JLabel labels[] = new JLabel[COEFF];
  private JTextField inputs[] = new JTextField[COEFF];
  private String lebelTexts[] = {"(int) A  =  ", "(int) B =  ", "(int) C =  "};
  private JButton calculateButton = new JButton("Calculate");
  private JButton clearButton = new JButton("Clear");

  public QuadraticEquationCalculator() {

    super("Ax2+Bx+C=0");
    setSize(300, 170);
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    coeffPanel = new JPanel();
    coeffPanel.setLayout(new GridLayout(3, 0));
    for (int count = 0; count < COEFF; count++) {
      labels[count] = new JLabel(lebelTexts[count], JLabel.CENTER);
      inputs[count] = new JTextField(15);
      coeffPanel.add(labels[count]);
      coeffPanel.add(inputs[count]);
    }

    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.add(calculateButton);
    buttonPanel.add(clearButton);

    add(resultLabel, BorderLayout.NORTH);
    add(buttonPanel, BorderLayout.SOUTH);
    add(coeffPanel, BorderLayout.CENTER);


    calculateButton.addActionListener((e) -> {
      int A, B, C;
      try {
        A = Integer.parseInt(inputs[0].getText());
        B = Integer.parseInt(inputs[1].getText());
        C = Integer.parseInt(inputs[2].getText());
		  if (A == 0) {
			  throw new Exception();
		  }
      } catch (Exception ex) {
        resultLabel.setText(PREFIX + "wrong coefficients");
        return;
      }

		if (Math.pow(B, 2) - 4. * A * C >= 0) {
			resultLabel.setText(PREFIX +
					(-B + Math.sqrt(Math.pow(B, 2) - 4. * A * C)) / (2 * A) + ", " +
					(-B - Math.sqrt(Math.pow(B, 2) - 4. * A * C)) / (2 * A));
		} else {
			resultLabel.setText(PREFIX + "complex roots");
		}

    });

    clearButton.addActionListener((e) -> {
		for (JTextField i : inputs) {
			i.setText("");
		}
      resultLabel.setText(PREFIX);
    });

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      QuadraticEquationCalculator qec = new QuadraticEquationCalculator();
      qec.setResizable(false);
      qec.setVisible(true);
    });
  }
}
