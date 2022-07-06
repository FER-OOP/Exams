package hr.fer.oop.zi.z4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Calculator extends JFrame {

  private JPanel contentPane;
  private JTextField display;
  private JButton number0;
  private JButton number1;
  private JButton number2;
  private JButton number3;
  private JButton number4;
  private JButton number5;
  private JButton number6;
  private JButton number7;
  private JButton number8;
  private JButton number9;
  private JButton decimalPoint;
  private JPanel buttonsPanel;
  private JButton buttonDivide;
  private JButton buttonMultiply;
  private JButton buttonMinus;
  private JButton buttonEquals;
  private JButton buttonPlus;

  // you can put here additional fields

  public Calculator() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane = new JPanel();
    setContentPane(contentPane);

    display = new JTextField("0");
    display.setHorizontalAlignment(SwingConstants.RIGHT);
    display.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
    display.setColumns(10);
    display.setEnabled(false);

    buttonsPanel = new JPanel();

    number0 = new JButton("0");
    number1 = new JButton("1");
    number2 = new JButton("2");
    number3 = new JButton("3");
    number4 = new JButton("4");
    number5 = new JButton("5");
    number6 = new JButton("6");
    number7 = new JButton("7");
    number8 = new JButton("8");
    number9 = new JButton("9");
    decimalPoint = new JButton(".");

    buttonDivide = new JButton("/");
    buttonMultiply = new JButton("*");
    buttonMinus = new JButton("-");
    buttonEquals = new JButton("=");
    buttonPlus = new JButton("+");

    setupLayout();
    registerListeners();
  }

  void setupLayout() {
    // TODO fill in this method
  }
  
  void registerListeners() {
    // TODO fill in this method
  }

  void numberPressed(ActionEvent e) {
    // TODO fill in this method
  }
  
  void operatorPressed(ActionEvent e) {
    // TODO fill in this method
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        Calculator frame = new Calculator();
        frame.pack();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
