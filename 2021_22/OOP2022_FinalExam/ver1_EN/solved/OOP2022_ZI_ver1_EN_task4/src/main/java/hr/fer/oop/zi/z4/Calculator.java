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

  private String register;
  private String operator = "";
  private boolean entering = true;

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

  void registerListeners() {
    ActionListener numberListener = e -> numberPressed(e);
    number0.addActionListener(numberListener);
    number1.addActionListener(numberListener);
    number2.addActionListener(numberListener);
    number3.addActionListener(numberListener);
    number4.addActionListener(numberListener);
    number5.addActionListener(numberListener);
    number6.addActionListener(numberListener);
    number7.addActionListener(numberListener);
    number8.addActionListener(numberListener);
    number9.addActionListener(numberListener);
    decimalPoint.addActionListener(numberListener);

    ActionListener operatorListener = e -> operatorPressed(e);
    buttonDivide.addActionListener(operatorListener);
    buttonEquals.addActionListener(operatorListener);
    buttonMinus.addActionListener(operatorListener);
    buttonMultiply.addActionListener(operatorListener);
    buttonPlus.addActionListener(operatorListener);
  }

  void operatorPressed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    String op = button.getText();

    switch(op) {
      case "+":
      case "-":
      case "*":
      case "/":
        if(operator.isBlank()) {
          register = display.getText();
          operator = op;
          display.setText("0");
        } else {
          double result = calculate();
          register = Double.toString(result);
          operator = op;
          display.setText("0");
        }
        break;
      case "=":
        double result = calculate();
        display.setText(Double.toString(result));
        operator = "";
        entering = false;
        break;
      default:
    }
  }

  private double calculate() {
    double r = Double.parseDouble(register);
    double d = Double.parseDouble(display.getText());
    double result = 0;
    switch (operator) {
      case "+":
        result = r + d;
        break;
      case "-":
        result = r - d;
        break;
      case "*":
        result = r * d;
        break;
      case "/":
        result = r / d;
        break;
      default:
        break;
    }
    return result;
  }

  void numberPressed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    String digit = button.getText();

    String displayValue = display.getText();

    if(!entering) {
      displayValue = "0";
      entering = true;
    }

    if(digit.equals(".")) {
      if(!displayValue.contains("."))
        display.setText(displayValue + digit);
    } else {
      if(displayValue.equals("0"))
        display.setText(digit);
      else
        display.setText(displayValue + digit);
    }
  }

  void setupLayout() {
    contentPane.setLayout(new BorderLayout());
    contentPane.add(display, BorderLayout.NORTH);
    buttonsPanel.setLayout(new GridLayout(4, 4, 0, 0));
    contentPane.add(buttonsPanel, BorderLayout.CENTER);
    buttonsPanel.add(number7);
    buttonsPanel.add(number8);
    buttonsPanel.add(number9);
    buttonsPanel.add(buttonDivide);
    buttonsPanel.add(number4);
    buttonsPanel.add(number5);
    buttonsPanel.add(number6);
    buttonsPanel.add(buttonMultiply);
    buttonsPanel.add(number1);
    buttonsPanel.add(number2);
    buttonsPanel.add(number3);
    buttonsPanel.add(buttonMinus);
    buttonsPanel.add(number0);
    buttonsPanel.add(decimalPoint);
    buttonsPanel.add(buttonEquals);
    buttonsPanel.add(buttonPlus);
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
