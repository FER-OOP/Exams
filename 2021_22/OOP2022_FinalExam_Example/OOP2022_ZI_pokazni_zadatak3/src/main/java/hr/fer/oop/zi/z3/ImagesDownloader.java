package hr.fer.oop.zi.z3;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ImagesDownloader extends JFrame implements ListSelectionListener {
  private final List<String> countries = Arrays.asList("Austria", "Belgium", "Denmark", "Croatia", "Finland",
      "France", "Germany", "Finland", "Italy", "Iceland",
      "Israel", "Iran", "Japan", "Lebanon", "Malaysia", "Mongolia",
      "South Korea", "Thailand", "Turkey", "Vietnam");

  private Map<String, ImageIcon> images = new HashMap<>(); // Mapa u koju spremamo drzave i slike zastava

  private DefaultListModel<String> model = new DefaultListModel<>(); // Model za listu drzava
  private JList<String> imagesList = new JList<>(model); // Lista drzava
  private JLabel lbImage; // Labela za prikaz zastave

  private JButton btnDownload = new JButton("Download"); // Gumb Download
  private JProgressBar progressBar = new JProgressBar(0, 100); // Progress bar u dnu prozora
  private JTextField txStatus = new JTextField(" "); // Statusna traka aplikacije
  private final JLabel lblUser = new JLabel("User name:");
  private final JTextField userField = new JTextField();
  private final JLabel lblPassword = new JLabel("Password:");
  private final JPasswordField passwordField = new JPasswordField();
  private final JButton btnLogin = new JButton("Login"); // Gumb login
  
  private long slowDownImageLoading = 100;

  private boolean checkUser() {
    return true; // Metoda koja provjerava jesu li korisnicko ime i lozinka ispravno uneseni
  }

  public ImagesDownloader() {
    super("Flags");
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    imagesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    imagesList.addListSelectionListener(this);
    imagesList.setPreferredSize(new Dimension(120, 420));

    setupLayout();
    registerListeners();

  }

  void registerListeners() {
    // TODO dovršiti metodu
  }

  void setupLayout() {
    // TODO dovršiti metodu
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    // TODO dovršiti metodu
  }

  public void updateLabel(String name) {
    ImageIcon icon = images.get(name);
    lbImage.setIcon(icon);
    if (icon != null) {
      lbImage.setText(null);
    } else {
      lbImage.setText("Image(s) not found");
    }
  }

  void downloadFlagImages() {
    // TODO dovršiti metodu
  }

  ImageIcon loadFlagForCountry(String country) {
    try {
      String imageStringPath = String.format("src/main/resources/thumbs/%s/flag-400.png",
          country);
      Path imagePath = Path.of(imageStringPath);
      BufferedImage image = ImageIO.read(Files.newInputStream(imagePath));
      Thread.sleep(slowDownImageLoading ); // slows down loading to see progress bar and status line text
      return new ImageIcon(image);
    } catch (Exception exp) {
      return null;
    }
  }

  void loadFlags() {
    for (String country : countries) {
      images.put(country, loadFlagForCountry(country));
      model.addElement(country);
      //System.out.println("Downloaded: " + country);
    }
  }

  public static void main(String[] args) {
    ImagesDownloader imagesDownloader = new ImagesDownloader();
    SwingUtilities.invokeLater(() -> {
      imagesDownloader.setVisible(true);
    });
  }
}
