package hr.fer.oop.final_2017_18.task4;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class TextStatFrame extends JFrame {
	private JTextArea textArea = new JTextArea();
    private JButton statsBtn = new JButton("Statistics");
    private JButton freqBtn = new JButton("Show frequencies");
    private JTextArea resultArea = new JTextArea();
        
	public TextStatFrame(String title) {
		super(title);
		setLayout(new BorderLayout()); //po def
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);
		resultArea.setEditable(false);
		
		JScrollPane scroller1 = new JScrollPane(textArea);
        JScrollPane scroller2 = new JScrollPane(resultArea);
       
		JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPanel.setResizeWeight(0.5); 
        splitPanel.setLeftComponent(scroller1);
        splitPanel.setRightComponent(scroller2);
        splitPanel.setPreferredSize(new Dimension(400, 200));
		add(splitPanel,  BorderLayout.CENTER);
        
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());  //po def
		btnPanel.add(statsBtn);
		btnPanel.add(freqBtn);
		
		add(btnPanel, BorderLayout.SOUTH);
		
		statsBtn.addActionListener( new ActionListener() {    // noname impl
			public void actionPerformed(ActionEvent event) {	
        		resultArea.setText("");
        		String [] words = getWords(textArea.getText());
                resultArea.setText(String.format("No of words: %d\n", words.length)); 
                for(String word: getFilteredWords(words, 6))
                	resultArea.append("\n" + word);
			}    
        });
		
		freqBtn.addActionListener(actionEvent -> { 	 // lambda impl
				resultArea.setText("");
				String [] words = getWords(textArea.getText());
				Runnable heavyTask = () -> {
					Map<String, Integer>freq = getFrequencies(words);
					for (String key: freq.keySet()){
			            String value = freq.get(key).toString();  
			            SwingUtilities.invokeLater(()-> resultArea.append(key + " " + value +"\n"));  
					}
					
				};
				new Thread(heavyTask).start(); 
        });
	}
	
	private String [] getWords(String text){
		return text.split("[^a-zA-Z]+");  
	}
	
	private List<String> getFilteredWords(String [] words, int noOfCharacters) {
		//sorted is stable sort!
		return  Stream.of(words)
		        .filter(s -> s.length() >= noOfCharacters)	
		        .sorted((s1, s2)->(Integer.compare(s1.length(), s2.length())))
		        .collect(Collectors.toList());	
	}
	
	Map<String, Integer> getFrequencies(String[] words){
		Map<String, Integer> frequencies = new TreeMap<>(); 
	    for (String w : words) {
	    	w = w.toLowerCase();
	        Integer n = frequencies.get(w);
	        n = (n == null) ? 1 : ++n;
	        frequencies.put(w, n);
	    }
	    return frequencies;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
        	JFrame frame = new TextStatFrame("Text Stat");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
	}

}

/*
Yesterday
all my troubles seemed so far away
Now it looks as though
they're here to stay
Oh I believe in yesterday
Suddenly
I'm not half the man I used to be
there's a shadow hanging over me
Oh yesterday came suddenly
Why she had to go I don't know
she wouldn't say
I said something wrong
Now I long for yesterday
Yesterday
Love was such an easy game to play
Now I need a place to hide away
Oh I believe in yesterday
Why she had to go I don't know
she wouldn't say
I said something wrong
Now I long for yesterday
Yesterday
Love was such an easy game to play
Now I need a place to hide away
*/
/*
Oh, I believe in yesterday 
*/

