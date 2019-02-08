package hr.fer.oop.finalexam_2018_19.task4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class RollingDie extends JFrame implements ActionListener { // (1)
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				RollingDie simulator = new RollingDie();
				simulator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				simulator.pack();
				simulator.setVisible(true);
			}
		});
	}

	private JLabel textLbl = new JLabel("Broj bacanja kocke:");
	private JTextField numberOfRollsTf = new JTextField(10);
	private JLabel[] dieValues = new JLabel[6];
	private JLabel[] occurrences = new JLabel[6];
	private JButton startBtn = new JButton("Start");
	private JPanel inputPnl = new JPanel();
	private JPanel centralPnl = new JPanel();
	private JPanel buttonPnl = new JPanel();

	RollingDie() {
		// set GUI (2)
		inputPnl.add(textLbl);
		inputPnl.add(numberOfRollsTf);
		centralPnl.setLayout(new GridLayout(6, 0));
		for (int i = 0; i < 6; i++) {
			centralPnl.add(dieValues[i] = new JLabel("[" + (i + 1) + "]"));
			centralPnl.add(occurrences[i] = new JLabel());
		}
		buttonPnl.add(startBtn);
		this.add(inputPnl, BorderLayout.NORTH); // BorderLayout.PAGE_START
		this.add(buttonPnl, BorderLayout.SOUTH);
		this.add(centralPnl, BorderLayout.CENTER);
		startBtn.addActionListener(this); // priznati i rješenje s anonimnom klasom new ActionListener() { ...
	}

	// (3)
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int numberOfRolls = Integer.parseInt(numberOfRollsTf.getText());
			// reset GUI components
			for (int i = 0; i < 6; i++)
				occurrences[i].setText("");
			startBtn.setEnabled(false);
			// execute the task on a working thread
			new SimulationTask(numberOfRolls).execute();
		} catch (NumberFormatException ex) {
			// do nothing
		}
	}

	private class SimulationTask extends SwingWorker<Double, Map<Integer, Integer>> { // (1)
		int numberOfRolls;
		Map<Integer, Integer> map = new HashMap<>();

		SimulationTask(int numberOfRolls) {
			this.numberOfRolls = numberOfRolls;
			for (int i = 0; i < 6; i++)
				map.put(i, Integer.valueOf(0));
		}

		// (4)
		@Override
		protected Double doInBackground() {
			Random random = new Random();
			for (int i = 0; i < numberOfRolls; i++) {
				Integer key = random.nextInt(6);
				map.put(key, map.get(key) + 1);
				// map.compute(random.nextInt(6), (k, v) -> v==null ? 1 : v+1 ); // ili rjesenje
				// preko compute
				publish(map);
			}
			return numberOfRolls / 6.;
		}

		@Override
		protected void process(List<Map<Integer, Integer>> distributions) {
			Map<Integer, Integer> d = distributions.get(distributions.size() - 1);
			for (Map.Entry<Integer, Integer> pair : d.entrySet()) {
				occurrences[pair.getKey()].setText(String.format("%d", pair.getValue()));
			}
		}

		@Override
		protected void done() {
			startBtn.setEnabled(true);
		}

	}
}
