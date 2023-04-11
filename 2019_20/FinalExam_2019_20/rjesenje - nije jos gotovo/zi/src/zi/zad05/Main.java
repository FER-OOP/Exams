package zi.zad05;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import zi.ScientificPaper;

public class Main extends JFrame {

	private JLabel result;
	private JTextField first;
	private JTextField second;

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

	private void calculateResult(IntBinaryOperator operation) {
		OptionalInt a = convertToInt(first.getText());
		if(a.isEmpty()) return;
		OptionalInt b = convertToInt(second.getText());
		if(b.isEmpty()) return;
		
		int res = operation.applyAsInt(a.getAsInt(), b.getAsInt());
		
		result.setText("Rezultat je: " + res);
	}

	private void initGUI() {
		// Napišite na zasebnom papiru
		Container cp = getContentPane();

		result = new JLabel("Rezultat je: ");
		first = new JTextField();
		second = new JTextField();

		cp.setLayout(new BorderLayout());
		
		cp.add(result, BorderLayout.PAGE_START);
		
		JPanel pleft = new JPanel(new GridLayout(2,1));
		JPanel pright = new JPanel(new GridLayout(2,1));
		JPanel pcenter = new JPanel(new BorderLayout());
		pcenter.add(pleft, BorderLayout.LINE_START);
		pcenter.add(pright, BorderLayout.CENTER);
		cp.add(pcenter, BorderLayout.CENTER);
		
		pleft.add(new JLabel("Prvi broj:"));
		pleft.add(new JLabel("Drugi broj:"));
		
		pright.add(first);
		pright.add(second);

		JPanel gumbi = new JPanel(new GridLayout(1,2));
		JPanel bottom = new JPanel();
		bottom.add(gumbi);
		
		JButton bSum = new JButton("Izračunaj sumu");
		JButton bDif = new JButton("Oduzmi");
		
		gumbi.add(bSum);
		gumbi.add(bDif);
		
		cp.add(bottom, BorderLayout.PAGE_END);
		
		bSum.addActionListener(e->{
			calculateResult((a,b)->a+b);
		});
		bDif.addActionListener(e->{
			calculateResult((a,b)->a-b);
		});
	}
	
	private OptionalInt convertToInt(String text) {
		try {
			int res = Integer.parseInt(text);
			return OptionalInt.of(res);
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, text + " nije broj", "Greška", JOptionPane.ERROR_MESSAGE);
		}
		return OptionalInt.empty();
	}

}
