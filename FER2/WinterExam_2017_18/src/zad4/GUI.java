package zad4;
import java.awt.BorderLayout;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class GUI extends JFrame {
  private JTextArea statusArea = new JTextArea(5, 30);
  private JProgressBar progbar = new JProgressBar();
  private JButton download = new JButton("Download");
  public GUI() {
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    initGUI();
    pack();
  }
  
  private void initGUI() {
    // Vaš kod...
	List<EPubBook> books = Books.readFromDefaultLocation();
	ListModel<String> model = new ModelSKnjigama(books);
	JList<String> lista = new JList<>(model);
	progbar.setStringPainted(true);
	
	JPanel panel = new JPanel(new BorderLayout());
	panel.add(progbar, BorderLayout.PAGE_START);
	panel.add(new JScrollPane(statusArea), BorderLayout.CENTER);
	panel.add(download, BorderLayout.PAGE_END);
	
	JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(lista), panel);

	getContentPane().add(jsp, BorderLayout.CENTER);
	
	progbar.setMaximum(100);
	
	download.addActionListener(e->{
		download.setEnabled(false);
		DownloadWorker worker = new DownloadWorker(books);
		progbar.setValue(0);
		worker.addPropertyChangeListener(ev->{
			if(ev.getPropertyName().equals("progress")) {
				progbar.setValue((Integer)ev.getNewValue());
			}
		});
		worker.execute();
	});
  }

  private class DownloadWorker extends SwingWorker<Integer, String> {
	List<EPubBook> books;

	public DownloadWorker(List<EPubBook> books) {
		super();
		this.books = books;
	}
	  
	@Override
	protected Integer doInBackground() throws Exception {
		int uspjelo = 0;
		setProgress(0);
		int i = 0;
		for(EPubBook book : books) {
			i++;
			if(Downloader.download(book.url)) {
				publish("[SUCCESS]" +book.authors+": "+book.name);
				uspjelo++;
			} else {
				publish("[ERROR]" +book.authors+": "+book.name);
			}
			setProgress(i*100/books.size());
		}
		return uspjelo;
	}

	@Override
	protected void process(List<String> chunks) {
		for(String s : chunks) {
			statusArea.append(s+"\n");
		}
	}
	
	@Override
	protected void done() {
		try {
			int uspjelo = get();
			statusArea.append("Successfully downloaded "+uspjelo+" books.\n");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		download.setEnabled(true);
	}
  }
  
  private static class ModelSKnjigama extends AbstractListModel<String> {
    List<EPubBook> books;
    public ModelSKnjigama(List<EPubBook> books) {
    	this.books = books;
    }
    @Override
    public int getSize() {
    	return books.size();
    }
    @Override
    public String getElementAt(int index) {
    	return books.get(index).authors + ": " + books.get(index).name;
    }
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(()->{new GUI().setVisible(true);});
  }
}
