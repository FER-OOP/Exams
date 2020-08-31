package hr.fer.oop.task5;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Task5 extends JFrame {

	private List<String> fields;
	private JPanel grid;
	private JLabel message;
	private JPanel bottom;
	private String player;

	public Task5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Tic Tac Toe");
		fields = Arrays.asList(" "," "," "," "," "," "," "," "," ");

		player = " ";

		message = new JLabel("Game not started");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		add(message, BorderLayout.NORTH);

		grid = new JPanel();
		// set layout, add buttons, add listeners, set action command +3

		for(Integer i = 0; i < 9; i++) {
			JButton btn = new JButton(player);
			btn.setActionCommand(i.toString()); // +1
			btn.setEnabled(false);
			btn.addActionListener(e -> fieldBtnListener(e));
			grid.add(btn); // +1
		}
		grid.setLayout(new GridLayout(3,3));
		add(grid, BorderLayout.CENTER); // +1

		bottom = new JPanel();
		// postavljanje donje tipke +2
		JButton start_btn = new JButton("Start");
		start_btn.addActionListener(e -> startBtnListener(e));
		bottom.add(start_btn);
		add(bottom, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Task5 frame = new Task5();
			frame.pack();
			frame.setVisible(true);
		});
	}

	private void fieldBtnListener(ActionEvent e) {
		Integer i = Integer.valueOf(e.getActionCommand()); // +1
		JButton btn = (JButton) e.getSource();
		btn.setText(player);
		btn.setEnabled(false); // +1
		fields.set(i, player); // +1
		// koja tipka stisnuta, postavljanje vrijednosti i iskljucivanje tipke +3
		boolean win = checkWinner();
		if(win) {
			gameEnd("Player " + player + " won!");
		}else if(fields.stream().filter(str -> str != " ").count() == 9){
			gameEnd("Draw!");
		}else {
			switchPlayer();
		}
	}

	private void startBtnListener(ActionEvent e) {
		JButton start = (JButton) e.getSource();
		start.setEnabled(false); // +1
		for(Component c : grid.getComponents()) {
			if(c instanceof JButton) {
				JButton btn = (JButton) c;
				btn.setEnabled(true);
			}
		} // +1
		// iskljucivanje start tipke, ukljucivanje grid tipki +2
		switchPlayer();
	}

	// ----------------------------
	// --- ADDITIONAL FUNCTIONS ---
	// ----------------------------

	private void gameEnd(String msg) {
		JOptionPane.showMessageDialog(this, msg);
		fields = Arrays.asList(" "," "," "," "," "," "," "," "," ");
		player = " ";
		JButton btn = (JButton) bottom.getComponent(0);
		btn.setEnabled(true);
		for(Component c : grid.getComponents()) {
			if(c instanceof JButton) {
				btn = (JButton) c;
				btn.setText(player);
				btn.setEnabled(false);
			}
		}
		message.setText("Game not started");
	}

	private void switchPlayer() {
		if(player=="X") {
			player = "O";
		}else {
			player = "X";
		}
		message.setText("Player " + player + "'s turn");
	}

	private boolean checkWinner() {
		int index_col;
		int index_row;
		int index_diag;
		int rows;
		int cols;
		int diag;

		for(int i = 0; i < 3; i++) {
			rows = 0;
			cols = 0;
			diag = 0;
			for(int j = 0; j < 3; j++) {
				index_col = i + j*3;
				index_row = i*3 + j;
				switch(i) {
					case 0:
						index_diag = j*4;
						break;
					case 1:
						index_diag = 2*(j+1);
						break;
					default:
						index_diag = -1;
						break;
				}
				rows += fields.get(index_row) == player ? 1 : 0;
				cols += fields.get(index_col) == player ? 1 : 0;
				if(index_diag >= 0) {
					diag += fields.get(index_diag) == player ? 1 : 0;
				}
			}
			if(rows == 3 || cols == 3 || diag == 3) {
				return true;
			}
		}
		return false;
	}
}
