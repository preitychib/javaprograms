import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIButtons {
    JButton alpha, beta;
    JLabel label;

    public void display() {
        JFrame frame = new JFrame("Event Handling demo");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        alpha = new JButton("Alpha Supremacy");
        beta = new JButton("Beta chota");
        label = new JLabel("Mera koi kam nhi abhi");
        frame.add(alpha);
        frame.add(beta);
        frame.add(label);

        alpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Alpha Pressed");
            }
        });
        beta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("beta ka turn b aa hi gya");
            }
        });
    }
    public static void main(String[] args) {
        GUIButtons demo = new GUIButtons();
        demo.display();
    }
}
