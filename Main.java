
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Main {
    // main function
    public static void main(String[] args)
    {
        // Create a new JFrame
        JFrame frame = new JFrame("Interface JFrame");

        // Set frame properties
        frame.setSize(700, 500);
        // stop execution when the app window is close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set white background for the JFrame
        frame.getContentPane().setBackground(Color.WHITE);
        //definition of a layout
        frame.setLayout(new BorderLayout());

        // Header

        ImageIcon logoImg = new ImageIcon("C:\\tp10kc\\10kc.jpeg");
        Image scaledImage = logoImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(scaledImage);

        JLabel header= new JLabel("Bienvenue",resizedLogo,JLabel.CENTER );
        header.setHorizontalTextPosition(JLabel.CENTER); // Keep text centered horizontally
        header.setVerticalTextPosition(JLabel.TOP); // Move text above and image below


        frame.add(header, BorderLayout.NORTH);

// Body

       JLabel titleLabel = new JLabel("Nos Services", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Table Data (2 columns, 4 rows)
        String[] columnNames = {"Services", "Frais"};
        Object[][] data = {
                {"Mentor Professionnel- Carière", "10 000 Fr"},
                {"Formation Métier Cible", "0 Fr"},
                {"Mentor Profesionnel - Métier", "20 000 Fr"},
                {"Prise de parole en publique", "2 000 Fr"}
        };

         // Create JTable inside a JScrollPane
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        // Center align table content using DefaultTableCellRenderer
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Apply the renderer to each column (both "Services" and "Fees")
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Services column
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Fees column

        // Make table header bold
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // Center table content
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBackground(Color.WHITE);
        table.setBackground(Color.WHITE);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        // Create a panel to center the content
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(titleLabel, BorderLayout.NORTH);
        centerPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Add panel to the center of the frame
        frame.add(centerPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setLocationRelativeTo(null); // Center window on screen



        // Create a button at the bottom
        JButton soundButton = new JButton("Souscrire");
        soundButton.setFont(new Font("Arial", Font.BOLD, 14));
        soundButton.setBackground(new Color(100, 150, 255));

        // Add an action listener to the button to play sound when clicked
        soundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(); // Specify the path to your sound file
            }
        });

        // Create a panel for the footer and add the button
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.WHITE);
        footerPanel.add(soundButton);

        // Add centerPanel and footerPanel to the frame
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);
        // Make frame visible
        frame.setVisible(true);

    }

    // Method to play sound
    public static void playSound() {
        try {
            // Load the sound file (it should be a .wav file in your project resources)
            // AudioInputStream audioIn = AudioSystem.getAudioInputStream(ServicesTable.class.getResource(soundFile));
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("C:\\tp10kc\\alligator3.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();  // Play the sound
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
