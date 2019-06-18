package hr.fer.oop.task3_5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class RecipesFinderWindow extends JFrame {
		
	public RecipesFinderWindow() {
		JTextField tfIngredient = new JTextField();
		JButton btnStart = new JButton("Start");
		JLabel lblIngredient = new JLabel("Enter ingredient:");
		JLabel lblResults = new JLabel("Results");
		JTextArea resultsArea = new JTextArea();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setOrientation(SwingConstants.VERTICAL);		
		JButton btnCopy = new JButton("Copyright");
		JButton btnAbout = new JButton("About");
		String avgRatingFormat = "Average recipe rating: %s";
		JLabel lblAvgRating = new JLabel(String.format(avgRatingFormat, ""));
		//TO DO: Add appropriate panels, layouts, ...
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout(20, 20));
		northPanel.add(lblIngredient, BorderLayout.WEST);		
		northPanel.add(btnStart, BorderLayout.EAST);
		northPanel.add(tfIngredient, BorderLayout.CENTER);
		
		JPanel middlePanel = new JPanel(new BorderLayout());	
		middlePanel.add(lblResults, BorderLayout.NORTH);
		middlePanel.add(resultsArea, BorderLayout.CENTER);
		middlePanel.add(lblAvgRating, BorderLayout.SOUTH);
		
		add(middlePanel, BorderLayout.CENTER);
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 0));		
		buttonsPanel.add(btnAbout);
		buttonsPanel.add(btnCopy);
		
		add(buttonsPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);				
		add(progressBar, BorderLayout.EAST);
		
		//end of layout
									
		ActionListener listener = e -> {
			//TO DO: define listener code that starts worker			
			String ingredient = tfIngredient.getText();
			if (ingredient.length() > 0) {
				btnStart.setEnabled(false);				
				Consumer<Integer> onDone = i -> {
					lblAvgRating.setText(String.format(avgRatingFormat, i));
					btnStart.setEnabled(true);
				};
				
				Function<Triple<String, String, Integer>, String> formatter = 
						(triple) -> String.format("%s: %s, rating: %d%n", 
								triple.getFirst(), triple.getSecond(), triple.getThird());
				
				Consumer<String> consumer = s -> resultsArea.append(s);
				RecipeWorker worker = new RecipeWorker(ingredient,consumer, onDone, formatter);
				
				worker.addPropertyChangeListener(pc -> {
					if (pc.getPropertyName().equals("progress")) {
						progressBar.setValue((int) pc.getNewValue()); 
					}
				});
				
				worker.execute();
			}			
		};
		btnStart.addActionListener(listener);		
		//
		setSize(600, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Recipes finder");
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> 
		{
			JFrame window = new RecipesFinderWindow();
			window.setLocation(100, 100);
			window.setVisible(true);
		});
	}
}
