package hr.fer.oop.task5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public final class LetterCounterFrame extends JFrame {

    private JTextArea textArea;
    private JLabel[] labels = new JLabel[26];

    public LetterCounterFrame() {

        textArea = new JTextArea(5, 60);
        textArea.setLineWrap(true);
        add(textArea, BorderLayout.CENTER);

        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        northPanel.setLayout(new GridLayout(2, 13));
        for (int i = 0; i < 26; i++) {
            labels[i] = new JLabel(((char) ('a' + i)) + ": 0");
            northPanel.add(labels[i]);
        }

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);

        JButton button = new JButton("Count");

        button.addActionListener((ActionEvent e) -> {
            //calculate statistics
            int[] counts = new int[26];

            String text = textArea.getText().toLowerCase();
            for (char c : text.toCharArray()) {

                if (c >= 'a' && c <= 'z') {
                    counts[c - 'a']++;
                }
            }

            for (int i = 0; i < 26; i++) {
                labels[i].setText(((char) ('a' + i)) + ": " + Integer.toString(counts[i]));
            }
        });

        southPanel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new LetterCounterFrame();
            frame.setTitle("Count Letters in a Text");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocation(100, 100);
            frame.setVisible(true);
            frame.pack(); // or frame.setSize(500, 200);
        });
    }

}

