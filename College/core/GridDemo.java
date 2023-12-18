import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridDemo {
    public static void frames(){
        // Create a JFrame
        JFrame frame = new JFrame("Buttons");

        // Set layout manager
        frame.setLayout(new BorderLayout()); // 3 rows, 3 columns

        JLabel label = new JLabel("Hello, yeh hai button ka demo");
        
        // Create buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton exit = new JButton("Exit");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               label.setText("button 1 event triggered");
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               label.setText("button 2` event triggered");
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Goodbye!");
                System.exit(0);
            }
        });
        
        // Add buttons to the frame
        frame.add(label, BorderLayout.NORTH);
        JPanel centerJPanel = new JPanel(new GridLayout(3,0));
        centerJPanel.add(button1);
        centerJPanel.add(button2);
        centerJPanel.add(exit);
        frame.add(centerJPanel);
        // Set frame properties
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frames();
            }
        });
    }
}
