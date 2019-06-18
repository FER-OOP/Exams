package hr.fer.oop.fall_2017_18.task4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class MainFrame extends JFrame {	
	CounterWorker worker;
	
	public MainFrame(){		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout());
		JButton start = new JButton("Start");
		north.add(start);
		JButton stop = new JButton("Stop");
		stop.setEnabled(false);
		north.add(stop);
		
		add(north, BorderLayout.NORTH);
		
		JTextField text = new JTextField("");
		text.setEditable(false);
		text.setHorizontalAlignment(JTextField.CENTER);		
		text.setFont(new Font("Courier", Font.BOLD, 30));
		
		add(text, BorderLayout.CENTER);
		
		JTextField txtCount = new JTextField("");
		txtCount.setEditable(false);
		add(txtCount, BorderLayout.SOUTH);
		

		start.addActionListener(e -> {
			start.setEnabled(false);			
			txtCount.setText("0");
			worker = new CounterWorker((s) -> text.setText(s));
			worker.execute();
			stop.setEnabled(true);
		});
		
		stop.addActionListener(e -> {
			start.setEnabled(false);
			text.setText("");
			worker.stop();
			Integer total = null;
			try {
				total = worker.get();
				txtCount.setText("Total: " + total);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			start.setEnabled(true);
		});
		
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {            	
            	MainFrame frame = new MainFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Car recognizer");
                frame.setBounds(200, 200, 300, 300);
                frame.setVisible(true);
            }
        });

	}

}
