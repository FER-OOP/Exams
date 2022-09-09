package hr.fer.oop.t1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemoFrame extends JFrame {
	private JPanel centerPane;
	private JLabel generatingLabel;
	private JLabel clickedNumberLabel;
	private ActionListener numberBtnClick = (e) -> {
		String s = ((JButton) e.getSource()).getText();
		clickedNumberLabel.setText("Click on number " + s);
	};
	
	public DemoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(10, 10, 500, 200); // location and size
	    
	    generatingLabel = new JLabel("Press a button on the left to generate buttons in the middle", JLabel.CENTER);
	    clickedNumberLabel = new JLabel("This label should display number of the clicked button from the middle", JLabel.CENTER);
	    add(generatingLabel, BorderLayout.NORTH);
	    add(clickedNumberLabel, BorderLayout.SOUTH);
	    
	    JPanel west = new JPanel();
	    JPanel gridInsideWest = new JPanel();	
	    west.add(gridInsideWest);
	    
	    gridInsideWest.setLayout(new GridLayout(0, 1));
	    
	    ActionListener generateListener = (e) -> {
	    	String s = e.getActionCommand();
	    	int noOfButtons;
	    	if (s != "") {
	    		noOfButtons = Integer.parseInt(s);
	    	}
	    	else {
	    		noOfButtons = (int) (Math.random() * 101);
	    	}
	    	generatingLabel.setText("Generating " + noOfButtons + " buttons");
	    	centerPane.removeAll();	    	
	    	
	    	for(int i=0; i<noOfButtons; i++) {
	    		JButton btnNumber = new JButton("" + i);
	    		btnNumber.addActionListener(numberBtnClick);
	    		centerPane.add(btnNumber);
	    	}
	    	centerPane.revalidate();
	    	centerPane.repaint();
	    };
	    
	    JButton btn = new JButton("5");	   
	    btn.addActionListener(generateListener);
	    btn.setActionCommand("5");
	    gridInsideWest.add(btn);
	    
	    btn = new JButton("10");
	    btn.setActionCommand("10");
	    btn.addActionListener(generateListener);
	    gridInsideWest.add(btn);
	    
	    btn = new JButton("100");
	    btn.setActionCommand("100");
	    btn.addActionListener(generateListener);
	    gridInsideWest.add(btn);
	    
	    btn = new JButton("Random up to 100");
	    btn.setActionCommand("");
	    btn.addActionListener(generateListener);
	    gridInsideWest.add(btn);
	    
	    add(west, BorderLayout.WEST);
	    
	    centerPane = new JPanel();
	    add(centerPane, BorderLayout.CENTER);
	    
	   
	    
	}
}
