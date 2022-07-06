package hr.fer.oop.zi.z4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Dialer extends JFrame {

  private JPanel contentPane;
  private JTextField display;
  private JButton button1;
  private JButton button2;
  private JButton button3;
  private JButton button4;
  private JButton button5;
  private JButton button6;
  private JButton button7;
  private JButton button8;
  private JButton button9;
  private JButton button0;
  private JButton buttonCall;
  private JPanel buttonsPanel;
  private JButton buttonDelete;

  private String rawNumber = "";

  public Dialer() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    display = new JTextField();
    display.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
    display.setHorizontalAlignment(JTextField.CENTER);
    display.setColumns(10);

    buttonsPanel = new JPanel();
    button1 = new JButton("1");
    button2 = new JButton("2");
    button3 = new JButton("3");
    button4 = new JButton("4");
    button5 = new JButton("5");
    button6 = new JButton("6");
    button7 = new JButton("7");
    button8 = new JButton("8");
    button9 = new JButton("9");
    button0 = new JButton("0");
    buttonCall = new JButton("Call");
    buttonDelete = new JButton("DEL");

    setupLayout();
    registerListeners();
  }

  void setupLayout() {
    buttonCall.setEnabled(false);
    buttonCall.setBackground(Color.LIGHT_GRAY);

    contentPane.add(display, BorderLayout.NORTH);
    contentPane.add(buttonsPanel, BorderLayout.CENTER);
    buttonsPanel.setLayout(new GridLayout(0, 3, 0, 0));
    buttonsPanel.add(button1);
    buttonsPanel.add(button2);
    buttonsPanel.add(button3);
    buttonsPanel.add(button4);
    buttonsPanel.add(button5);
    buttonsPanel.add(button6);
    buttonsPanel.add(button7);
    buttonsPanel.add(button8);
    buttonsPanel.add(button9);
    buttonsPanel.add(new JPanel());
    buttonsPanel.add(button0);
    buttonsPanel.add(new JPanel());
    buttonsPanel.add(new JPanel());
    buttonsPanel.add(buttonCall);
    buttonsPanel.add(buttonDelete);
  }

  void registerListeners() {
    button0.addActionListener(this::numberPressed);
    button1.addActionListener(this::numberPressed);
    button2.addActionListener(this::numberPressed);
    button3.addActionListener(this::numberPressed);
    button4.addActionListener(this::numberPressed);
    button5.addActionListener(this::numberPressed);
    button6.addActionListener(this::numberPressed);
    button7.addActionListener(this::numberPressed);
    button8.addActionListener(this::numberPressed);
    button9.addActionListener(this::numberPressed);
    buttonCall.addActionListener(this::callPressed);
    buttonDelete.addActionListener(this::deletePressed);
  }

  void numberPressed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    String digit = button.getText();
    rawNumber += digit;
    buttonCall.setEnabled(true);
    updateDisplay();
  }

  void callPressed(ActionEvent e) {
    if(buttonCall.getText().equals("Call")) {
      display.setText("Calling...");
      buttonCall.setText("Abort");
    } else {
      rawNumber = "";
      updateDisplay();
      buttonCall.setText("Call");
      buttonCall.setEnabled(false);
    }
  }

  void deletePressed(ActionEvent e) {
    if(rawNumber.length() > 0) {
      rawNumber = rawNumber.substring(0, rawNumber.length()-1);
      updateDisplay();
    }

    if(rawNumber.isEmpty())
      buttonCall.setEnabled(false);
  }

  private void updateDisplay() {
    StringBuilder sb = new StringBuilder();

    int startEnd = rawNumber.length() % 3;
    for (int end = startEnd; end <= rawNumber.length(); end+=3) {
      int start = end - 3;
      if(start < 0)
        start = 0;

      if(start != 0)
        sb.append(" ");

      sb.append(rawNumber.substring(start, end));
    }

    display.setText(sb.toString());
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        Dialer frame = new Dialer();
        frame.setVisible(true);
        frame.pack();
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }


}

