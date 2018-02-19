package zad3;
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
