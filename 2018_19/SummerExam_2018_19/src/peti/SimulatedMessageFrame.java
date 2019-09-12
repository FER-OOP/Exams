package peti;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class SimulatedMessageFrame extends JFrame {
	private SwingWorker<Long, String> worker;
	private int numMessages = 10; 
	private JLabel label = new JLabel("Message transfer:", JLabel.CENTER);
	private JProgressBar progressBar = new JProgressBar();
	private JButton startButton = new JButton("Start");
	private JTextArea textArea = new JTextArea();

	public SimulatedMessageFrame() {
		// progress bar (0, numMessages), inkrement vrijednostiza svaku poruku
		progressBar.setIndeterminate(false);
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(numMessages);
		// TO DO Dodaj odgovarajuće panele, layout, ...
		this.setLayout(new BorderLayout());     // nepotrebno default
		JPanel topArea = new JPanel();  
		topArea.setLayout(new FlowLayout());    // default
		topArea.add(label);
		topArea.add(progressBar);
		add(topArea, BorderLayout.NORTH);
		JPanel buttonsArea = new JPanel();
		buttonsArea.setLayout(new FlowLayout()); // default 
		buttonsArea.add(startButton);
		add(buttonsArea, BorderLayout.SOUTH);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll, BorderLayout.CENTER); //add(scroll); // OK
		 
		startButton.addActionListener((ActionEvent e) -> {
			// TO DO on Start
			startButton.setEnabled(false);
			progressBar.setValue(0);
			textArea.setText("");
			worker = new MessageWorker(numMessages);
			worker.execute();
		}); 
	}
	
	// TO DO MessageWorker dopunite 
	private class MessageWorker extends SwingWorker<Long, String> {
		 private int numMessages;	 
		 public MessageWorker(int numMessages) {
			 this.numMessages = numMessages;
		 }
		 // TO DO dopisati potrebne metode MessageWorkera 
		 @Override protected Long doInBackground() throws Exception {
			 long totalTime = 0L;
			 for (int i = 0; i < numMessages; i++) {
			   long elapsedTime = System.currentTimeMillis();
			   sendMessage();
			   elapsedTime = System.currentTimeMillis() - elapsedTime;
			   String status = "Sending " + (i+1) + ". message, " + elapsedTime 
				+ " msec";
			   publish(status);
			   totalTime += elapsedTime;
			 }
			 return totalTime;
		 }
		 @Override protected void process(List<String> chunks) {
		 	 for (String chunk : chunks) {
				 textArea.append(chunk + "\n");
				 progressBar.setValue(progressBar.getValue() + 1);
			 }
		 }
		 @Override protected void done()  { 
			try {
				textArea.append("All messages were transferred in " + get() 
						+ " ms.\n");
			} catch (Exception e) { e.printStackTrace(); } 
			progressBar.setValue(0);
			startButton.setEnabled(true);
		 }
		 
	}
	/**
	 *  Simulate a long run time needed for encription and sending message
	 */
	void sendMessage() throws InterruptedException {	
		 Random rnd = new Random(System.currentTimeMillis());
		 long millis = rnd.nextInt(1000);
		 Thread.sleep(millis);
	} 

}

