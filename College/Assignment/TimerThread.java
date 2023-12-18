import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerThread {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Timer Example");

        // Create a label to display the message
        JLabel label = new JLabel("Waiting for the timer...");

        // Set up the GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Create a Timer with a 1000 milliseconds (1 second) delay
        int delay = 1000; // milliseconds
        ActionListener timerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This is the function that will be called periodically
                updateLabel(label);
            }
        };
        Timer timer = new Timer(delay, timerAction);
        timer.start();
    }

    private static void updateLabel(JLabel label) {
        // This is the function that will be called periodically by the timer
        String message = "Timer tick: " + System.currentTimeMillis();
        label.setText(message);
        System.out.println(message);
    }
}
