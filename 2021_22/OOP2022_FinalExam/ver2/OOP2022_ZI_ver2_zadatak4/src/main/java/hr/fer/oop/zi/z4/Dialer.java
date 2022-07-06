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
    // TODO fill in method
  }

  void registerListeners() {
    // TODO fill in method
  }

  void numberPressed(ActionEvent e) {
    // TODO fill in method
  }

  void callPressed(ActionEvent e) {
    // TODO fill in method
  }

  void deletePressed(ActionEvent e) {
    // TODO fill in method
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

