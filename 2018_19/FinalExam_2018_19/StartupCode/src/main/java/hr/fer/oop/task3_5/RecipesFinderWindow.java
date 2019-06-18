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
				
		
		//end of layout
									
		ActionListener listener = e -> {				
			String ingredient = tfIngredient.getText();
			if (ingredient.length() > 0) {
				btnStart.setEnabled(false);				
				Consumer<Integer> onDone = i -> {
					lblAvgRating.setText(String.format(avgRatingFormat, i));
					btnStart.setEnabled(true);
				};
				
				//TO DO: define formatter
				
				
				//TO DO: define consumer (uses resultsArea.append(some text))
				
				
				//
				RecipeWorker worker = new RecipeWorker(ingredient, consumer, onDone, formatter);
				
				//TO DO: define display of progress
				
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
