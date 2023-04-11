package zi.zad03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

import zi.ScientificPaper;

public class Main extends JFrame {

	private JButton start;
	private JTextArea log;
	private JProgressBar progressbar;
	private List<ScientificPaper> papers = DemoPapers.create();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new Main().setVisible(true);
		});
	}

	public Main() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(300, 150);
		initGUI();
	}

	private void initGUI() {
		Container cp = getContentPane();
		
		start = new JButton("Start conversion");
		progressbar = new JProgressBar();
		log = new JTextArea();
		
		cp.add(start, BorderLayout.PAGE_START);
		cp.add(new JScrollPane(log), BorderLayout.CENTER);
		cp.add(progressbar, BorderLayout.PAGE_END);

		
		start.addActionListener(l->{
			startClicked();
		});
	}

	private void startClicked() {
		start.setEnabled(false);
		
		Worker w = new Worker();
		w.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getPropertyName().equals("progress")) {
					progressbar.setValue((Integer)evt.getNewValue());
				}
			}
		});
		w.execute();
	}

	class Worker extends SwingWorker<List<Path>, String> {
		
		@Override
		protected List<Path> doInBackground() throws Exception {
			List<Path> paths = new ArrayList<Path>();
			setProgress(0);
			int i = 0;
			for(ScientificPaper p : papers) {
				publish("Converting: "+p.getPath());
				Path p2 = DemoPapers.convert(p);
				i++;
				if(p2 != null) paths.add(p2);
				setProgress(i*100/papers.size());
			}
			return paths;
		}
		
		@Override
		protected void process(List<String> chunks) {
			for(String s : chunks) {
				log.append(s+"\n");
			}
		}
		
		@Override
		protected void done() {
			List<Path> list = null;
			try {
				list = get();
			} catch (InterruptedException | ExecutionException e) {
			}
			log.append("Produced "+list.size()+" pdf(s)");
			start.setEnabled(true);
		}
	}
}
