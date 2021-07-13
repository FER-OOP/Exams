/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.summer_2020_21.task4;

import hr.fer.oop.summer_2020_21.task5.DiffWorker;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author kpripuzic
 */
public final class DiffFrame extends JFrame {

    private JTextArea textAreaLeft, textAreaRight;
    private JTextPane textPane;
    private JLabel deletedLabel, addedLabel; //counter labels

    public DiffFrame() {

        //create, set up and add a text pane
        textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);
        textPane.setPreferredSize(new Dimension(0, 200));
        textPane.setBorder(BorderFactory.createTitledBorder("differences"));
        add(textPane);

        //create and set up left and right text areas
        textAreaLeft = new JTextArea(10, 40);
        textAreaRight = new JTextArea(10, 40);
        textAreaLeft.setLineWrap(true);
        textAreaRight.setLineWrap(true);
        textAreaLeft.setBorder(BorderFactory.createTitledBorder("left text"));
        textAreaRight.setBorder(BorderFactory.createTitledBorder("right text"));

        //TODO - add the left and right text area
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        northPanel.setLayout(new GridLayout(1, 2));
        northPanel.add(textAreaLeft);
        northPanel.add(textAreaRight);

        //TODO - add statistic counters
        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new BorderLayout());

        JPanel countersPanel = new JPanel();
        southPanel.add(countersPanel, BorderLayout.WEST);
        countersPanel.setLayout(new GridLayout(2, 1));
        deletedLabel = new JLabel("Deleted substring: ");
        addedLabel = new JLabel("Added substrings: ");
        countersPanel.add(deletedLabel);
        countersPanel.add(addedLabel);

        //TODO – add the button
        JPanel buttonPanel = new JPanel();
        southPanel.add(buttonPanel, BorderLayout.EAST);
        JButton button = new JButton("Compare");
        buttonPanel.add(button);

        //TODO - define action on button click
        button.addActionListener((ActionEvent e) -> {
            DiffWorker worker = new DiffWorker(textAreaLeft.getText(),
                    textAreaRight.getText(), deletedLabel, addedLabel, textPane);
            worker.execute();
        });
    } //end of DiffFrame constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //TODO – create and show the frame
            JFrame frame = new DiffFrame();
            frame.setTitle("Compare two texts");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocation(100, 100);
            frame.setVisible(true);
            frame.pack(); // or frame.setSize(500, 200);
        });
    } //end of main
} //end of DiffFrame

